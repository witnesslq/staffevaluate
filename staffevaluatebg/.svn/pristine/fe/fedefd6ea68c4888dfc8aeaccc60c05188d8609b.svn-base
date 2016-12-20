package com.app.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色实体类
 * 
 * @author 吴雨桐
 *
 */
public class Role {
	private Integer role_id;// 主键
	private String name;// 角色名称
	private Set<Staff> staff = new HashSet<Staff>();

	public Set<Staff> getStaff() {
		return staff;
	}

	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", name=" + name + "]";
	}

}
