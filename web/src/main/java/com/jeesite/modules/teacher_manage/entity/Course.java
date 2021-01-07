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
 * @version 2021-01-07
 */
@Table(name="course", alias="a", columns={
		@Column(name="cno", attrName="cno", label="cno", isPK=true),
		@Column(name="tno", attrName="tno.tno", label="tno"),
		@Column(name="cname", attrName="cname", label="cname"),
		@Column(name="ctype", attrName="ctype", label="ctype"),
		@Column(name="credit", attrName="credit", label="credit"),
		@Column(name="period", attrName="period", label="period"),
		@Column(name="checkmethod", attrName="checkmethod", label="checkmethod"),
	}, orderBy="a.cno ASC"
)
public class Course extends DataEntity<Course> {

	private static final long serialVersionUID = 1L;
	private String cno;		// cno
	private Teacher tno;		// tno 父类
	private String cname;		// cname
	private String ctype;		// ctype
	private String credit;		// credit
	private String period;		// period
	private String checkmethod;		// checkmethod

	public Course() {
		this(null);
	}


	public Course(Teacher tno){
		this.tno = tno;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	@Length(min=0, max=10, message="tno长度不能超过 10 个字符")
	public Teacher getTno() {
		return tno;
	}

	public void setTno(Teacher tno) {
		this.tno = tno;
	}

	@Length(min=0, max=45, message="cname长度不能超过 45 个字符")
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Length(min=0, max=45, message="ctype长度不能超过 45 个字符")
	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	@Length(min=0, max=45, message="credit长度不能超过 45 个字符")
	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Length(min=0, max=45, message="period长度不能超过 45 个字符")
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	@Length(min=0, max=45, message="checkmethod长度不能超过 45 个字符")
	public String getCheckmethod() {
		return checkmethod;
	}

	public void setCheckmethod(String checkmethod) {
		this.checkmethod = checkmethod;
	}

	public void print(){
		System.out.println(cno+","+cname+","+ctype+","+credit+","+period+","+checkmethod);
	}

}
