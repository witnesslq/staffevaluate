package com.app.dao;

import java.util.List;

import com.app.entity.Unit;
import com.app.entity.Xtjs;
/**
 * 
 * @author 邢昭武
 *
 * 营业厅单位Dao
 */
public interface UnitDao {
	
	
	public Unit get(Integer id);
	/**
	 * 查询所有单位信息
	 * @return List<Unit>
	 */
	public List<Unit> findAllUnit();
	
	/**
	 * 添加单位
	 * @param unit
	 * @return 0添加失败，>0添加成功
	 */
	public Integer save(Unit unit); //添加单位信息
	
	public Integer delete(int id); //删除单位信息
	
	public Integer delete(String ids);
	
	public Integer update(Unit unit); //修改单位信息
	
	/**
	 * 分页查询所有的单位信息
	 * 
	 * @param pageNo
	 *            当前页是第几页
	 * @param pageSize
	 *            页面大小
	 * @return
	 */
	public List<Unit> findAllUnitByPage(int pageNo, int pageSize);
	
	/**
	 * 查询单位总数
	 * 
	 * @return int 单位总数
	 */
	int getUnitCount();
	
	Unit findById(int id);
}

