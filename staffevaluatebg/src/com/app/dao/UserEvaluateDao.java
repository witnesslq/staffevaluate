package com.app.dao;

import java.util.List;

import com.app.entity.UserEvaluate;

/**
 * 员工评价DAO类
 * 
 * @author 吴雨桐
 *
 */
public interface UserEvaluateDao {
	/**
	 * 添加员工评价
	 * 
	 * @param userEvaluate
	 *            员工评价实体
	 * @return Integer 0：添加失败；>0添加成功
	 */
	public Integer save(UserEvaluate userEvaluate);

	/**
	 * 查询所有员工评价信息列表
	 * 
	 * @return List<UserEvaluate>员工评价信息列表
	 */
	public List<UserEvaluate> findAll();

	/**
	 * 获取所有记录总数
	 * 
	 * @return Integer记录总数
	 */
	public Integer getAllCount();

	public UserEvaluate get(Integer id);

	/**
	 * 分页查询
	 * 
	 * @param hql
	 *            查询条件
	 * @param offset
	 *            开始记录
	 * @param length
	 *            一次查询几条记录
	 * @return List<UserEvaluate>查询的记录集合
	 */
	public List<UserEvaluate> queryForPage(final int offset, final int length);

	/**
	 * 
	 * @param offset
	 *            开始记录
	 * @param length
	 *            一次查询几条记录
	 * @param sat
	 *            满意度状态
	 * @return List<UserEvaluate>查询的记录集合
	 */
	public List<UserEvaluate> queryForPage1(final int offset, final int length, String sat);

	/**
	 * 查询所有的记录数
	 * 
	 * @param hql
	 *            查询条件
	 * @return 总记录数
	 */
	public int getAllRowCount();

	/**
	 * 获取记录总数条件（满意度状态）
	 * 
	 * @param sat
	 *            表扬、批评、建议
	 * @return int 记录总数
	 */
	public int getAllRowCount1(String sat);
	
	public void updateReturn(String ids); 
	
	public void updateValid(String ids); 
}
