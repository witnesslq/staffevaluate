package com.app.dao;

import java.util.List;

import com.app.entity.Subindex;

/**
 * 分项指标的DAO类
 * 
 * @author 邢昭武
 *
 */
public interface SubindexDao {
	/**
	 * 根据ids获取指定范围内的分项指标的列表
	 * 
	 * @param ids
	 *            （1，2，3）分项指标的id组合
	 * @return List<Subindex>分项指标的列表
	 */
	public List<Subindex> getByIds(String ids);

	/**
	 * 获取所有的分项指标信息
	 * 
	 * @return List<Subindex>分项指标的列表
	 */
	public List<Subindex> findAllSubindex();

	/**
	 * 添加分项指标
	 * 
	 * @param subindex
	 * @return Integer 0：添加失败,>0添加成功
	 */
	public Integer save(Subindex subindex);
	
	/**
	 * 根据id删除分项指标
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 更新分项指标
	 * @param subindex
	 */
	public void update(Subindex subindex);
	
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

	/**
	 * 根据Id查分项指标
	 * @param id
	 * @return
	 */
	Subindex get(int id);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteByIds(String ids);
}
