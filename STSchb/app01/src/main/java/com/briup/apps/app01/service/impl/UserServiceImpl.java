package com.briup.apps.app01.service.impl;

import com.briup.apps.app01.bean.*;
import com.briup.apps.app01.mapper.CourseMapper;
import com.briup.apps.app01.mapper.StudentCourseMapper;
import com.briup.apps.app01.mapper.UserMapper;
import com.briup.apps.app01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: app01
 * @description: 用户接口实现类
 * @author: charles
 * @create: 2019-04-18 12:05
 **/
@Service
public class UserServiceImpl implements IUserService {



    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<User> findAll() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public User findById(Long id) throws Exception {
        if(id == null){
            return null;
        }else{
            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(id);
            List<User> list = userMapper.selectByExample(example);
            return list.get(0);
        }
    }

    @Override
    public void saveOrUpdate(User user) throws Exception {
        System.out.println("user:" + user);
        if(user.getId() == null){
            userMapper.insert(user);
        } else {
            userMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public List<Course> findCoursesByUserId(Long id) {
        StudentCourseExample example = new StudentCourseExample();
        example.createCriteria().andStudentIdEqualTo(id);
        List<StudentCourse> list = studentCourseMapper.selectByExample(example);
        CourseExample example1 = new CourseExample();
        CourseExample.Criteria criteria = example1.createCriteria();
        List<Long> lv = new ArrayList<>();
        for (StudentCourse sc: list) {
            lv.add(sc.getStudentId());
        }
        criteria.andIdIn(lv);

        List<Course> courseList = courseMapper.selectByExample(example1);
        return courseList;
    }
}
