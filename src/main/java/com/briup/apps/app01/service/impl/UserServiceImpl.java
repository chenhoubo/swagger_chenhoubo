package com.briup.apps.app01.service.impl;

import com.briup.apps.app01.bean.*;
import com.briup.apps.app01.mapper.CourseMapper;
import com.briup.apps.app01.mapper.UserMapper;
import com.briup.apps.app01.service.ICourseService;
import com.briup.apps.app01.service.IStudentCourseService;
import com.briup.apps.app01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: app01
 * @description: 用户接口实现类
 * @author: 
 * @create: 2019-04-18 12:05
 **/
@Service
public class UserServiceImpl implements IUserService {



    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private IStudentCourseService studentCourseService;
    @Autowired
    private ICourseService courseService;

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
            if(list.size() == 0) {
    			return null;
    		}else {
    			return list.get(0);
    		}
        }
    }

    @Override
    public String saveOrUpdate(User user) throws Exception {
    	if("student".equals(user.getType()) || "teacher".equals(user.getType())) {
    		if(user.getId() == null){
    			userMapper.insert(user);
    			return "插入成功";
    		} else {
    			userMapper.updateByPrimaryKey(user);
    			return "更新成功";
    		}
    	}else {
    		return "用户type输入不合法！";
    	}
    }

    @Override
    public List<Course> findCoursesByStudentId(Long id) throws Exception{
        List<StudentCourse> list = studentCourseService.findSCsByStudentId(id);
        if(list.size() == 0) {//该学生没有选课
        	return null;
        }else {
        	CourseExample example1 = new CourseExample();
            CourseExample.Criteria criteria = example1.createCriteria();
            List<Long> lv = new ArrayList<>();
            for (StudentCourse sc: list) {
                lv.add(sc.getCourseId());
            }
            criteria.andIdIn(lv);
            List<Course> courseList = courseMapper.selectByExample(example1);
            return courseList;
        }
    }
    @Override
	public List<Course> findCoursesByTeacherId(Long id) throws Exception {
		List<Course> list = courseService.findByTeacherId(id);
		return list;
	}
	@Override
	public void deleteAllUser() throws Exception {
		//删除桥表中的内容
		studentCourseService.deleteAllSC();
		//更改课程 表中的内容
		CourseExample example2 = new CourseExample();
		example2.createCriteria().andTeacherIdIsNotNull();
		List<Course> list = courseMapper.selectByExample(example2);
		for (Course course : list) {
			course.setTeacherId(null);
			courseService.saveOrUpdate(course);
		}
		//最后删除user表中内容
		UserExample example = new UserExample();
		example.createCriteria().andIdIsNotNull();
		userMapper.deleteByExample(example);
	}

	@Override
	public void deleteUserByUserId(Long id) throws Exception {
		System.out.println("deleteUserByUserId: id=" + id );
		StudentCourse studentCourse = studentCourseService.findSCByStudentId(id);
		if(studentCourse != null) {
			studentCourseService.deleteSCByUserId(id);
		}
		List<Course> list = courseService.findByTeacherId(id);
		if(list.size() != 0) {
			for (Course course : list) {
				course.setTeacherId(null);
				courseService.saveOrUpdate(course);
			}
		}
		userMapper.deleteByPrimaryKey(id);
	}

	
}
