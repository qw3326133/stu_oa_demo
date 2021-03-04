package org.lrh.service.impl;

import org.apache.catalina.User;
import org.lrh.dao.StuDao;
import org.lrh.entity.po.Stu;
import org.lrh.entity.vo.StuData;
import org.springframework.stereotype.Service;
import org.lrh.service.StuService;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cyl
 * @create 2021-03-04 14:59
 */
@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StuDao stuDao;

    @Override
    public Map queryData(StuData stuData) {
        Map map = new HashMap<>();
        Integer count = stuDao.queryDataCount(stuData);
        List<Stu> st = stuDao.queryListDataByParams(stuData);
        map.put("count",count);
        map.put("list",st);
        return map;
    }

    @Override
    public void addStu(Stu stu) {
        stuDao.addStu(stu);
    }

    @Override
    public void deleteStuById(Integer id) {
        stuDao.deleteStuById(id);
    }

    @Override
    public Stu huixian(Integer id) {
        return stuDao.huixian(id);
    }

    @Override
    public void updateStu(Stu stu) {
        stuDao.updateStu(stu);
    }

}
