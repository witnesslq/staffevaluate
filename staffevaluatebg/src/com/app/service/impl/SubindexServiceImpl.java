package com.app.service.impl;

import java.util.List;

import com.app.dao.SubindexDao;
import com.app.entity.Subindex;
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
	
	@Override
	public void deleteById(int id) {
		subindexDao.delete(id);
	}



	@Override
	public void update(Subindex subindex) {
		subindexDao.update(subindex);
	}



	@Override
	public Subindex findById(int id) {
		return subindexDao.get(id);
	}

	@Override
	public List<Subindex> findAllByPage(int pageNo, int pageSize) {
		List<Subindex> list = subindexDao.findAllByPage(pageNo, pageSize);
		return list;
	}

	@Override
	public int getSubindexCount() {
		int count = subindexDao.getSubindexCount();
		return count;
	}

	@Override
	public void deleteByIds(String ids) {
		//ids = ids.substring(0, ids.length()-1);
		System.out.println(222);
		subindexDao.deleteByIds(ids);
	}

}
