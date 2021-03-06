package com.app.service.impl;

import java.util.List;

import com.app.dao.UnitDao;
import com.app.entity.Unit;
import com.app.entity.Xtjs;
import com.app.service.UnitService;

public class UnitServiceImpl implements UnitService {

	private UnitDao unitDao;
	
	
	public void setUnitDao(UnitDao unitDao) {
		this.unitDao = unitDao;
	}



	@Override
	public List<Unit> findAllUnit() {
		// TODO Auto-generated method stub
		return unitDao.findAllUnit();
	}



	@Override
	public boolean save(Unit unit) {
		boolean flag = false;
		int result = unitDao.save(unit);
		System.out.println(result);//返回的是主键值
		if(result>0){
			flag = true;
		}
		return flag;
	}



	@Override
	public List findUnitByPage(int pageNo,int perPageCount) throws Exception {
		return unitDao.findAllUnitByPage(pageNo, perPageCount);
	}



	@Override
	public int getUnitCount() throws Exception {
		return unitDao.getUnitCount();
	}



	@Override
	public int getPageCount(int count, int pageSize) {
		return (count+pageSize-1)/pageSize;
	}



	@Override
	public Unit findById(int id) throws Exception {
		
		return unitDao.get(id);
	}
	
	public Integer update(Unit unit) throws Exception {
		return unitDao.update(unit);
	}



	@Override
	public Integer delete(String ids) throws Exception {
		
		return unitDao.delete(ids);
	}
}
