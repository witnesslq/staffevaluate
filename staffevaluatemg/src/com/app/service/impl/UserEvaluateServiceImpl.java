package com.app.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.app.dao.UserEvaluateDao;
import com.app.entity.UserEvaluate;
import com.app.service.UserEvaluateService;

public class UserEvaluateServiceImpl implements UserEvaluateService {

	private UserEvaluateDao userEvaluateDao;

	public void setUserEvaluateDao(UserEvaluateDao userEvaluateDao) {
		this.userEvaluateDao = userEvaluateDao;
	}

	// ����һ�����ۼ�¼
	public boolean addUserEvaluate(UserEvaluate userEvaluate) {
		int result = userEvaluateDao.save(userEvaluate);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<UserEvaluate> findAllUE() {
		return userEvaluateDao.findAll();
	}

	@Override
	public Integer getAllCount() {
		return userEvaluateDao.getAllCount();
	}

	@Override
	public UserEvaluate getById(Integer id) {
		return userEvaluateDao.get(id);
	}

	public Map<Character, String> getReturnStatusOptions() {
		Map<Character, String> statusOptions = new LinkedHashMap<Character, String>();
		statusOptions.put('1', "是");
		statusOptions.put('0', "否");
		return statusOptions;
	}

	@Override
	public List<UserEvaluate> listPage(int page, int perPageRow) {
		int offset = (page - 1) * perPageRow;
		int length = perPageRow;
		return userEvaluateDao.queryForPage(offset, length);
	}

	@Override
	public Integer getPageCount(int perPageRow) {
		int rowCount = userEvaluateDao.getAllRowCount();
		int pageCount;
		if (rowCount % perPageRow == 0) {
			pageCount = (int) (rowCount / perPageRow);
		} else {
			pageCount = (int) (rowCount / perPageRow + 1);
		}

		return pageCount;
	}

	@Override
	public List<UserEvaluate> listPage1(int page, int perPageRow, String sat) {
		int offset = (page - 1) * perPageRow;
		int length = perPageRow;
		return userEvaluateDao.queryForPage1(offset, length, sat);
	}

	@Override
	public Integer getPageCount1(int perPageRow, String sat) {
		int rowCount = userEvaluateDao.getAllRowCount1(sat);
		int pageCount;
		if (rowCount % perPageRow == 0) {
			pageCount = (int) (rowCount / perPageRow);
		} else {
			pageCount = (int) (rowCount / perPageRow + 1);
		}

		return pageCount;
	}

}
