package com.app.dao;

import java.util.List;

import com.app.entity.Staff;

/**
 * 员工DAO类
 * 
 * @author 邢昭武
 *
 */
public interface StaffDao {
	/**
	 * 根据id查询员工详细信息
	 * 
	 * @param id
	 *            主键
	 * @return 员工实体
	 */
	Staff get(Integer id);

	/**
	 * 保存员工信息
	 * 
	 * @param Staff
	 *            员工实体
	 * @return int 大于0添加成功
	 */
	Integer save(Staff Staff);

	/**
	 * 更新员工信息
	 * 
	 * @param Staff
	 *            员工实体
	 * @return 
	 */
	Integer update(Staff Staff);

	/**
	 * 根据id删除指定员工信息
	 * 
	 * @param id
	 *            主键
	 * @return 
	 */
	Integer delete(Integer id);

	/**
	 * 根据员工信息删除指定员工信息
	 * 
	 * @param Staff
	 *            员工实体
	 * @return 
	 */
	Integer delete(Staff Staff);

	/**
	 * 通过用户行查询员工列表信息
	 * 
	 * @param username
	 *            用户名
	 * @return 员工信息列表
	 */
	List<Staff> findByName(String name);

	/**
	 * 根据用户名和密码查询所有员工列表信息
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 员工信息列表
	 */
	List<Staff> findByNameAndPassword(String name, String password);

	/**
	 * 查询所有员工信息
	 * 
	 * @return 员工信息列表
	 */
	public List<Staff> findAllStaff();

	/**
	 * 分页查询所有员工信息
	 * 
	 * @param pageNo
	 *            当前页是第几页
	 * @param pageSize
	 *            页面大小
	 * @return 员工信息列表
	 */
	List findAllByPage(int pageNo, int pageSize);

	/**
	 * 
	 * 根据指定条件分页查询所有员工信息
	 * 
	 * @param pageNo
	 *            当前页是第几页
	 * @param pageSize
	 *            页面大小
	 * @param no
	 *            员工号
	 * @param name
	 *            员工姓名
	 * @param businessHallId
	 *            营业厅编号
	 * @return 员工信息列表
	 */
	List findAllByPage(int pageNo, int pageSize,  String name, int businessHallId);

	/**
	 * 查询员工总数
	 * 
	 * @return int 员工总数
	 */
	int getStaffCount();
	
	/**
	 * 查询员工总数
	 * 
	 * @param no
	 *            员工号
	 * @param name
	 *            员工姓名
	 * @param businessHallId
	 *            营业厅编号
	 * @return int 符合条件的员工总数
	 */
	int getStaffCountByParam(String no, String name, int businessHallId);

	/**
	 * 获取最新的员工编号
	 * 
	 * @return String 员工编号
	 */
	String getNewStaffId();
	
	List<Staff> findByNo(String no);
	
	List<Staff> findByName1(String name);
	
	List<Staff> findByBusinessHallId(Integer BusinessHalllid);
	
	/**
	 * 条件查询
	 * @param name
	 * @param BusinessHallid
	 * @return
	 */
	List<Staff> getStaffByP( String name,int BusinessHallid);
	
	void deleteByIds(String ids);
}