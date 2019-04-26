package com.briup.apps.app01.bean.extend;

import java.util.List;

import com.briup.apps.app01.bean.Course;
import com.briup.apps.app01.bean.User;

public class UserExtend extends User {
	// 用户的所有课程模型
    private List<Course> list;

	public List<Course> getList() {
		return list;
	}

	public void setList(List<Course> list) {
		this.list = list;
	}
    
}
