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
}
