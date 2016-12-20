package com.app.entity;
/**
 * 评价表
 * @author wyt
 *
 */
public class Evaluate {
	  private Integer evaluate_id; //评价类型id
	  private String name;//评价类型名称
	public Integer getEvaluate_id() {
		return evaluate_id;
	}
	public void setEvaluate_id(Integer evaluate_id) {
		this.evaluate_id = evaluate_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	  
}
