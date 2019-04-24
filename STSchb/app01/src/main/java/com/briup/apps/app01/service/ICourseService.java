package com.briup.apps.app01.service;

import com.briup.apps.app01.bean.Course;
import com.briup.apps.app01.bean.User;
import com.briup.apps.app01.bean.extend.CourseExtend;

import java.util.List;

/**
 * 课程相关接口
 */
public interface ICourseService {
    /**
     * @Description: 查询所有课程包括老师
     * @Param: []
     * @return: java.util.List<com.briup.apps.app01.bean.User>
     * @Author: charles
     * @Date: 2019-04-18
     */
    List<CourseExtend> findCourseAndTeacher();

    /**
     * @Description: 查询所有课程
     * @Param: []
     * @return: java.util.List<com.briup.apps.app01.bean.User>
     * @Author: charles
     * @Date: 2019-04-18
     */
    List<Course> findAll();

    /**
     * @Description: 根据id查找课程
     * @Param: []
     * @return: java.util.List<com.briup.apps.app01.bean.User>
     * @Author: charles
     * @Date: 2019-04-18
     */
    Course findById(Long id) throws Exception;

    /**
     * @Description: 插入一门课程
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-18
     */
    void saveOrUpdate(Course course) throws Exception;

    /**
     * @Description: 删除一门课程
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-18
     */
    void deleteById(Long id) throws Exception;

    /**
     * @Description: 根据课程id查找所有的学生
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-18
     */
    List<User> findStudentsBycourseId(Long id) throws Exception;

    /**
     * @Description: 根据课程id查找对应的老师
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-18
     */
    User findTeacherBycourseId(Long id) throws Exception;

}
