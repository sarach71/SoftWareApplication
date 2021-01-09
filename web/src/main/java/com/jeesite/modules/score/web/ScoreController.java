/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.score.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.score.entity.Score;
import com.jeesite.modules.score.service.ScoreService;

import java.util.List;

/**
 * 成绩管理Controller
 * @author qy
 * @version 2021-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/score/score")
public class ScoreController extends BaseController {

	@Autowired
	private ScoreService scoreService;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Score get(String sno, String cno, String tno, boolean isNewRecord) {
		Score score = new Score();
		score.setSno(sno);
		score.setCno(cno);
		score.setTno(tno);
		score.setIsNewRecord(isNewRecord);
		return scoreService.getAndValid(score);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("score:score:view")
	@RequestMapping(value = {"list", ""})
	public String list(Score score, Model model) {
		model.addAttribute("score", score);
		return "modules/score/scoreList";
	}

	/**
	 * author:wxr
	 * 查询某学生成绩列表
	 */
	@RequiresPermissions("score:score:view")
	@RequestMapping(value = {"listStu", ""})
	public String listStu(Score score, Model model) {
//		String id=UserUtils.getUser().getId();
//		score.print();
//		System.out.println(id+","+score.getSno());
//		if(score.getSno()==id){
			model.addAttribute("score", score);
//			score.print();
//		}

		return "modules/score/scoreListStu";
	}

	/**
	 * author:wxr
	 * 查询某教师教授课程的学生成绩列表
	 */
	@RequiresPermissions("score:score:view")
	@RequestMapping(value = {"listTea", ""})
	public String listTea(Score score, Model model) {
		model.addAttribute("score", score);
		return "modules/score/scoreListTea";
	}

	/**
	 * author:wxr
	 * 查询所有学生的成绩列表
	 */
	@RequiresPermissions("score:score:view")
	@RequestMapping(value = {"listMa", ""})
	public String listMa(Score score, Model model) {
		model.addAttribute("score", score);
		return "modules/score/scoreListMa";
	}

	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("score:score:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Score> listData(Score score, HttpServletRequest request, HttpServletResponse response) {
		score.setPage(new Page<>(request, response));
		Page<Score> page = scoreService.findPage(score);
		return page;
	}

	/**
	 * author:wxr
	 * 查询某学生成绩列表数据
	 */
	@RequiresPermissions("score:score:view")
	@RequestMapping(value = "listDataStu")
	@ResponseBody
	public Page<Score> listDataStu(Score score, HttpServletRequest request, HttpServletResponse response) {
		String id=UserUtils.getUser().getLoginCode();
		score.setSno(id);
		score.setPage(new Page<>(request, response));
		Page<Score> page = scoreService.findPage(score);
		return page;
	}

	/**
	 * author:wxr
	 * 查询某学生成绩列表数据
	 */
	@RequiresPermissions("score:score:view")
	@RequestMapping(value = "listDataTea")
	@ResponseBody
	public Page<Score> listDataTea(Score score, HttpServletRequest request, HttpServletResponse response) {
		String id=UserUtils.getUser().getLoginCode();
		score.setTno(id);
		score.setPage(new Page<>(request, response));
		Page<Score> page = scoreService.findPage(score);
		return page;
	}


	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("score:score:view")
	@RequestMapping(value = "form")
	public String form(Score score, Model model) {
		model.addAttribute("score", score);
		return "modules/score/scoreForm";
	}

	/**
	 * author:wxr
	 * 查看教师编辑表单
	 */
	@RequiresPermissions("score:score:view")
	@RequestMapping(value = "formTea")
	public String formTea(Score score, Model model) {
		model.addAttribute("score", score);
		return "modules/score/scoreFormTea";
	}

	/**
	 * author:wxr
	 * 查看管理员编辑表单
	 */
	@RequiresPermissions("score:score:view")
	@RequestMapping(value = "formMa")
	public String formMa(Score score, Model model) {
		model.addAttribute("score", score);
		return "modules/score/scoreFormMa";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("score:score:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Score score) {
		scoreService.save(score);
		return renderResult(Global.TRUE, text("保存成绩管理成功！"));
	}

	/**
	 * 删除数据
	 */
	@RequiresPermissions("score:score:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Score score) {
		scoreService.delete(score);
		return renderResult(Global.TRUE, text("删除成绩管理成功！"));
	}

}
