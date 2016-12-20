package com.app.service;

import java.util.List;

import com.app.entity.Unit;

/**
 * 
 * @author 邢昭武
 *
 *         单位Sercice
 */
public interface UnitService {

	public List<Unit> findAllUnit() throws Exception;

	public boolean save(Unit unit) throws Exception; // 添加单位信息
	
	public Integer delete(String ids) throws Exception;

	List findUnitByPage(int pageNo,int perPageCount) throws Exception;

	int getUnitCount() throws Exception;

	int getPageCount(int count, int pageSize);
	
	public Unit findById(int id) throws Exception;
	
	public Integer update(Unit unit) throws Exception; //修改单位信息

}
