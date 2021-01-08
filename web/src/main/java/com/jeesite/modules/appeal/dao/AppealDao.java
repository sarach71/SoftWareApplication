/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.appeal.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.appeal.entity.Appeal;

/**
 * 申诉管理DAO接口
 * @author qy
 * @version 2021-01-08
 */
@MyBatisDao
public interface AppealDao extends CrudDao<Appeal> {
	
}