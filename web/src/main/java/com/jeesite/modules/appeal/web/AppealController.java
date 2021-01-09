/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.appeal.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.appeal.entity.Appeal;
import com.jeesite.modules.appeal.service.AppealService;

/**
 * 申诉管理Controller
 * @author qy
 * @version 2021-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/appeal/appeal")
public class AppealController extends BaseController {

	@Autowired
	private AppealService appealService;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Appeal get(Long ano, boolean isNewRecord) {
		return appealService.get(String.valueOf(ano), isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = {"list", ""})
	public String list(Appeal appeal, Model model) {
		model.addAttribute("appeal", appeal);
		return "modules/appeal/appealList";
	}

	/**
	 * author:wxr
	 * 查询某学生的申诉列表
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = {"listStu", ""})
	public String listStu(Appeal appeal, Model model) {
		model.addAttribute("appeal", appeal);
		return "modules/appeal/appealListStu";
	}

	/**
	 * author:wxr
	 * 查询向某教师进行成绩申诉的申诉列表
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = {"listTea", ""})
	public String listTea(Appeal appeal, Model model) {
		model.addAttribute("appeal", appeal);
		return "modules/appeal/appealListTea";
	}

	/**
	 * author:wxr
	 * 查询向某教师进行成绩申诉的申诉列表
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = {"listMa", ""})
	public String listMa(Appeal appeal, Model model) {
		model.addAttribute("appeal", appeal);
		return "modules/appeal/appealListMa";
	}

	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Appeal> listData(Appeal appeal, HttpServletRequest request, HttpServletResponse response) {
		appeal.setPage(new Page<>(request, response));
		Page<Appeal> page = appealService.findPage(appeal);
		return page;
	}

	/**
	 * 查询学生列表数据
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = "listDataStu")
	@ResponseBody
	public Page<Appeal> listDataStu(Appeal appeal, HttpServletRequest request, HttpServletResponse response) {
		String id= UserUtils.getUser().getLoginCode();
		appeal.setSno(id);
		appeal.setPage(new Page<>(request, response));
		Page<Appeal> page = appealService.findPage(appeal);
		return page;
	}

	/**
	 * 查询教师列表数据
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = "listDataTea")
	@ResponseBody
	public Page<Appeal> listDataTea(Appeal appeal, HttpServletRequest request, HttpServletResponse response) {
		String id= UserUtils.getUser().getLoginCode();
		System.out.println(id);
		appeal.setTno(id);
		appeal.setPage(new Page<>(request, response));
		Page<Appeal> page = appealService.findPage(appeal);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = "form")
	public String form(Appeal appeal, Model model) {
		model.addAttribute("appeal", appeal);
		return "modules/appeal/appealForm";
	}

	/**
	 * author:wxr
	 * 查看学生编辑表单
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = "formStu")
	public String formStu(Appeal appeal, Model model) {
		model.addAttribute("appeal", appeal);
		return "modules/appeal/appealFormStu";
	}

	/**
	 * author:wxr
	 * 查看学生编辑表单
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = "formTea")
	public String formTea(Appeal appeal, Model model) {
		model.addAttribute("appeal", appeal);
		return "modules/appeal/appealFormTea";
	}

	/**
	 * author:wxr
	 * 查看学生编辑表单
	 */
	@RequiresPermissions("appeal:appeal:view")
	@RequestMapping(value = "formMa")
	public String formMa(Appeal appeal, Model model) {
		model.addAttribute("appeal", appeal);
		return "modules/appeal/appealFormMa";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("appeal:appeal:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Appeal appeal) {
		appealService.save(appeal);
		return renderResult(Global.TRUE, text("保存申诉管理成功！"));
	}

	/**
	 * 删除数据
	 */
	@RequiresPermissions("appeal:appeal:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Appeal appeal) {
		appealService.delete(appeal);
		return renderResult(Global.TRUE, text("删除申诉管理成功！"));
	}

}
