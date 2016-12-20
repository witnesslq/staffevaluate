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
	 Integer save(Post post); //
	/**
	 * 删除岗位
	 * @param id
	 */
	 void delete (int id);// 删除岗位
	
	 /**
	  * 更新岗位
	  * @param Post
	  */
	void update (Post Post);// 修改岗位
	
	
	/**
	 * 根据岗位id获取岗位信息
	 * @param id
	 * @return
	 */
	Post get(int id); // 查询指定岗位
	
	/**
	 * 分页查询所有岗位信息
	 * 
	 * @param pageNo
	 *            当前页是第几页
	 * @param pageSize
	 *            页面大小
	 * @return 岗位信息列表
	 */
	List<Post> findAllByPage(int pageNo, int pageSize);
	
	/**
	 * 查询岗位总数
	 * 
	 * @return int 员工总数
	 */
	int getPostCount();
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteByIds(String ids);
}
