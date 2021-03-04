package org.lrh.service;

import org.apache.catalina.User;
import org.lrh.entity.po.Stu;
import org.lrh.entity.vo.StuData;

import java.util.Map;

/**
 * @author cyl
 * @create 2021-03-04 14:58
 */
public interface StuService {
    Map queryData(StuData stuData);

    void addStu(Stu stu);

    void deleteStuById(Integer id);

    Stu huixian(Integer id);

    void updateStu(Stu stu);
}
