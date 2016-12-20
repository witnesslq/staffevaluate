package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.entity.Staff;

/**
 * 员工service类
 * 
 * @author 邢昭武 
 * 
 */
public interface StaffService {
	/**
	 * 添加员工
	 * 
	 * @param staff
	 *            员工实体
	 * @return boolean 成功返回true失败返回false
	 */
	public boolean addStaff(Staff staff);

	public List<Staff> getAllStaff();

	public Staff getStaff(Integer id);

	public List<Staff> getStaffByUserAndPassword(String username, String password);

	public List<Staff> findByName(String username);

	int STAFF_PAGE_SIZE = 8;

	List listStaff(int pageNo) throws Exception;

	int getStaffCount() throws Exception;

	int getPageCount(int count, int pageSize);

	String getNewStaffId();
	
	int getStaffCountByParam(String no,String name,int BussinessHallid);
	
	List findAllByPage(int pageNo, int pageSize, String no, String name, int businessHallId);
	
	Map<Character, String> getSex();
	
	int updateStaff(Staff staff);

	void deleteByIds(String ids);
}
