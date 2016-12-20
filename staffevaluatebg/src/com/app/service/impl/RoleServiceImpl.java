package com.app.service.impl;

import java.util.List;

import com.app.dao.RoleDao;
import com.app.entity.Role;
import com.app.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}



	@Override
	public List<Role> findAllRole() {
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



	@Override
	public void deleteById(int id) {
		roleDao.delete(id);
	}



	@Override
	public void update(Role role) {
		roleDao.update(role);
	}



	@Override
	public Role findById(int id) {
		
		return roleDao.get(id);
	}


	@Override
	public void deleteByIds(String ids) {
		roleDao.deleteByIds(ids);
	}



	@Override
	public List<Role> findAllByPage(int pageNo, int pageSize) {
		List<Role> list = roleDao.findAllByPage(pageNo, pageSize);
		return list;
	}



	@Override
	public int getRoleCount() {
		int count = roleDao.getRoleCount();
		return count;
	}
}
