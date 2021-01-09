/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.score.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 成绩管理Entity
 * @author qy
 * @version 2021-01-08
 */
@Table(name="score", alias="a", columns={
		@Column(name="sno", attrName="sno", label="学生学号", isPK=true),
		@Column(name="cno", attrName="cno", label="课程号", isPK=true),
		@Column(name="tno", attrName="tno", label="教师工号", isPK=true),
		@Column(name="sname", attrName="sname", label="学生姓名", queryType=QueryType.LIKE),
		@Column(name="cname", attrName="cname", label="课程名", queryType=QueryType.LIKE),
		@Column(name="tname", attrName="tname", label="教师姓名", queryType=QueryType.LIKE),
		@Column(name="checkmethod", attrName="checkmethod", label="考核方式"),
		@Column(name="result0", attrName="result0", label="是否合格"),
		@Column(name="result1", attrName="result1", label="成绩"),
	}, orderBy="a.sno DESC, a.cno DESC, a.tno DESC"
)
public class Score extends DataEntity<Score> {

	private static final long serialVersionUID = 1L;
	private String sno;		// 学生学号
	private String cno;		// 课程号
	private String tno;		// 教师工号
	private String sname;		// 学生姓名
	private String cname;		// 课程名
	private String tname;		// 教师姓名
	private String checkmethod;		// 考核方式
	private String result0;		// 是否合格
	private Double result1;		// 成绩

	public Score() {
		this(null, null, null);
	}

	public Score(String sno, String cno, String tno){
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

	@Length(min=0, max=45, message="学生姓名长度不能超过 45 个字符")
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	@Length(min=0, max=45, message="考核方式长度不能超过 45 个字符")
	public String getCheckmethod() {
		return checkmethod;
	}

	public void setCheckmethod(String checkmethod) {
		this.checkmethod = checkmethod;
	}

	@Length(min=0, max=45, message="是否合格长度不能超过 45 个字符")
	public String getResult0() {
		return result0;
	}

	public void setResult0(String result0) {
		this.result0 = result0;
	}

	public Double getResult1() {
		return result1;
	}

	public void setResult1(Double result1) {
		this.result1 = result1;
	}

	public void print(){
		System.out.println(sno+","+cno+","+tno+","+sname+","+cname+","+tname+","+checkmethod+","+result0+","+result1);
	}

}
