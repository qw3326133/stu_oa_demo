package org.lrh.dao;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.lrh.entity.po.Stu;
import org.lrh.entity.vo.StuData;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author cyl
 * @create 2021-03-04 15:26
 */

public interface StuDao {
    Integer queryDataCount(StuData stuData);

    List<Stu> queryListDataByParams(StuData stuData);

    void addStu(Stu stu);

    void deleteStuById(Integer id);

    Stu huixian(Integer id);

    void updateStu(Stu stu);
}
