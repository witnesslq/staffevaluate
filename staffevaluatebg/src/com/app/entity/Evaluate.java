package com.app.entity;
/**
 * 评价类型实体类
 * @author 吴雨桐
 *
 */
public class Evaluate {
	  private Integer evaluate_id; //主键
	  private String name;//名称
	  
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
