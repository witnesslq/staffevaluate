package com.app.dao;

import com.app.entity.Czzn;

public interface CzznDao {
	public Czzn getLast();
	public Integer save(Czzn czzn);
}
