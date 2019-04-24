package com.briup.apps.app01.service.impl;

import com.briup.apps.app01.bean.*;
import com.briup.apps.app01.bean.extend.CourseExtend;
import com.briup.apps.app01.mapper.CourseMapper;
import com.briup.apps.app01.mapper.StudentCourseMapper;
import com.briup.apps.app01.mapper.UserMapper;
import com.briup.apps.app01.mapper.extend.CourseExtendMapper;
import com.briup.apps.app01.service.ICourseService;
import com.briup.apps.app01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private CourseExtendMapper courseExtendMapper;

    @Override
    public List<CourseExtend> findCourseAndTeacher() {
        return courseExtendMapper.selectAll();
    }

    @Override
    public List<Course> findAll() {
        CourseExample example = new CourseExample();
        List<Course> list = courseMapper.selectByExample(example);
        return list;
    }

    @Override
    public Course findById(Long id) {
        if(id == null){
            return null;
        }else{
//            CourseExample example = new CourseExample();
//            example.createCriteria().andIdEqualTo(id);
            Course course = courseMapper.selectByPrimaryKey(id);
//            List<Course> list = courseMapper.selectByExample(example);
            return course;
        }
    }

    @Override
    public void saveOrUpdate(Course course) throws Exception {
        System.out.println("course:" + course);
        if(course.getId() == null){
            courseMapper.insert(course);
            StudentCourse sc = new StudentCourse();
            sc.setChooseTime(new Date().getTime());

            CourseExample example = new CourseExample();
            example.createCriteria().andNameEqualTo(course.getName()).andCreditEqualTo(course.getCredit());
            List<Course> list =  courseMapper.selectByExample(example);

            sc.setCourseId(list.get(0).getId());
            sc.setStudentId(course.getTeacherId());
            sc.setGrade(1);
            studentCourseMapper.insert(sc);
        } else {
            courseMapper.updateByPrimaryKey(course);
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> findStudentsBycourseId(Long id){
        if(id == null){
            return null;
        }else{
            StudentCourseExample example = new StudentCourseExample();
            example.createCriteria().andCourseIdEqualTo(id);
            List<StudentCourse> list = studentCourseMapper.selectByExample(example);
            UserExample example1 = new UserExample();
            UserExample.Criteria criteria = example1.createCriteria();
            List<Long> lv = new ArrayList<>();
            for (StudentCourse sc: list) {
                lv.add(sc.getStudentId());
            }
            criteria.andIdIn(lv);
            List<User> userList = userMapper.selectByExample(example1);
            return userList;
        }
    }

    @Override
    public User findTeacherBycourseId(Long id) throws Exception {
        if(id == null){
            return null;
        }else{
            Course course = findById(id);
            User user = userService.findById(course.getTeacherId());
            return user;
        }
    }
}
