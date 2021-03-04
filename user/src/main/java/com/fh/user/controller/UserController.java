package com.fh.user.controller;

import com.fh.user.model.User;
import com.fh.user.service.UserService;
import com.fh.user.vo.RespData;
import com.fh.user.vo.UserVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("UserController")
public class UserController {
    @Resource
    private UserService us;
    /*http://localhost:9002/UserController/zc
     *注册
     * */
    @PostMapping("zc")
    public RespData zc(User user){
        us.zc(user);
        return RespData.success(null);
    }
    /*http://localhost:9002/UserController/chaByName
     * 根据name查询
     * 取数据（以dd为例）dd.data.mess
     * mess=1 有数据 mess=2 无数据
     * */
    @PostMapping("chaByName")
    public RespData chaByName(String name){
        Map map=us.chaByName(name);
        return RespData.success(map);
    }
    /*http://localhost:9002/UserController/dl
    * 登录
    *取值（以dd为例）
    * dd.data.data:token值
    * dd.data.mess:状态码
    * mess=1 正常登录
    * mess=2 密码错误
    * mess=3 没有账号
    * */
    @PostMapping("dl")
    public RespData dl(User user){
        Map map=us.dl(user);
        return RespData.success(map);
    }
    /*http://localhost:9002/UserController/upUser
     * 根据name修改
     * */
    @PostMapping("upUser")
    public RespData upUser(User user){
        us.upUser(user);
        return RespData.success(null);
    }
    /*http://localhost:9002/UserController/delUser
    * 根据name删除
    * */
    @PostMapping("delUser")
    public RespData delUser(String name){
        us.delUser(name);
        return RespData.success(null);
    }
    /*http://localhost:9002/UserController/chaUser
    * 分页查询
    * page：页数 limit：条数 查询条件 ：name
    * 取数据（以dd为例）：dd.data.li(取数据) dd.data.count(取总条数)
    * */
    @PostMapping("chaUser")
    public RespData chaUser(UserVo uv){
        if (uv.getPage()==null){
            return RespData.error(500,"关键数据为空");
        }
        if (uv.getLimit()==null){
            return RespData.error(500,"关键数据为空");
        }
        Map map=us.chaUser(uv);
        return RespData.success(map);
    }
}
