/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.course.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.course.entity.Course;

/**
 * 课程表DAO接口
 * @author wjx
 * @version 2021-01-08
 */
@MyBatisDao
public interface CourseDao extends CrudDao<Course> {
	
}