package com.app.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 岗位实体
 * 
 * @author 吴雨桐
 *
 */
public class Post {
	private Integer post_id;// 主键
	private String name;// 岗位名称
	private Set<Staff> staff = new HashSet<Staff>();

	public Set<Staff> getStaff() {
		return staff;
	}

	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	}

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
