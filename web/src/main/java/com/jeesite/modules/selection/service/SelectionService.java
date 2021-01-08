/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.selection.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.selection.entity.Selection;
import com.jeesite.modules.selection.dao.SelectionDao;

/**
 * 选课信息管理Service
 * @author wxr
 * @version 2021-01-08
 */
@Service
@Transactional(readOnly=true)
public class SelectionService extends CrudService<SelectionDao, Selection> {
	
	/**
	 * 获取单条数据
	 * @param selection
	 * @return
	 */
	@Override
	public Selection get(Selection selection) {
		return super.get(selection);
	}
	
	/**
	 * 查询分页数据
	 * @param selection 查询条件
	 * @param selection.page 分页对象
	 * @return
	 */
	@Override
	public Page<Selection> findPage(Selection selection) {
		return super.findPage(selection);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param selection
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Selection selection) {
		super.save(selection);
	}
	
	/**
	 * 更新状态
	 * @param selection
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Selection selection) {
		super.updateStatus(selection);
	}
	
	/**
	 * 删除数据
	 * @param selection
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Selection selection) {
		super.delete(selection);
	}
	
}