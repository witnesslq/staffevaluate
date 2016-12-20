package com.app.service;
import java.util.List;
import com.app.entity.Staff;
/**
 * 
 * @author xingzhaowu
 * Ա��service��
 *	
 */
public interface StaffService {
	/**
	 * ¼��Ա����Ϣ
	 * @param staff Ա������
	 * @return boolean
	 */
	public boolean addStaff(Staff staff);
	/**
	 * ��ȡ����Ա����Ϣ
	 * @return Ա���ļ���List<Staff>
	 */
	public List<Staff> getAllStaff();
	public Staff getStaff(Integer id);
	
	public List<Staff> getStaffByUserAndPassword(String username,String password);
	public List<Staff> findByName(String username);
	
	int STAFF_PAGE_SIZE=10;
	List listStaff(int pageNo) throws Exception;
	int getStaffCount()throws Exception;
	int getPageCount(int count,int pageSize);
	String getNewStaffId();
}
