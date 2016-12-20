package com.app.service;

import java.util.List;

import com.app.entity.Role;
/**
 * 
 * @author 邢昭武
 *
 * 角色Sercice
 */
public interface RoleService {
	public List<Role> findAllRole();  //查找所有角色
 	public boolean save(Role role); //添加角色信息
 	public void deleteById(int id);
 	public void update(Role role);
 	public Role findById(int id);
 	public void deleteByIds(String ids);
 	/**
	 * 分页查询所有分项指标信息
	 * 
	 * @param pageNo
	 *            当前页是第几页
	 * @param pageSize
	 *            页面大小
	 * @return 分项指标信息列表
	 */
	List<Role> findAllByPage(int pageNo, int pageSize);
	
	/**
	 * 查询分项指标总数
	 * 
	 * @return int 分项指标总数
	 */
	int getRoleCount();
	
}
