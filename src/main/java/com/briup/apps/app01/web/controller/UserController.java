package com.briup.apps.app01.web.controller;

import com.briup.apps.app01.bean.Course;
import com.briup.apps.app01.bean.User;
import com.briup.apps.app01.service.IUserService;
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
    /**
     * @Description: 获取所有用户信息
     * @Param: []
     * @return: java.util.List<com.briup.apps.xn_app02.bean.User>
     * @Author: charles
     * @Date: 2019-04-18
     */
    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
        List<User> list = userService.findAll();
        return list;
    }

    /**
     * @Description: 通过id查找用户信息
     * @Param: [id]
     * @return: com.briup.apps.xn_app02.bean.User
     * @Author: charles
     * @Date: 2019-04-18
     */
    @GetMapping("getById")
    public User getById(Long id) throws Exception{
        User user = userService.findById(id);
        return user;
    }

    /**
     * @Description: 保存更新
     * @Param: [user]
     * @return: java.lang.String
     * @Author: charles
     * @Date: 2019-04-18
     */
    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(User user) throws Exception{
        userService.saveOrUpdate(user);
        return "保存成功！";
    }
    /**
     * @Description: 根据学生id查找出所有的课程
     * @Param: [user]
     * @return: java.lang.String
     * @Author: charles
     * @Date: 2019-04-18
     */
    @PostMapping("findCoursesByUserId")
    public List<Course> findCoursesByUserId(Long id) throws Exception{
        List<Course> list = userService.findCoursesByUserId(id);
        return list;
    }
}
