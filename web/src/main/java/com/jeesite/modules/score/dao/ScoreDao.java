/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.score.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.score.entity.Score;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * test
 * @author qy
 * @version 2021-01-08
 */
@MyBatisDao
public interface ScoreDao extends CrudDao<Score> {

}

