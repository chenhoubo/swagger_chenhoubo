package com.briup.apps.app01.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.app01.bean.StudentCourse;
import com.briup.apps.app01.bean.StudentCourseExample;
import com.briup.apps.app01.bean.User;
import com.briup.apps.app01.mapper.StudentCourseMapper;
import com.briup.apps.app01.service.IStudentCourseService;
import com.briup.apps.app01.service.IUserService;

@Service
public class StudentCourseServiceImpl implements IStudentCourseService {

	@Autowired
	private StudentCourseMapper studentCourseMapper;
	@Autowired
	private IUserService userService;
	
	@Override
	public void deleteAllSC() throws Exception {
		StudentCourseExample example = new StudentCourseExample();
		example.createCriteria().andIdIsNotNull();
		studentCourseMapper.deleteByExample(example);
	}

	@Override
	public void deleteSCById(Long id) throws Exception {
		studentCourseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteSCByUserId(Long id) throws Exception {
		StudentCourseExample example = new StudentCourseExample();
		example.createCriteria().andStudentIdEqualTo(id);
		studentCourseMapper.deleteByExample(example);
	}

	@Override
	public void deleteSCByCourseId(Long id) throws Exception {
		StudentCourseExample example = new StudentCourseExample();
		example.createCriteria().andCourseIdEqualTo(id);
		studentCourseMapper.deleteByExample(example);
	}

	@Override
	public StudentCourse findSCById(Long id) throws Exception {
		StudentCourse studentCourse = studentCourseMapper.selectByPrimaryKey(id);
		return studentCourse;
	}

	@Override
	public StudentCourse findSCByStudentId(Long id) throws Exception {
		StudentCourseExample example = new StudentCourseExample();
		example.createCriteria().andStudentIdEqualTo(id);
		List<StudentCourse> list = studentCourseMapper.selectByExample(example);
		if(list.size() == 0) {
			return null;
		}else {
			return list.get(0);
		}
	}
	
	@Override
	public List<StudentCourse> findSCsByStudentId(Long id) throws Exception {
		StudentCourseExample example = new StudentCourseExample();
		example.createCriteria().andStudentIdEqualTo(id);
		List<StudentCourse> list = studentCourseMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public StudentCourse findSCByCourseId(Long id) throws Exception {
		StudentCourseExample example = new StudentCourseExample();
		example.createCriteria().andCourseIdEqualTo(id);
		List<StudentCourse> list = studentCourseMapper.selectByExample(example);
		if(list.size() == 0) {
			return null;
		}else {
			return list.get(0);
		}
	}

	@Override
	public String saveSC(StudentCourse sc) throws Exception {
		User user = userService.findById(sc.getStudentId());
		StudentCourseExample example = new StudentCourseExample();
		example.createCriteria().andStudentIdEqualTo(sc.getStudentId()).andCourseIdEqualTo(sc.getCourseId());
		List<StudentCourse> list = studentCourseMapper.selectByExample(example);
		if(list.size() == 0) {
			if("student".equals(user.getType())) {
				sc.setChooseTime(new Date().getTime());
		        //sc.setGrade(1);
		        studentCourseMapper.insert(sc);
		        return "选课成功";
			}else {
				return "当前用户不是学生身份！";
			}
		}else {
			return "该学生已经选取了这门课程";
		}
	}

	

}
