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
    void saveOrUpdate(User user) throws Exception;

    /**
     * @Description: 根据学生id查找出所有的课程
     * @Param: []
     * @return: void
     * @Author: charles
     * @Date: 2019-04-18
     */
    List<Course> findCoursesByUserId(Long id) throws Exception;
}
