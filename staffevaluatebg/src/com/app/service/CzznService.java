package com.app.service;

import com.app.entity.Czzn;

public interface CzznService {
	public boolean addCzzn(Czzn czzn);
	public Czzn get();
	
	/**
	 * 修改操作指南信息
	 * @param czzn
	 * @return czzn的id
	 */
	public Integer update(Czzn czzn);
}
