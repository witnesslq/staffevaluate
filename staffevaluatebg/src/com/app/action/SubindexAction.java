package com.app.action;

import java.io.File;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.app.entity.Subindex;
import com.app.entity.Subindex;
import com.app.service.SubindexService;
/**
 * 
 * @author 邢昭武
 * 分项指标的action
 *
 */
public class SubindexAction extends SuperAction {
	private Subindex subindex;
	private SubindexService subindexService;
	private String ids;//分项指标的id组合（1，2，3）
	private Integer id;
	private List<Subindex> list;
	private Integer pageCount; //页面总数
	private Integer currentPage; //输出当前第几页
	private Integer pagePerNo;//每页的记录数
	private Integer totalCount;//记录总数

	public Subindex getSubindex() {
		return subindex;
	}

	public void setSubindex(Subindex subindex) {
		this.subindex = subindex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Subindex> getList() {
		return list;
	}

	public void setList(List<Subindex> list) {
		this.list = list;
	}

	public SubindexService getSubindexService() {
		return subindexService;
	}

	public void setSubindexService(SubindexService subindexService) {
		this.subindexService = subindexService;
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
		if (subindexService.save(subindex)) {
			return "add";
		}
		return "error";
	}

	public String updateInfo(){
		subindex = subindexService.findById(id);
		return "updateInfo";
	}

	/**
	 * 分项指标信息修改
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		if(subindex!=null){
			System.out.println("update:"+subindex.getName());
			subindexService.update(subindex);
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
			subindexService.deleteByIds(ids);
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
		list = subindexService.findAllByPage(currentPage, pagePerNo);
		totalCount = subindexService.getSubindexCount();
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
		subindex = subindexService.findById(id);
		return "findById";
	}
}
