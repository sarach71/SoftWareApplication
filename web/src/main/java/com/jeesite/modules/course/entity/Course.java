/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.course.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 课程表Entity
 * @author wjx
 * @version 2021-01-08
 */
@Table(name="course", alias="a", columns={
		@Column(name="cno", attrName="cno", label="课程号", isPK=true),
		@Column(name="tno", attrName="tno", label="教师工号", isPK=true),
		@Column(name="cname", attrName="cname", label="课程名", queryType=QueryType.LIKE),
		@Column(name="tname", attrName="tname", label="教师姓名", queryType=QueryType.LIKE),
		@Column(name="ctype", attrName="ctype", label="课程类型"),
		@Column(name="credit", attrName="credit", label="学分"),
		@Column(name="period", attrName="period", label="学时"),
		@Column(name="checkmethod", attrName="checkmethod", label="考核方式"),
	}, orderBy="a.cno DESC, a.tno DESC"
)
public class Course extends DataEntity<Course> {
	
	private static final long serialVersionUID = 1L;
	private String cno;		// 课程号
	private String tno;		// 教师工号
	private String cname;		// 课程名
	private String tname;		// 教师姓名
	private String ctype;		// 课程类型
	private String credit;		// 学分
	private String period;		// 学时
	private String checkmethod;		// 考核方式
	
	public Course() {
		this(null, null);
	}

	public Course(String cno, String tno){
		this.cno = cno;
		this.tno = tno;
	}
	
	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}
	
	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}
	
	@Length(min=0, max=45, message="课程名长度不能超过 45 个字符")
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Length(min=0, max=45, message="教师姓名长度不能超过 45 个字符")
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@Length(min=0, max=45, message="课程类型长度不能超过 45 个字符")
	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	
	@Length(min=0, max=45, message="学分长度不能超过 45 个字符")
	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	@Length(min=0, max=45, message="学时长度不能超过 45 个字符")
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
	@Length(min=0, max=45, message="考核方式长度不能超过 45 个字符")
	public String getCheckmethod() {
		return checkmethod;
	}

	public void setCheckmethod(String checkmethod) {
		this.checkmethod = checkmethod;
	}
	
}