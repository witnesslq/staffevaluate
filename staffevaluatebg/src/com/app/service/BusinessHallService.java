package com.app.service;

import java.util.List;

import com.app.entity.BusinessHall;
/**
 * 
 * @author 邢昭武
 *
 * 角色Sercice
 */
public interface BusinessHallService {
	int BusinessHall_PAGE_SIZE = 10;

	
	public boolean save(BusinessHall businessHall); //添加角色信息
	/**
	 * 查询所有营业厅信息
	 * 
	 * @return 营业厅信息列表
	 */
	public List<BusinessHall> findAllBusinessHall();

	/**
	 * 分页查询所有营业厅信息
	 * 
	 * @param pageNo
	 *            当前页是第几页
	 * @param pageSize
	 *            页面大小
	 * @return 营业厅信息列表
	 */
	List<BusinessHall> findAllByPage(int pageNo,int unitid);

	/**
	 * 查询营业厅总数
	 * 
	 * @return int 营业厅总数
	 */
	int getBusinessHallCount(int unitid);
	
	

	/**
	 * 获取最新的营业厅编号
	 * 
	 * @return String 营业厅编号
	 */
	String getNewBusinessHallId();
	
	int getPageCount(int count, int pageSize);
	
	BusinessHall getBusinessHallById(Integer id);
	
	int updateBussinessHall(BusinessHall bh);
	
	/**
	 * 批量删除
	 */
	void deleteByIds(String ids);
}
