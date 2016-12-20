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


	/**
	 * 根据id删除角色
	 * @param id
	 */
	void delete (int id);// 删除角色
	
	/**
	 * 修改橘色信息
	 * @param role
	 */
	void update (Role role);// 修改角色

	/**
	 * 查询指定信息
	 * @param id 
	 * @return
	 */
	Role get(int id); // 查询指定角色

	
	/**
	 * 分页查询所有角色信息
	 * 
	 * @param pageNo
	 *            当前页是第几页
	 * @param pageSize
	 *            页面大小
	 * @return 员工信息列表
	 */
	List<Role> findAllByPage(int pageNo, int pageSize);
	
	/**
	 * 查询角色总数
	 * 
	 * @return int 角色总数
	 */
	int getRoleCount();
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteByIds(String ids);
}
