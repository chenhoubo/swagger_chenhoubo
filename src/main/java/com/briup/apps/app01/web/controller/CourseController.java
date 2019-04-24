package com.briup.apps.app01.web.controller;

import com.briup.apps.app01.bean.Course;
import com.briup.apps.app01.bean.User;
import com.briup.apps.app01.bean.extend.CourseExtend;
import com.briup.apps.app01.service.ICourseService;
import com.briup.apps.app01.util.Message;
import com.briup.apps.app01.util.MessageUtil;
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

    /**
     * @Description: 获取所有用户信息
     * @Param: []
     * @return: java.util.List<com.briup.apps.xn_app02.bean.User>
     * @Author: charles
     * @Date: 2019-04-18
     */
    @GetMapping("getAllCourses")
    public List<Course> getAllCourses(){
        List<Course> list = courseService.findAll();
        return list;
    }

    /**
     * @Description: 通过id查找课程信息
     * @Param: [id]
     * @return: com.briup.apps.xn_app02.bean.User
     * @Author: charles
     * @Date: 2019-04-18
     */
    @GetMapping("getById")
    public Course getById(Long id) throws Exception{
        Course course = courseService.findById(id);
        return course;
    }

    /**
     * @Description: 保存更新
     * @Param: [user]
     * @return: java.lang.String
     * @Author: charles
     * @Date: 2019-04-18
     */
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(Course course) throws Exception{
        courseService.saveOrUpdate(course);
        return "保存成功！";
    }
    /**
     * @Description: 输出一门课程
     * @Param: [user]
     * @return: java.lang.String
     * @Author: charles
     * @Date: 2019-04-18
     */
    @PostMapping("deleteById")
    public String deleteById(Long id) throws Exception{
        courseService.deleteById(id);
        return "删除成功";
    }
    /**
     * @Description: 根据课程id查找出所有的学生
     * @Param: [user]
     * @return: java.lang.String
     * @Author: charles
     * @Date: 2019-04-18
     */
    @PostMapping("findCoursesByUserId")
    public List<User> findCoursesByUserId(Long id) throws Exception{
        List<User> list = courseService.findStudentsBycourseId(id);
        return list;
    }

    /**
     * @Description: 根据课程id查找对应的老师
     * @Param: [user]
     * @return: java.lang.String
     * @Author: charles
     * @Date: 2019-04-18
     */
    @PostMapping("findTeacherBycourseId")
    public User findTeacherBycourseId(Long id) throws Exception{
        User user = courseService.findTeacherBycourseId(id);
        return user;
    }
}
