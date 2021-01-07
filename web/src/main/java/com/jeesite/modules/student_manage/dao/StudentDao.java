/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student_manage.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.student_manage.entity.Student;

/**
 * 学生信息表DAO接口
 * @author wxr
 * @version 2021-01-07
 */
@MyBatisDao
public interface StudentDao extends CrudDao<Student> {
	
}