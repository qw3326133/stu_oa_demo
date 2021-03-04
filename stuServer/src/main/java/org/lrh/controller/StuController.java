package org.lrh.controller;

import org.lrh.entity.po.Stu;
import org.lrh.entity.vo.ResultData;
import org.lrh.entity.vo.StuData;
import org.lrh.service.StuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Map;


@RestController
@RequestMapping("api/stu")
@CrossOrigin
public class StuController {
@Resource
    private StuService stuService;
    @GetMapping("queryStu")
    public ResultData queryUser(StuData stuData){
        if (stuData.getStart()==null){
            return ResultData.error(500,"参数错误");
        }
        if (stuData.getSize()==null){
            return ResultData.error(500,"参数错误");
        }
        Map map=  stuService.queryData(stuData);
        return ResultData.success(map);
    }
    @PostMapping("addStu")
    public ResultData addUser(Stu stu){
        stuService.addStu(stu);
        return ResultData.success("");
    }
    @GetMapping("deleteStuById")
    public ResultData deleteStuById(Integer id){
        if (id==null){
            return ResultData.error(500,"参数错误");
        }
        stuService.deleteStuById(id);
        return ResultData.success("");
    }

    @GetMapping("selectStuById")
    public ResultData huixian(Integer id){
        if (id==null){
            return ResultData.error(500,"参数错误");
        }
        Stu stu=stuService.huixian(id);
        return ResultData.success(stu);
    }
        @PostMapping("updateStu")
    public ResultData updateStu(Stu stu){
        if (stu.getId()==null){
            return ResultData.error(500,"参数错误");
        }
        stuService.updateStu(stu);
        return ResultData.success("");
    }
}
