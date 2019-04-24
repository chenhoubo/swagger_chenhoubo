package com.briup.apps.app01.bean.extend;

import com.briup.apps.app01.bean.Course;
import com.briup.apps.app01.bean.User;

/**
 * @program: xn_app02
 * @description: 课程类的拓展类
 * @author: charles
 * @create: 2019-04-19 09:33
 **/

public class CourseExtend extends Course {
    // 任教老师模型
    private User teacher;

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}



