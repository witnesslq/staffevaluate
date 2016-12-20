package com.app.dao;

import java.util.List;

import com.app.entity.UserEvaluate;

public interface UserEvaluateDao {
	public Integer save(UserEvaluate userEvaluate);
	public List<UserEvaluate> findAll();
	public Integer getAllCount();
	public UserEvaluate get(Integer id);
	/**
	 * 分页查询
	 * @param hql  查询条件
	 * @param offset  开始记录
	 * @param length  一次查询几条记录
	 * @return 查询的记录集合
	 */
	public List<UserEvaluate> queryForPage(final int offset,final int length);
	public List<UserEvaluate> queryForPage1(final int offset,final int length,String sat);
	
	/**
	 * 查询所有的记录数
	 * @param hql 查询条件
	 * @return 总记录数
	 */
	public int getAllRowCount();
	public int getAllRowCount1(String sat);
}
