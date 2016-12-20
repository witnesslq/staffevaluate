package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.entity.UserEvaluate;

public interface UserEvaluateService {
	public boolean addUserEvaluate(UserEvaluate userEvaluate);
	public List<UserEvaluate> findAllUE();
	public Integer getAllCount();
	public UserEvaluate getById(Integer id);
	public Map<Character, String> getReturnStatusOptions();
	public List<UserEvaluate> listPage(int page,int  perPageRow);
	public List<UserEvaluate> listPage1(int page,int  perPageRow,String sat);
	public Integer getPageCount(int perPageRow);
	public Integer getPageCount1(int perPageRow,String sat);
}
