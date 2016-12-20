package com.app.entity;

/**
 * 系统简介的实体类
 * 
 * @author 邢昭武
 *
 */
public class Xtjs {
	private int id;// 主键
	private String xtjstxt;// 系统简介内容
	private Integer fsize;

	public Integer getFsize() {
		return fsize;
	}

	public void setFsize(Integer fsize) {
		this.fsize = fsize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getXtjstxt() {
		return xtjstxt;
	}

	public void setXtjstxt(String xtjstxt) {
		this.xtjstxt = xtjstxt;
	}

}
