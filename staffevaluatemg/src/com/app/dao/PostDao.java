package com.app.dao;

import java.util.List;

import com.app.entity.Post;
import com.app.entity.Role;

/**
 * 
 * @author 邢昭武
 *
 *         岗位Dao
 */
public interface PostDao {
	/**
	 * 获取所有的岗位信息
	 * 
	 * @return List<Post>
	 */
	public List<Post> findAllPost();

	/**
	 * 添加岗位信息
	 * 
	 * @param czzn
	 * @return 0添加失败，>0添加成功
	 */
	public Integer save(Post post); //
}
