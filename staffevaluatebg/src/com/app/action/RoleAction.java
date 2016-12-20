package com.app.action;

import java.util.List;

import com.app.entity.Role;
import com.app.service.RoleService;
/**
 * 
 * @author 吴雨桐
 * 
 * 角色action
 *
 */
public class RoleAction extends SuperAction {
	private Role role;
	private RoleService roleService;
	private String ids;//分项指标的id组合（1，2，3）
	private Integer id;
	private List<Role> list;
	private Integer pageCount; //页面总数
	private Integer currentPage; //输出当前第几页
	private Integer pagePerNo;//每页的记录数
	private Integer totalCount;//记录总数
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Role> getList() {
		return list;
	}

	public void setList(List<Role> list) {
		this.list = list;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
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
		//System.out.println("rolename:"+role.getRole_id());
		if (roleService.save(role)) {
			return "add";
		}
		return "error";
	}

	public String updateInfo(){
		System.out.println(id);
		role = roleService.findById(id);
		return "updateInfo";
	}

	/**
	 * 分项指标信息修改
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		if(role!=null){
			System.out.println("update:"+role.getRole_id());
			roleService.update(role);
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
			roleService.deleteByIds(ids);
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
		list = roleService.findAllByPage(currentPage, pagePerNo);
		totalCount = roleService.getRoleCount();
		if(totalCount%pagePerNo==0){
			pageCount = totalCount/pagePerNo;
		}else{
			pageCount = totalCount/pagePerNo+1;
		}
		System.out.println(list.size()+"记录数："+totalCount+"页总数："+pageCount+"当前第几页："+currentPage);
		return "listAll";
	}
	
	/**
	 * 根据id找具体的分项指标信息
	 * @return
	 * @throws Exception
	 */
	public String findById() throws Exception{
		role = roleService.findById(id);
		return "findById";
	}
}
