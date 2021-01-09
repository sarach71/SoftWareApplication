/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.myuser.web;

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
import com.jeesite.modules.myuser.entity.MyUser;
import com.jeesite.modules.myuser.service.MyUserService;

/**
 * 用户表Controller
 * @author wxr
 * @version 2021-01-09
 */
@Controller
@RequestMapping(value = "${adminPath}/myuser/myUser")
public class MyUserController extends BaseController {

	@Autowired
	private MyUserService myUserService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MyUser get(String userCode, boolean isNewRecord) {
		return myUserService.get(userCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("myuser:myUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(MyUser myUser, Model model) {
		model.addAttribute("myUser", myUser);
		return "modules/myuser/myUserList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("myuser:myUser:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MyUser> listData(MyUser myUser, HttpServletRequest request, HttpServletResponse response) {
		myUser.setPage(new Page<>(request, response));
		Page<MyUser> page = myUserService.findPage(myUser);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("myuser:myUser:view")
	@RequestMapping(value = "form")
	public String form(MyUser myUser, Model model) {
		model.addAttribute("myUser", myUser);
		return "modules/myuser/myUserForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("myuser:myUser:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MyUser myUser) {
		myUserService.save(myUser);
		return renderResult(Global.TRUE, text("保存用户表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("myuser:myUser:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MyUser myUser) {
		myUserService.delete(myUser);
		return renderResult(Global.TRUE, text("删除用户表成功！"));
	}
	
}