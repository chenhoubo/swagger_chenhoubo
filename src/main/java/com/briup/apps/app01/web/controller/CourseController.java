package com.briup.apps.app01.web.controller;

import com.briup.apps.app01.bean.Course;
import com.briup.apps.app01.bean.User;
import com.briup.apps.app01.bean.extend.CourseExtend;
import com.briup.apps.app01.service.ICourseService;
import com.briup.apps.app01.util.Message;
import com.briup.apps.app01.util.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @ApiOperation("查询所有课程信息，课程信息中级联了任课老师")
    @GetMapping("getAllCoursesAndTeachers")
    public Message getAll(){
        List<CourseExtend> list = courseService.findCourseAndTeacher();
        return MessageUtil.success(list);
    }

    @ApiOperation("查询所有课程信息")
    @GetMapping("getAllCourses")
    public Message getAllCourses(){
        List<Course> list = courseService.findAll();
        return  MessageUtil.success(list);
    }

    
    @ApiOperation(value="获取课程详细信息", notes="根据url的id来获取课程详细信息")
    @ApiImplicitParam(name = "id", value = "课程ID", required = true, dataType = "Long",paramType="query")
    @GetMapping("getById")
    public Message getById(Long id) throws Exception{
        Course course = courseService.findById(id);
        return MessageUtil.success(course);
    }

    @ApiOperation("保存更新")
    @ApiImplicitParam(name = "teacherId", value = "只能填写教师id", required = true, paramType="query")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Course course) throws Exception{
    	String msg = courseService.saveOrUpdate(course);
        return MessageUtil.success(msg);
    }
    @ApiOperation("根据id删除课程")
    @PostMapping("deleteById")
    public Message deleteById(Long id) throws Exception{
        courseService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    
    @ApiOperation("删除所有课程")
    @PostMapping("deleteAllCourse")
    public Message deleteAllCourse() throws Exception{
        courseService.deleteAllCourse();
        return MessageUtil.success("删除成功");
    }

    @ApiOperation("根据课程id查询对应的老师")
    @PostMapping("findTeacherBycourseId")
    public Message findTeacherBycourseId(Long id) throws Exception{
        User user = courseService.findTeacherBycourseId(id);
        return MessageUtil.success(user);
    }
}
