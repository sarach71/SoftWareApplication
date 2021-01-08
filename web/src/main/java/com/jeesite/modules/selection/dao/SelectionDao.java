/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.selection.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.selection.entity.Selection;

/**
 * 选课信息管理DAO接口
 * @author wxr
 * @version 2021-01-08
 */
@MyBatisDao
public interface SelectionDao extends CrudDao<Selection> {
	
}