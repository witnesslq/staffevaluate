package com.app.dao;

import java.util.List;

import com.app.entity.Role;
import com.app.entity.Xtjs;
/**
 * 
 * @author 邢昭武
 *
 * 角色Dao
 */
public interface RoleDao {
	/**
	 * 查询所有角色信息
	 * @return List<Role>
	 */
	public List<Role> findAllRole();
	
	/**
	 * 添加角色
	 * @param role
	 * @return 0添加失败，>0添加成功
	 */
	public Integer save(Role role); //添加角色信息
}
