package com.app.entity;

/**
 * 政策法规实体类
 * 
 * @author 吴雨桐
 *
 */
public class Zcfg {
	private int id;// 主键
	private String zcfgtxt;// 政策法规的内容
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

	public String getZcfgtxt() {
		return zcfgtxt;
	}

	public void setZcfgtxt(String zcfgtxt) {
		this.zcfgtxt = zcfgtxt;
	}

}
