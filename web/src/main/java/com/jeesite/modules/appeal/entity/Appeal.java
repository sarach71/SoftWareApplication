/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.appeal.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 申诉管理Entity
 * @author qy
 * @version 2021-01-08
 */
@Table(name="appeal", alias="a", columns={
		@Column(name="ano", attrName="ano", label="序号", isPK=true),
		@Column(name="sno", attrName="sno", label="学生学号"),
		@Column(name="cno", attrName="cno", label="课程号"),
		@Column(name="tno", attrName="tno", label="教师工号"),
		@Column(name="atext", attrName="atext", label="申诉内容"),
		@Column(name="feedback", attrName="feedback", label="反馈内容"),
	}, orderBy="a.ano DESC"
)
public class Appeal extends DataEntity<Appeal> {
	
	private static final long serialVersionUID = 1L;
	private Long ano;		// 序号
	private String sno;		// 学生学号
	private String cno;		// 课程号
	private String tno;		// 教师工号
	private String atext;		// 申诉内容
	private String feedback;		// 反馈内容
	
	public Appeal() {
		this(null);
	}

	public Appeal(String id){
		super(id);
	}
	
	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}
	
	@Length(min=0, max=10, message="学生学号长度不能超过 10 个字符")
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
	
	@Length(min=0, max=10, message="课程号长度不能超过 10 个字符")
	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}
	
	@Length(min=0, max=10, message="教师工号长度不能超过 10 个字符")
	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}
	
	public String getAtext() {
		return atext;
	}

	public void setAtext(String atext) {
		this.atext = atext;
	}
	
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}