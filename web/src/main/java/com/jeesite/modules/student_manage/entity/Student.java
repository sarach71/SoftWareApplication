/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.student_manage.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 学生信息表Entity
 * @author wxr
 * @version 2021-01-07
 */
@Table(name="student", alias="a", columns={
		@Column(name="sno", attrName="sno", label="学号", isPK=true),
		@Column(name="sname", attrName="sname", label="姓名", queryType=QueryType.LIKE),
		@Column(name="ssex", attrName="ssex", label="性别"),
		@Column(name="shome", attrName="shome", label="籍贯"),
		@Column(name="scollege", attrName="scollege", label="学院"),
		@Column(name="smajor", attrName="smajor", label="专业"),
		@Column(name="sclass", attrName="sclass", label="班级"),
		@Column(name="sphone", attrName="sphone", label="联系方式"),
		@Column(name="spassword", attrName="spassword", label="密码"),
	}, orderBy="a.sno DESC"
)
public class Student extends DataEntity<Student> {
	
	private static final long serialVersionUID = 1L;
	private String sno;		// 学号
	private String sname;		// 姓名
	private String ssex;		// 性别
	private String shome;		// 籍贯
	private String scollege;		// 学院
	private String smajor;		// 专业
	private String sclass;		// 班级
	private String sphone;		// 联系方式
	private String spassword;		// 密码
	
	public Student() {
		this(null);
	}

	public Student(String id){
		super(id);
	}
	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
	
	@Length(min=0, max=45, message="姓名长度不能超过 45 个字符")
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Length(min=0, max=45, message="性别长度不能超过 45 个字符")
	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	
	@Length(min=0, max=45, message="籍贯长度不能超过 45 个字符")
	public String getShome() {
		return shome;
	}

	public void setShome(String shome) {
		this.shome = shome;
	}
	
	@Length(min=0, max=45, message="学院长度不能超过 45 个字符")
	public String getScollege() {
		return scollege;
	}

	public void setScollege(String scollege) {
		this.scollege = scollege;
	}
	
	@Length(min=0, max=45, message="专业长度不能超过 45 个字符")
	public String getSmajor() {
		return smajor;
	}

	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}
	
	@Length(min=0, max=45, message="班级长度不能超过 45 个字符")
	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	
	@Length(min=0, max=45, message="联系方式长度不能超过 45 个字符")
	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	
	@Length(min=0, max=45, message="密码长度不能超过 45 个字符")
	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	
}