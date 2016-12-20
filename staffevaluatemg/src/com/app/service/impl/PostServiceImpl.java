package com.app.service.impl;

import java.util.List;

import com.app.dao.PostDao;
import com.app.entity.Post;
import com.app.entity.Xtjs;
import com.app.service.PostService;

public class PostServiceImpl implements PostService {

	private PostDao postDao;
	
	
	
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}



	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		return postDao.findAllPost();
	}



	@Override
	public boolean save(Post post) {
		boolean flag = false;
		int result = postDao.save(post);
		System.out.println(result);//返回的是主键值
		if(result>0){
			flag = true;
		}
		return flag;
	}

	

}
