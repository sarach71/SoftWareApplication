/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.score.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.score.entity.Score;
import com.jeesite.modules.score.dao.ScoreDao;

/**
 * 成绩管理Service
 * @author qy
 * @version 2021-01-08
 */
@Service
@Transactional(readOnly=true)
public class ScoreService extends CrudService<ScoreDao, Score> {

	/**
	 * 获取单条数据
	 * @param score
	 * @return
	 */
	@Override
	public Score get(Score score) {
		return super.get(score);
	}

	/**
	 * 查询分页数据
	 * @param score 查询条件
	 * @param score.page 分页对象
	 * @return
	 */
	@Override
	public Page<Score> findPage(Score score) {
		return super.findPage(score);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param score
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Score score) {
		super.save(score);
	}

	/**
	 * 更新状态
	 * @param score
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Score score) {
		super.updateStatus(score);
	}

	/**
	 * 删除数据
	 * @param score
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Score score) {
		super.delete(score);
	}

}
