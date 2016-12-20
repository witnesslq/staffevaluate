package com.app.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.app.entity.Post;
import com.app.service.PostService;
/**
 * 
 * @author 邢昭武
 * 岗位action
 *
 */
public class PostAction extends SuperAction {
	private Post post;//用户接收表单的数据
	private PostService postService;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	/**
	 * 添加岗位
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		if (postService.save(post)) {
			return "add";
		}
		return "error";
	}
}
