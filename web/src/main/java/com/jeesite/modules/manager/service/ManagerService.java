/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.manager.entity.Manager;
import com.jeesite.modules.manager.dao.ManagerDao;

/**
 * 管理员信息管理Service
 * @author wxr
 * @version 2021-01-08
 */
@Service
@Transactional(readOnly=true)
public class ManagerService extends CrudService<ManagerDao, Manager> {
	
	/**
	 * 获取单条数据
	 * @param manager
	 * @return
	 */
	@Override
	public Manager get(Manager manager) {
		return super.get(manager);
	}
	
	/**
	 * 查询分页数据
	 * @param manager 查询条件
	 * @param manager.page 分页对象
	 * @return
	 */
	@Override
	public Page<Manager> findPage(Manager manager) {
		return super.findPage(manager);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param manager
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Manager manager) {
		super.save(manager);
	}
	
	/**
	 * 更新状态
	 * @param manager
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Manager manager) {
		super.updateStatus(manager);
	}
	
	/**
	 * 删除数据
	 * @param manager
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Manager manager) {
		super.delete(manager);
	}
	
}