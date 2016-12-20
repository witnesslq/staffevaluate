package com.app.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 营业厅所属单位实体类
 * 
 * @author 吴雨桐
 *
 */
public class Unit {
	private Integer id;// 主键
	private String name;// 名称
	private Set<BusinessHall> businessHall = new HashSet<BusinessHall>();
	public Unit(){
		super();
	}
	public Unit(Integer id, String name){
		this.id = id;
		this.name = name;
	}
	public Set<BusinessHall> getBusinessHall() {
		return businessHall;
	}

	public void setBusinessHall(Set<BusinessHall> businessHall) {
		this.businessHall = businessHall;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Unit [id=" + id + ", name=" + name + ", businessHall=" + businessHall + "]";
	}
}
