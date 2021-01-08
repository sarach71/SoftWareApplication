/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.manager.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.manager.entity.Manager;
import com.jeesite.modules.manager.service.ManagerService;

/**
 * 管理员信息管理Controller
 * @author wxr
 * @version 2021-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/manager/manager")
public class ManagerController extends BaseController {

	@Autowired
	private ManagerService managerService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Manager get(String mno, boolean isNewRecord) {
		return managerService.get(mno, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("manager:manager:view")
	@RequestMapping(value = {"list", ""})
	public String list(Manager manager, Model model) {
		model.addAttribute("manager", manager);
		return "modules/manager/managerList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("manager:manager:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Manager> listData(Manager manager, HttpServletRequest request, HttpServletResponse response) {
		manager.setPage(new Page<>(request, response));
		Page<Manager> page = managerService.findPage(manager);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("manager:manager:view")
	@RequestMapping(value = "form")
	public String form(Manager manager, Model model) {
		model.addAttribute("manager", manager);
		return "modules/manager/managerForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("manager:manager:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Manager manager) {
		managerService.save(manager);
		return renderResult(Global.TRUE, text("保存管理员信息管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("manager:manager:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Manager manager) {
		managerService.delete(manager);
		return renderResult(Global.TRUE, text("删除管理员信息管理成功！"));
	}
	
}