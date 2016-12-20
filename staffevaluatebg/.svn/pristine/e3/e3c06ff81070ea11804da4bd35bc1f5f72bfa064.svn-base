package com.app.service.impl;

import java.util.List;

import com.app.dao.RoleDao;
import com.app.entity.Role;
import com.app.entity.Xtjs;
import com.app.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}



	@Override
	public List<Role> findAllRole() {
		// TODO Auto-generated method stub
		return roleDao.findAllRole();
	}



	@Override
	public boolean save(Role role) {
		boolean flag = false;
		int result = roleDao.save(role);
		System.out.println(result);//返回的是主键值
		if(result>0){
			flag = true;
		}
		return flag;
	}
}
