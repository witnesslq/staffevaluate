package com.app.service.impl;

import java.util.List;

import com.app.dao.SubindexDao;
import com.app.entity.Subindex;
import com.app.service.SubindexService;

public class SubindexServiceImpl implements SubindexService{
	private SubindexDao subindexDao;
	public SubindexDao getSubindexDao() {
		return subindexDao;
	}

	public void setSubindexDao(SubindexDao subindexDao) {
		this.subindexDao = subindexDao;
	}

	@Override
	public List<Subindex> getByIds(String ids) {
		return subindexDao.getByIds(ids);
	}

	@Override
	public List<Subindex> findAllSubindex() {
		return subindexDao.findAllSubindex();
	}

	@Override
	public boolean save(Subindex subindex) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int result = subindexDao.save(subindex);;
		System.out.println(result);//返回的是主键值
		if(result>0){
			flag = true;
		}
		return flag;
	}

}
