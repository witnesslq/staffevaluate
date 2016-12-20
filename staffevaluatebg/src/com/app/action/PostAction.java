package com.app.action;

import java.util.List;

import com.app.entity.Post;
import com.app.service.PostService;
/**
 * 
 * @author 吴雨桐
 * 岗位action
 *
 */
public class PostAction extends SuperAction {
	private Post post;
	private PostService postService;
	private String ids;//分项指标的id组合（1，2，3）
	private Integer id;
	private List<Post> list;
	private Integer pageCount; //页面总数
	private Integer currentPage; //输出当前第几页
	private Integer pagePerNo;//每页的记录数
	private Integer totalCount;//记录总数

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Post> getList() {
		return list;
	}

	public void setList(List<Post> list) {
		this.list = list;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPagePerNo() {
		return pagePerNo;
	}

	public void setPagePerNo(Integer pagePerNo) {
		this.pagePerNo = pagePerNo;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 录入分项指标流程控制
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		if (postService.save(post)) {
			return "add";
		}
		return "error";
	}

	public String updateInfo(){
		System.out.println(id);
		post = postService.findById(id);
		return "updateInfo";
	}

	/**
	 * 分项指标信息修改
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		if(post!=null){
			System.out.println("update:"+post.getName()+"post_id:"+post.getPost_id());
			postService.update(post);
		}
		return "update";
	}
	
	/**
	 * 删除分项指标
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		//System.out.println(ids);
		if(ids.trim()==""||ids.length()<=0){
			return "listAll";
		}
		else{
			postService.deleteByIds(ids);
			//System.out.println(111111);
		}
		return "delete";
	}
	
	/**
	 * 取出所有的分项指标信息
	 * @return
	 * @throws Exception
	 */
	public String listAll() throws Exception{
		pagePerNo = 8;
		if(currentPage==null||currentPage<=0){
			currentPage = 1;
		}
		list = postService.findAllByPage(currentPage, pagePerNo);
		totalCount = postService.getPostCount();
		if(totalCount%pagePerNo==0){
			pageCount = totalCount/pagePerNo;
		}else{
			pageCount = totalCount/pagePerNo+1;
		}
		System.out.println(list.size()+"记录数："+totalCount+"页总数："+pageCount+"当前第几页："+currentPage);
//		if(post!=null){
//			System.out.println("post"+post.getName());
//		}
		//System.out.println(list.get(0).getName()+list.get(1).getName()+list.get(2).getName()+"---");
		return "listAll";
	}
	
	/**
	 * 根据id找具体的分项指标信息
	 * @return
	 * @throws Exception
	 */
	public String findById() throws Exception{
		post = postService.findById(id);
		return "findById";
	}
}
