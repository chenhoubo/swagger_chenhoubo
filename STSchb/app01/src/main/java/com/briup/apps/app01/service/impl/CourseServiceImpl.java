package com.briup.apps.app01.service.impl;

import com.briup.apps.app01.bean.*;
import com.briup.apps.app01.bean.extend.CourseExtend;
import com.briup.apps.app01.mapper.CourseMapper;
import com.briup.apps.app01.mapper.extend.CourseExtendMapper;
import com.briup.apps.app01.service.ICourseService;
import com.briup.apps.app01.service.IStudentCourseService;
import com.briup.apps.app01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseExtendMapper courseExtendMapper;
    @Autowired
    private IUserService userService;
    @Autowired
    private IStudentCourseService studentCourseService;

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
            Course course = courseMapper.selectByPrimaryKey(id);
            return course;
        }
    }

    @Override
    public String saveOrUpdate(Course course) throws Exception {
    	User teacher = userService.findById(course.getTeacherId());
    	if(course.getTeacherId() != null) {
    		if(teacher == null) {
    			return "输入的用户id不合法，或者不存在！";
    		}else if("student".equals(teacher.getType())){
    			return "您输入的是学生id，请输入教师id";
    		}
    	}
    	if(course.getId() == null){
            courseMapper.insert(course);
            return "插入成功";
        } else {
            courseMapper.updateByPrimaryKey(course);
            return "更新成功";
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
    	studentCourseService.deleteSCByCourseId(id);
        courseMapper.deleteByPrimaryKey(id);
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

	@Override
	public void deleteAllCourse() throws Exception {
		studentCourseService.deleteAllSC();
		CourseExample example = new CourseExample();
		example.createCriteria().andIdIsNotNull();
		courseMapper.deleteByExample(example);
	}

	@Override
	public List<Course> findByTeacherId(Long id) throws Exception {
		CourseExample example = new CourseExample();
		example.createCriteria().andTeacherIdEqualTo(id);
		List<Course> list = courseMapper.selectByExample(example);
		return list;
	}
}
