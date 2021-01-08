/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.selection.web;

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
import com.jeesite.modules.selection.entity.Selection;
import com.jeesite.modules.selection.service.SelectionService;

/**
 * 选课信息管理Controller
 * @author wxr
 * @version 2021-01-08
 */
@Controller
@RequestMapping(value = "${adminPath}/selection/selection")
public class SelectionController extends BaseController {

	@Autowired
	private SelectionService selectionService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Selection get(String sno, String cno, String tno, boolean isNewRecord) {
		Selection selection = new Selection();
		selection.setSno(sno);
		selection.setCno(cno);
		selection.setTno(tno);
		selection.setIsNewRecord(isNewRecord);
		return selectionService.getAndValid(selection);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("selection:selection:view")
	@RequestMapping(value = {"list", ""})
	public String list(Selection selection, Model model) {
		model.addAttribute("selection", selection);
		return "modules/selection/selectionList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("selection:selection:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Selection> listData(Selection selection, HttpServletRequest request, HttpServletResponse response) {
		selection.setPage(new Page<>(request, response));
		Page<Selection> page = selectionService.findPage(selection);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("selection:selection:view")
	@RequestMapping(value = "form")
	public String form(Selection selection, Model model) {
		model.addAttribute("selection", selection);
		return "modules/selection/selectionForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("selection:selection:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Selection selection) {
		selectionService.save(selection);
		return renderResult(Global.TRUE, text("保存选课信息管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("selection:selection:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Selection selection) {
		selectionService.delete(selection);
		return renderResult(Global.TRUE, text("删除选课信息管理成功！"));
	}
	
}