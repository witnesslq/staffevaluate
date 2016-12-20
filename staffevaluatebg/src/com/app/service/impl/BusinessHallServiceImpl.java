package com.app.service.impl;

import java.util.List;

import com.app.dao.BusinessHallDao;
import com.app.entity.BusinessHall;
import com.app.entity.Xtjs;
import com.app.service.BusinessHallService;

public class BusinessHallServiceImpl implements BusinessHallService {

	private BusinessHallDao businessHallDao;

	public void setBusinessHallDao(BusinessHallDao businessHallDao) {
		this.businessHallDao = businessHallDao;
	}

	@Override
	public List<BusinessHall> findAllBusinessHall() {
		return businessHallDao.findAllBusinessHall();
	}

	@Override
	public boolean save(BusinessHall businessHall) {
		boolean flag = false;
		int result = businessHallDao.save(businessHall);
		System.out.println(result);// 返回的是主键值
		if (result > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<BusinessHall> findAllByPage(int pageNo,int unitid) {
		
		return businessHallDao.findAllByPage(pageNo, BusinessHall_PAGE_SIZE,unitid);
	}

	@Override
	public int getBusinessHallCount(int unitid) {
		return businessHallDao.getBusinessHallCount(unitid);
	}

	@Override
	public String getNewBusinessHallId() {
		return businessHallDao.getNewBusinessHallId();
	}

	public int getPageCount(int count, int pageSize) {
		return (count + pageSize - 1) / pageSize;
	}

	@Override
	public BusinessHall getBusinessHallById(Integer id) {
		return businessHallDao.selectById(id);
	}

	@Override
	public int updateBussinessHall(BusinessHall bh) {
		if(bh!=null){
			businessHallDao.update(bh);
			return 1;
		}else{
			return 0;
		}
		
		
	}

	@Override
	public void deleteByIds(String ids) {
		if(ids!=null||ids.trim().length()>0){
			businessHallDao.deleteByIds(ids);
		}
	}

}
