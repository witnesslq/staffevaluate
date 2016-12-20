package com.app.service.impl;

import java.util.List;

import com.app.dao.StaffDao;
import com.app.entity.Staff;
import com.app.service.StaffService;

public class StaffServiceImpl implements StaffService{
	private StaffDao staffDao;
	
	public StaffDao getStaffDao() {
		return staffDao;
	}
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	@Override
	public boolean addStaff(Staff staff) {
		int result = staffDao.save(staff);
		if(result > 0){
			return true;
		}
		return false;
	}
	@Override
	public List<Staff> getAllStaff() {
		return staffDao.findAllStaff();
	}
	@Override
	public Staff getStaff(Integer id) {
		Staff staff = staffDao.get(id);
		return staff;
	}
	@Override
	public List<Staff> getStaffByUserAndPassword(String username, String password) {
		
		return staffDao.findByNameAndPassword(username,password);
	}
	@Override
	public List<Staff> findByName(String username) {
		return staffDao.findByName(username);
	}

	
	public int getPageCount(int count, int pageSize) {
		  return (count+pageSize-1)/pageSize;
		 }
		public int getStaffCount() throws Exception {
		  return staffDao.getStaffCount();
		 }

		public List listStaff(int pageNo) throws Exception {

		  return staffDao.findAllByPage(pageNo, STAFF_PAGE_SIZE);

		 }
		@Override
		public String getNewStaffId() {
			// TODO Auto-generated method stub
			return staffDao.getNewStaffId();
		}
}


