package com.app.service;

import java.util.List;

import com.app.entity.Post;
/**
 * 
 * @author 邢昭武
 *
 * 角色Sercice
 */
public interface PostService {
	public List<Post> findAllPost();
	public boolean save(Post post); //添加岗位信息
	public void deleteById(int id);
 	public void update(Post post);
 	public Post findById(int id);
 	public void deleteByIds(String ids);
 	/**
	 * 分页查询所有分项指标信息
	 * 
	 * @param pageNo
	 *            当前页是第几页
	 * @param pageSize
	 *            页面大小
	 * @return 分项指标信息列表
	 */
	List<Post> findAllByPage(int pageNo, int pageSize);
	
	/**
	 * 查询分项指标总数
	 * 
	 * @return int 分项指标总数
	 */
	int getPostCount();


}
