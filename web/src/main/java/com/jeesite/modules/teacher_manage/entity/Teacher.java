/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.teacher_manage.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 教师信息管理Entity
 * @author wjx
 * @version 2021-01-08
 */
@Table(name="teacher", alias="a", columns={
		@Column(name="tno", attrName="tno", label="教师工号", isPK=true),
		@Column(name="tname", attrName="tname", label="姓名", queryType=QueryType.LIKE),
		@Column(name="tsex", attrName="tsex", label="性别"),
		@Column(name="thome", attrName="thome", label="籍贯"),
		@Column(name="tcollege", attrName="tcollege", label="学院"),
		@Column(name="title", attrName="title", label="职称"),
		@Column(name="tphone", attrName="tphone", label="联系方式"),
		@Column(name="tpassword", attrName="tpassword", label="密码"),
	}, orderBy="a.tno DESC"
)
public class Teacher extends DataEntity<Teacher> {
	
	private static final long serialVersionUID = 1L;
	private String tno;		// 教师工号
	private String tname;		// 姓名
	private String tsex;		// 性别
	private String thome;		// 籍贯
	private String tcollege;		// 学院
	private String title;		// 职称
	private String tphone;		// 联系方式
	private String tpassword;		// 密码
	
	public Teacher() {
		this(null);
	}

	public Teacher(String id){
		super(id);
	}
	
	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}
	
	@Length(min=0, max=45, message="姓名长度不能超过 45 个字符")
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@Length(min=0, max=45, message="性别长度不能超过 45 个字符")
	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	
	@Length(min=0, max=45, message="籍贯长度不能超过 45 个字符")
	public String getThome() {
		return thome;
	}

	public void setThome(String thome) {
		this.thome = thome;
	}
	
	@Length(min=0, max=45, message="学院长度不能超过 45 个字符")
	public String getTcollege() {
		return tcollege;
	}

	public void setTcollege(String tcollege) {
		this.tcollege = tcollege;
	}
	
	@Length(min=0, max=45, message="职称长度不能超过 45 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=45, message="联系方式长度不能超过 45 个字符")
	public String getTphone() {
		return tphone;
	}

	public void setTphone(String tphone) {
		this.tphone = tphone;
	}
	
	@Length(min=0, max=45, message="密码长度不能超过 45 个字符")
	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	
}