package com.app.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	@Override
	public int getStaffCountByParam(String no, String name, int BussinessHallid) {
		System.out.println("员工号:"+no+" 姓名:"+name+" 营业厅编号:"+BussinessHallid);
		if(!("".equals(no))||no.trim().length()!=0){
			if(staffDao.findByNo(no)!=null){
				return 1;
			}
		}else{
			if((!("".equals(name))||name.trim().length()!=0)&&BussinessHallid!=0){
				//name bhid都不为空
				return staffDao.getStaffByP(name, BussinessHallid).size();
			}else if((!("".equals(name))||name.trim().length()!=0)&&BussinessHallid==0){
				//name不空 bhid空
				List<Staff> list = staffDao.findByName1(name);
				return list.size();
			}else if(("".equals(name)||name.trim().length()==0)&&BussinessHallid!=0){
				//name空 bhid不空
				List<Staff> list = staffDao.findByBusinessHallId(BussinessHallid);
				return list.size();
			}else if(("".equals(name)||name.trim().length()==0)&&BussinessHallid==0){
				//name bhid都空
				
				return staffDao.getStaffCount();
			}
		}
		return 0;
	}
	@Override
	public List findAllByPage(int pageNo, int pageSize, String no, String name, int businessHallId) {
		if(!("".equals(no))&&no.trim().length()!=0){
			List list = null;
			list = staffDao.findByNo(no);
			return list;
		}else{
			return staffDao.findAllByPage(pageNo, pageSize, name, businessHallId);
		}
	}
	@Override
	public Map<Character, String> getSex() {
		Map<Character, String> sexMap = new LinkedHashMap<Character, String>();
		sexMap.put('1', "男");
		sexMap.put('2', "女");
		return sexMap;
	}
	@Override
	public int updateStaff(Staff staff) {
		return staffDao.update(staff);
	}
	@Override
	public void deleteByIds(String ids) {
		staffDao.deleteByIds(ids);
	}
}


