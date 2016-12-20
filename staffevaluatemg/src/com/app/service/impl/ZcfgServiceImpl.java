package com.app.service.impl;

import com.app.dao.ZcfgDao;
import com.app.entity.Zcfg;
import com.app.service.ZcfgService;

public class ZcfgServiceImpl implements ZcfgService {

	private ZcfgDao zcfgDao;
	
	
	
	public void setZcfgDao(ZcfgDao zcfgDao) {
		this.zcfgDao = zcfgDao;
	}

	public boolean addZcfg(Zcfg zcfg) {
		boolean flag = false;
		int result = zcfgDao.save(zcfg);
		System.out.println(result);//返回的是主键值
		if(result>0){
			flag = true;
		}
		return flag;
	}

	public Zcfg get() {
		
		return zcfgDao.getLast();
	}

}
