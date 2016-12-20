package com.app.service.impl;

import com.app.dao.XtjsDao;
import com.app.entity.Xtjs;
import com.app.service.XtjsService;

public class XtjsServiceImpl implements XtjsService {

	private XtjsDao xtjsDao;
	
	
	
	public void setXtjsDao(XtjsDao xtjsDao) {
		this.xtjsDao = xtjsDao;
	}

	public boolean addXtjs(Xtjs xtjs) {
		boolean flag = false;
		int result = xtjsDao.save(xtjs);
		System.out.println(result);//返回的是主键值
		if(result>0){
			flag = true;
		}
		return flag;
	}

	public Xtjs get() {
		return xtjsDao.getLast();
	}

}
