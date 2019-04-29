package com.briup.apps.app01.service;

import com.briup.apps.app01.bean.Course;
import com.briup.apps.app01.bean.User;

import java.util.List;

public interface IUserService {
    /** 
     * @Description: 查询所有
     * @Param: [] 
     * @return: java.util.List<com.briup.apps.xn_app02.bean.User> 
     * @Author: charles 
     * @Date: 2019-04-18 
     */ 
    List<User> findAll();

    /**
     * @Description: 查找出一个
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-18
     */
    User findById(Long id) throws Exception;

    /** 
     * @Description: 保存或更新
     * @Param: [] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-04-18 
     */ 
    String saveOrUpdate(User user) throws Exception;

    /**
     * @Description: 根据用户username查找出该学生的课程
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-18
     */
    User findUserByUsername(String username) throws Exception;
    
    /**
     * @Description: 根据学生id查找出该学生的课程
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-18
     */
    List<Course> findCoursesByStudentId(Long id) throws Exception;
    /**
     * @Description: 根据教师id查找出该教师的课程
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-18
     */
    List<Course> findCoursesByTeacherId(Long id) throws Exception;
    /**
     * @Description: 删除所有的用户
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-26
     */
    void deleteAllUser() throws Exception;
    /**
     * @Description: 根据id删除用户
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-26
     */
    void deleteUserByUserId(Long id) throws Exception;
    
    /**
     * @Description: 用户登录
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-26
     */
    List<String> login(User user) throws Exception;
}
