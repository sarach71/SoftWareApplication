/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.teacher_manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.teacher_manage.entity.Teacher;
import com.jeesite.modules.teacher_manage.dao.TeacherDao;
import com.jeesite.modules.teacher_manage.entity.Course;
import com.jeesite.modules.teacher_manage.dao.CourseDao;

/**
 * 教师信息管理Service
 * @author wjx
 * @version 2021-01-07
 */
@Service
@Transactional(readOnly=true)
public class TeacherService extends CrudService<TeacherDao, Teacher> {
	
	@Autowired
	private CourseDao courseDao;
	
	/**
	 * 获取单条数据
	 * @param teacher
	 * @return
	 */
	@Override
	public Teacher get(Teacher teacher) {
		Teacher entity = super.get(teacher);
		if (entity != null){
			Course course = new Course(entity);
			course.setStatus(Course.STATUS_NORMAL);
			entity.setCourseList(courseDao.findList(course));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param teacher 查询条件
	 * @param teacher.page 分页对象
	 * @return
	 */
	@Override
	public Page<Teacher> findPage(Teacher teacher) {
		return super.findPage(teacher);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param teacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Teacher teacher) {
		super.save(teacher);
		// 保存 Teacher子表
		for (Course course : teacher.getCourseList()){
			if (!Course.STATUS_DELETE.equals(course.getStatus())){
				course.setTno(teacher);
				if (course.getIsNewRecord()){
					courseDao.insert(course);
				}else{
					courseDao.update(course);
				}
			}else{
				courseDao.delete(course);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param teacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Teacher teacher) {
		super.updateStatus(teacher);
	}
	
	/**
	 * 删除数据
	 * @param teacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Teacher teacher) {
		super.delete(teacher);
		Course course = new Course();
		course.setTno(teacher);
		courseDao.deleteByEntity(course);
	}
	
}