package com.app.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.app.entity.Unit;
import com.app.service.UnitService;
import com.app.util.JsonFilter;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
/**
 * 
 * @author 邢昭武
 * 
 * 单位action
 *
 */
public class UnitAction extends SuperAction {
	private Unit unit;
	private UnitService unitService;
	private String ids;
	private Integer id;
	private List<Unit> list;
	private Integer pageCount; //页面总数
	private Integer currentPage; //输出当前第几页
	private Integer pagePerNo;//每页的记录数
	private Integer totalCount;//记录总数
	


	public List<Unit> getList() {
		return list;
	}

	public void setList(List<Unit> list) {
		this.list = list;
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


	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}
	/**
	 * 添加角色
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		if (unitService.save(unit)) {
			return "add";
		}
		return "error";
	}
	
	public String getAjax() throws Exception {
		List<Unit> listAll = unitService.findAllUnit();
		System.out.println(listAll.toString());
		JSONArray json=JSONArray.fromObject(listAll);
		ServletActionContext.getResponse().setContentType("text/html");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().printf(json.toString());
		ServletActionContext.getResponse().getWriter().flush();
		ServletActionContext.getResponse().getWriter().close();
		return null; 
	}
	public String getAll() throws Exception {
		List<Unit> listAll = unitService.findAllUnit();
		return "getAll";
	}
	
	public String listP() throws Exception {
		pagePerNo = 8;
		if(currentPage==null||currentPage<=0){
			currentPage = 1;
		}
		list = unitService.findUnitByPage(currentPage, pagePerNo);
		totalCount = unitService.getUnitCount();
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
		return "listP";
	}
	
	public String updateInfo() throws Exception {
		if(id != null && !"".equals(id)){
			unit = unitService.findById(id);
		}
		return "updateInfo";
	}
	
	public String update() throws Exception {
		System.out.println(unit.getName()+"---"+unit.getId());
		unitService.update(unit);
		return "update";
	}
	
	public String delete() throws Exception {
		System.out.println("ids=="+ids);
		ids.substring(0, ids.length()-1);
		unitService.delete(ids);
		return "delete";
	}
}
