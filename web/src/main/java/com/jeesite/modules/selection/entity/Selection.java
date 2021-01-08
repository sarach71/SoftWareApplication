/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.selection.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 选课信息管理Entity
 * @author wxr
 * @version 2021-01-08
 */
@Table(name="selection", alias="a", columns={
		@Column(name="sno", attrName="sno", label="学生学号", isPK=true),
		@Column(name="cno", attrName="cno", label="课程编号", isPK=true),
		@Column(name="tno", attrName="tno", label="教师工号", isPK=true),
		@Column(name="cname", attrName="cname", label="课程名", queryType=QueryType.LIKE),
		@Column(name="sname", attrName="sname", label="学生姓名", queryType=QueryType.LIKE),
		@Column(name="tname", attrName="tname", label="教师姓名", queryType=QueryType.LIKE),
		@Column(name="place", attrName="place", label="上课地点"),
		@Column(name="period", attrName="period", label="学时"),
	}, orderBy="a.sno DESC, a.cno DESC, a.tno DESC"
)
public class Selection extends DataEntity<Selection> {
	
	private static final long serialVersionUID = 1L;
	private String sno;		// 学生学号
	private String cno;		// 课程编号
	private String tno;		// 教师工号
	private String cname;		// 课程名
	private String sname;		// 学生姓名
	private String tname;		// 教师姓名
	private String place;		// 上课地点
	private String period;		// 学时
	
	public Selection() {
		this(null, null, null);
	}

	public Selection(String sno, String cno, String tno){
		this.sno = sno;
		this.cno = cno;
		this.tno = tno;
	}
	
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
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
	
	@Length(min=0, max=45, message="学生姓名长度不能超过 45 个字符")
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Length(min=0, max=45, message="教师姓名长度不能超过 45 个字符")
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@Length(min=0, max=45, message="上课地点长度不能超过 45 个字符")
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	@Length(min=0, max=45, message="学时长度不能超过 45 个字符")
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
}