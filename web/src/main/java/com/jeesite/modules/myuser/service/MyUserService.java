/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.myuser.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.myuser.entity.MyUser;
import com.jeesite.modules.myuser.dao.MyUserDao;

/**
 * 用户表Service
 * @author wxr
 * @version 2021-01-09
 */
@Service
@Transactional(readOnly=true)
public class MyUserService extends CrudService<MyUserDao, MyUser> {
	
	/**
	 * 获取单条数据
	 * @param myUser
	 * @return
	 */
	@Override
	public MyUser get(MyUser myUser) {
		return super.get(myUser);
	}
	
	/**
	 * 查询分页数据
	 * @param myUser 查询条件
	 * @param myUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<MyUser> findPage(MyUser myUser) {
		return super.findPage(myUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param myUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MyUser myUser) {
		super.save(myUser);
	}
	
	/**
	 * 更新状态
	 * @param myUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MyUser myUser) {
		super.updateStatus(myUser);
	}
	
	/**
	 * 删除数据
	 * @param myUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MyUser myUser) {
		super.delete(myUser);
	}
	
}