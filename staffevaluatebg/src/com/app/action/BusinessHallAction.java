package com.app.action;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.app.entity.BusinessHall;
import com.app.entity.Unit;
import com.app.service.BusinessHallService;
import com.app.service.UnitService;
import com.app.util.JsonFilter;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
/**
 * 
 * @author 吴雨桐
 * 
 * 营业厅action
 *
 */
public class BusinessHallAction extends SuperAction {
	
	private BusinessHall businessHall;
	private BusinessHallService businessHallService;
	private UnitService unitService;
	private Integer pageCount; //页面总数
	private Integer currentPage; //输出当前第几页
	private Integer businessHallCount;//记录总数
	private Integer unitid;//单位编号
	private List<Unit> list;//单位集合
	private Unit unit;
	private Integer id;
	private String ids;//营业厅的id组合（1，2，3）
	private List<BusinessHall> listAll;  //营业厅
	
	
	
	public List<BusinessHall> getListAll() {
		return listAll;
	}

	public void setListAll(List<BusinessHall> listAll) {
		this.listAll = listAll;
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



	public List<Unit> getList() {
		return list;
	}

	public void setList(List<Unit> list) {
		this.list = list;
	}

	public Integer getUnitid() {
		return unitid;
	}

	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}

	public Integer getBusinessHallCount() {
		return businessHallCount;
	}

	public void setBusinessHallCount(Integer businessHallCount) {
		this.businessHallCount = businessHallCount;
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

	
	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}

	public BusinessHall getBusinessHall() {
		return businessHall;
	}

	public void setBusinessHall(BusinessHall businessHall) {
		this.businessHall = businessHall;
	}

	public BusinessHallService getBusinessHallService() {
		return businessHallService;
	}

	public void setBusinessHallService(BusinessHallService businessHallService) {
		this.businessHallService = businessHallService;
	}
	/**
	 * 添加营业厅
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		businessHall.setUnit(unit);
		//System.out.println(businessHall);
		if (businessHallService.save(businessHall)) {
			return "add";
		}
		return "error";
	}
	
	/**
	 * 分页获取所有营业厅
	 * 
	 * @return
	 */
	public String listP() {
		
		
		if (unitid==null) {
			unitid = 0;
		}
		try {
			businessHallCount = businessHallService.getBusinessHallCount(unitid);
			System.out.println("-----总数为："+businessHallCount);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		pageCount = businessHallService.getPageCount(businessHallCount, businessHallService.BusinessHall_PAGE_SIZE);
		System.out.println("营业厅总页数"+pageCount);
		if(currentPage==null){
			currentPage = 1;
		}
		System.out.println(unitid);
		listAll =  businessHallService.findAllByPage(currentPage,unitid);
		System.out.println("-------------------------取到list---------------------------");
		for(BusinessHall bh : listAll){
			System.out.println(bh.getName());
		}
		try {
		 list = unitService.findAllUnit();
		for(Unit unit:list){
			System.out.println(unit.getName());
		}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listP";
	}
	/**
	 * 		增加一个营业厅
	 * @return
	 */
	public String addinfo(){
		System.out.println("------进入addinfo-----");
		try {
			 list = unitService.findAllUnit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("------出来addinfo-----");
		return "addinfo";
	}
	
	/**
	 * 		返回要更改的营业厅的信息
	 * @return
	 */
	public String updateInfo(){  
		if(id>0){
			try {
				businessHall = businessHallService.getBusinessHallById(id);
				list = unitService.findAllUnit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			return "error";
		}
		return "updateInfo";
	}
	
	/**
	 * 更新营业厅信息
	 */
	public String update(){
		if(businessHallService.updateBussinessHall(businessHall)>0){
			return "update";
		}else{
			return "error";
		}
	}
	
	public String delete(){
		if(ids!=null||ids.trim().length()>0){
			businessHallService.deleteByIds(ids);
		}else{
			return "error";
		}
		return "delete";
	}
}
