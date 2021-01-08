/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.manager.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.manager.entity.Manager;

/**
 * 管理员信息管理DAO接口
 * @author wxr
 * @version 2021-01-08
 */
@MyBatisDao
public interface ManagerDao extends CrudDao<Manager> {
	
}