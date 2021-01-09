/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.myuser.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.myuser.entity.MyUser;

/**
 * 用户表DAO接口
 * @author wxr
 * @version 2021-01-09
 */
@MyBatisDao
public interface MyUserDao extends CrudDao<MyUser> {
	
}