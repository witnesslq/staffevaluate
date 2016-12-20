package com.app.service.impl;

import com.app.dao.CzznDao;
import com.app.entity.Czzn;
import com.app.service.CzznService;

public class CzznServiceImpl implements CzznService {

	private CzznDao czznDao;
	
	
	
	public void setCzznDao(CzznDao czznDao) {
		this.czznDao = czznDao;
	}

	public boolean addCzzn(Czzn czzn) {
		boolean flag = false;
		int result = czznDao.save(czzn);
		System.out.println(result);//返回的是主键值
		if(result>0){
			flag = true;
		}
		return flag;
	}

	public Czzn get() {
		
		return czznDao.getLast();
	}

}
