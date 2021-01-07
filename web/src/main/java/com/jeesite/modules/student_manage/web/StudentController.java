/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student_manage.web;

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
import com.jeesite.modules.student_manage.entity.Student;
import com.jeesite.modules.student_manage.service.StudentService;

/**
 * 学生信息表Controller
 * @author wxr
 * @version 2021-01-07
 */
@Controller
@RequestMapping(value = "${adminPath}/student_manage/student")
public class StudentController extends BaseController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Student get(String sno, boolean isNewRecord) {
		return studentService.get(sno, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("student_manage:student:view")
	@RequestMapping(value = {"list", ""})
	public String list(Student student, Model model) {
		model.addAttribute("student", student);
		return "modules/student_manage/studentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("student_manage:student:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Student> listData(Student student, HttpServletRequest request, HttpServletResponse response) {
		student.setPage(new Page<>(request, response));
		Page<Student> page = studentService.findPage(student);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("student_manage:student:view")
	@RequestMapping(value = "form")
	public String form(Student student, Model model) {
		model.addAttribute("student", student);
		return "modules/student_manage/studentForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("student_manage:student:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Student student) {
		studentService.save(student);
		return renderResult(Global.TRUE, text("保存学生信息表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("student_manage:student:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Student student) {
		studentService.delete(student);
		return renderResult(Global.TRUE, text("删除学生信息表成功！"));
	}
	
}