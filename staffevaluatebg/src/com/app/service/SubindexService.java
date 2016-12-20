package com.app.service;

import java.util.List;

import com.app.entity.Subindex;

public interface SubindexService {
	public List<Subindex> getByIds(String ids) ;
	public List<Subindex> findAllSubindex();
	public boolean save(Subindex subindex);
 	public void deleteById(int id);
 	public void update(Subindex role);
 	public Subindex findById(int id);
	/**
	 * 分页查询所有分项指标信息
	 * 
	 * @param pageNo
	 *            当前页是第几页
	 * @param pageSize
	 *            页面大小
	 * @return 分项指标信息列表
	 */
	List<Subindex> findAllByPage(int pageNo, int pageSize);
	
	/**
	 * 查询分项指标总数
	 * 
	 * @return int 分项指标总数
	 */
	int getSubindexCount();
	
	void deleteByIds(String ids);
}
