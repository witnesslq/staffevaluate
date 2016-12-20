package com.app.entity;

/**
 * 员工实体类
 * 
 * @author 吴雨桐
 *
 */
public class Staff {
	private Integer id;// 主键
	private String staff_no; // 员工编号
	private String username;// 用户名
	private String password;// 密码
	private String name;// 员工姓名
	private char sex;// 性别
	private String photo;// 照片
	private String phone;// 联系电话
	private Integer businesshall_id;// 营业厅id
	private Role role;// 角色
	private Post post;// 岗位

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStaff_no() {
		return staff_no;
	}

	public void setStaff_no(String staff_no) {
		this.staff_no = staff_no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/*
	 * public Integer getRole_id() { return role_id; } public void
	 * setRole_id(Integer role_id) { this.role_id = role_id; } public Integer
	 * getPost_id() { return post_id; } public void setPost_id(Integer post_id)
	 * { this.post_id = post_id; }
	 */
	public Integer getBusinesshall_id() {
		return businesshall_id;
	}

	public void setBusinesshall_id(Integer businesshall_id) {
		this.businesshall_id = businesshall_id;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", staff_no=" + staff_no + ", username=" + username + ", password=" + password
				+ ", name=" + name + ", sex=" + sex + ", photo=" + photo + ", phone=" + phone + ", role_id=" + "]";
	}

}
