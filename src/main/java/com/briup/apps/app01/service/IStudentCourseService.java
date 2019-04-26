package com.briup.apps.app01.service;

import java.util.List;

import com.briup.apps.app01.bean.StudentCourse;

/**
 * 桥表相关接口
 */
public interface IStudentCourseService {

	/**
     * @Description: 删除桥表所有的信息
     * @Param: []
     * @return: 
     * @Author: 
     * @Date: 2019-04-26
     */
    void deleteAllSC() throws Exception;

    /**
     * @Description: 根据id删除记录
     * @Param: []
     * @return: 
     * @Author: 
     * @Date: 2019-04-26
     */
    void deleteSCById(Long id) throws Exception;
    
    /**
     * @Description: 根据user_id删除记录
     * @Param: []
     * @return: 
     * @Author: 
     * @Date: 2019-04-26
     */
    void deleteSCByUserId(Long id) throws Exception;
    
    /**
     * @Description: 根据course_id删除记录
     * @Param: []
     * @return: 
     * @Author: 
     * @Date: 2019-04-26
     */
    void deleteSCByCourseId(Long id) throws Exception;
    
    /**
     * @Description: 根据id查找记录
     * @Param: []
     * @return: 
     * @Author: 
     * @Date: 2019-04-26
     */
    StudentCourse findSCById(Long id) throws Exception;
    
    /**
     * @Description: 根据student_id查找记录
     * @Param: []
     * @return: 
     * @Author: 
     * @Date: 2019-04-26
     */
    StudentCourse findSCByStudentId(Long id) throws Exception;
    
    /**
     * @Description: 根据student_id查找记录
     * @Param: []
     * @return: 
     * @Author: 
     * @Date: 2019-04-26
     */
    List<StudentCourse> findSCsByStudentId(Long id) throws Exception;
    
    /**
     * @Description: 根据course_id查找记录
     * @Param: []
     * @return: 
     * @Author: 
     * @Date: 2019-04-26
     */
    StudentCourse findSCByCourseId(Long id) throws Exception;
    
    /**
     * @Description: 学生选课
     * @Param: []
     * @return: 
     * @Author: 
     * @Date: 2019-04-26
     */
    String saveSC(StudentCourse sc) throws Exception;
}
