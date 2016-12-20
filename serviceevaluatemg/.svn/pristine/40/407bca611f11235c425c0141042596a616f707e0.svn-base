package com.app.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.app.entity.Role;
import com.app.service.RoleService;
/**
 * 
 * @author 邢昭武
 * 
 * 角色action
 *
 */
public class RoleAction extends SuperAction {
	private Role role;
	private RoleService roleService;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String add() throws Exception {
		if (roleService.save(role)) {
			return "add";
		}
		return "error";
	}
}
