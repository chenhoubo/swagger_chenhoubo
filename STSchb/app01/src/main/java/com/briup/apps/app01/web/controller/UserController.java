package com.briup.apps.app01.web.controller;

import com.briup.apps.app01.bean.Course;
import com.briup.apps.app01.bean.StudentCourse;
import com.briup.apps.app01.bean.User;
import com.briup.apps.app01.service.IStudentCourseService;
import com.briup.apps.app01.service.IUserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IStudentCourseService studentCourseService;
    
    @ApiOperation("查询所有用户")
    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
        List<User> list = userService.findAll();
        return list;
    }

    @ApiOperation("通过id查找用户")
    @GetMapping("getById")
    public User getById(Long id) throws Exception{
        User user = userService.findById(id);
        return user;
    }

    @ApiOperation("保存/更新")
    @ApiImplicitParam(name = "type", value = "type,只能填写teacher或者student", required = true, paramType="query")
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(User user) throws Exception{
    	return userService.saveOrUpdate(user);
    }
    
    @ApiOperation("根据 学生 id查找所有的课程")
    @PostMapping("findCoursesByStudentId")
    public List<Course> findCoursesByStudentId(Long id) throws Exception{
        List<Course> list = userService.findCoursesByStudentId(id);
        return list;
    }
    @ApiOperation("根据 教师 id查找所有的课程")
    @PostMapping("findCoursesByTeacherId")
    public List<Course> findCoursesByTeacherId(Long id) throws Exception{
        List<Course> list = userService.findCoursesByTeacherId(id);
        return list;
    }
    @ApiOperation("删除所有的用户")
    @PostMapping("deleteAllUser")
    public String deleteAllUser() throws Exception{
        userService.deleteAllUser();
        return "删除成功";
    }
    @ApiOperation("根据用户id删除用户")
    @PostMapping("deleteUserByUserId")
    public String deleteUserByUserId(Long id) throws Exception{
        userService.deleteUserByUserId(id);
        return "删除成功";
    }
    @ApiOperation("学生选课接口")
    @PostMapping("saveSC")
    public String saveSC(StudentCourse sc) throws Exception{
    	return studentCourseService.saveSC(sc);
    }
    
    @ApiOperation("用户登录")
    @GetMapping("login")
    public List<String> login(User user) throws Exception{
        return userService.login(user);
    }
}
