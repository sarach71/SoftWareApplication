/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.manager.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 管理员信息管理Entity
 * @author wxr
 * @version 2021-01-08
 */
@Table(name="manager", alias="a", columns={
		@Column(name="mno", attrName="mno", label="编号", isPK=true),
		@Column(name="mname", attrName="mname", label="姓名", queryType=QueryType.LIKE),
		@Column(name="msex", attrName="msex", label="性别"),
		@Column(name="mhome", attrName="mhome", label="籍贯"),
		@Column(name="mphone", attrName="mphone", label="联系方式"),
		@Column(name="mpassword", attrName="mpassword", label="密码"),
	}, orderBy="a.mno DESC"
)
public class Manager extends DataEntity<Manager> {
	
	private static final long serialVersionUID = 1L;
	private String mno;		// 编号
	private String mname;		// 姓名
	private String msex;		// 性别
	private String mhome;		// 籍贯
	private String mphone;		// 联系方式
	private String mpassword;		// 密码
	
	public Manager() {
		this(null);
	}

	public Manager(String id){
		super(id);
	}
	
	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}
	
	@Length(min=0, max=45, message="姓名长度不能超过 45 个字符")
	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
	
	@Length(min=0, max=45, message="性别长度不能超过 45 个字符")
	public String getMsex() {
		return msex;
	}

	public void setMsex(String msex) {
		this.msex = msex;
	}
	
	@Length(min=0, max=45, message="籍贯长度不能超过 45 个字符")
	public String getMhome() {
		return mhome;
	}

	public void setMhome(String mhome) {
		this.mhome = mhome;
	}
	
	@Length(min=0, max=45, message="联系方式长度不能超过 45 个字符")
	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	
	@Length(min=0, max=45, message="密码长度不能超过 45 个字符")
	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	
}