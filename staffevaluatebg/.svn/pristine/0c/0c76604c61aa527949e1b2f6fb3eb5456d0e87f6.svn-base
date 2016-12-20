package com.app.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 营业厅实体类
 * 
 * @author 吴雨桐
 *
 */

public class BusinessHall {
	private Integer id;// 主键
	private String name;// 营业厅名称
	private String no;// 编号
	private String address;// 地址
	private Unit unit; //单位信息
	private String level;//级别
	private int size;//该营业厅的服务人员总数
	
	public int getSize() {
		if(staff != null){
			return staff.size();
		}else{
			return 0;
		}
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	private Set<Staff> staff = new HashSet<Staff>();
	public Set<Staff> getStaff() {
		return staff;
	}
	
	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
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
		return "BusinessHall [id=" + id + ", name=" + name + ", no=" + no + ", address=" + address + ", unit=" + unit
				+ ", staff=" + staff + "]";
	}

}
