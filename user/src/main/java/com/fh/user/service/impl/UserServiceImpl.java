package com.fh.user.service.impl;

import com.fh.user.model.User;
import com.fh.user.service.UserService;
import com.fh.user.utils.JWT;
import com.fh.user.vo.UserVo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private MongoTemplate mt;
    @Override
    public void zc(User user) {
                user.setCreateDate(new Date());
                mt.save(user);
    }

    @Override
    public Map chaByName(String name) {
        Map map=new HashMap();
        User yz = mt.findOne(new Query(Criteria.where("name").is(name)), User.class);
        if (yz!=null){
            map.put("mess",1);
        }else {
            map.put("mess",2);
        }
        return map;
    }

    @Override
    public Map dl(User user) {
        String usto="";
        Map map=new HashMap();
        User yz = mt.findOne(new Query(Criteria.where("name").is(user.getName())), User.class);
        if (yz!=null){
            if (yz.getPassword().equals(user.getPassword())){
                Map map1=new HashMap();
                map1.put("name",user.getName());
                map1.put("password",user.getPassword());
                usto= JWT.sign(map1,60*60*24);
                map.put("data",usto);
                map.put("mess",1);
            }else {
                map.put("mess",3);
            }
        }else {
            map.put("mess",2);
        }
        return map;
    }

    @Override
    public void upUser(User user) {
        Query query=new Query();
        query.addCriteria(Criteria.where("name").is(user.getName()));
        Update update=Update.update("password",user.getPassword()).set("name",user.getName());
        mt.updateFirst(query,update, User.class);
    }

    @Override
    public void delUser(String name) {
        Query query=Query.query(Criteria.where("name").is(name));
        mt.remove(query, User.class);
    }

    @Override
    public Map chaUser(UserVo uv) {
        Map map=new HashMap();
        Query query=new Query();
        if (uv.getName() != null && !uv.getName().equals("")) {
            Pattern pattern=Pattern.compile("^.*"+uv.getName()+".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("name").regex(pattern));
        }
        long count = mt.count(query, User.class);
        Pageable pb= PageRequest.of(uv.getPage()-1,uv.getLimit());
        query.with(pb);
        List<User> li=mt.find(query, User.class);
        map.put("count",count);
        map.put("li",li);
        return map;
    }

}
