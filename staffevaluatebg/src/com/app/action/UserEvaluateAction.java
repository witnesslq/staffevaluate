package com.app.action;

import java.util.List;
import java.util.Map;

import com.app.entity.Staff;
import com.app.entity.Subindex;
import com.app.entity.UserEvaluate;
import com.app.service.StaffService;
import com.app.service.SubindexService;
import com.app.service.UserEvaluateService;
/**
 * 员工评价的action类
 * @author 吴雨桐
 *
 */
public class UserEvaluateAction extends SuperAction{
	private UserEvaluate userEvaluate;
	private UserEvaluateService userEvaluateService;
	private StaffService staffService;
	private Staff staff;
	private List<UserEvaluate> list;
	private Map<Character, String> returnStatusOptions;
	private SubindexService subindexService;
	private List<String> lists;
	private Integer currentPage;
	private Integer pageCount;		//页数
	private String key;
	private Integer rowCount;
	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Map<Character, String> getReturnStatusOptions() {
		return returnStatusOptions;
	}

	public void setReturnStatusOptions(Map<Character, String> returnStatusOptions) {
		this.returnStatusOptions = returnStatusOptions;
	}

	public void setSubindexService(SubindexService subindexService) {
		this.subindexService = subindexService;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<UserEvaluate> getList() {
		return list;
	}

	public void setList(List<UserEvaluate> list) {
		this.list = list;
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public UserEvaluateService getUserEvaluateService() {
		return userEvaluateService;
	}

	public void setUserEvaluateService(UserEvaluateService userEvaluateService) {
		this.userEvaluateService = userEvaluateService;
	}

	public UserEvaluate getUserEvaluate() {
		return userEvaluate;
	}

	public void setUserEvaluate(UserEvaluate userEvaluate) {
		this.userEvaluate = userEvaluate;
	}

	public String add() {
		staff = staffService.getStaff(userEvaluate.getStaff().getId());
		userEvaluate.setIsReturn('0');
		userEvaluate.setIsValid('0');
		if (userEvaluateService.addUserEvaluate(userEvaluate)) {
			return "add";
		} else {
			return "error";
		}
	}

	/*
	 * 所有评论，分页
	 */
	public String listAll() {
		// System.out.println(key);
		if (currentPage == null || currentPage < 1) {
			currentPage = 1;
		}
		System.out.println("---------" + key);
		if ("1".equals(key)) {
			list = userEvaluateService.listPage1(currentPage, 10, "批评");
			pageCount = userEvaluateService.getPageCount1(10, "批评");
			rowCount = userEvaluateService.getRowCount("批评");
		} else if ("2".equals(key)) {
			list = userEvaluateService.listPage1(currentPage, 10, "建议");
			pageCount = userEvaluateService.getPageCount1(10, "建议");
			rowCount = userEvaluateService.getRowCount("建议");
		} else if ("3".equals(key)) {
			list = userEvaluateService.listPage1(currentPage, 10, "表扬");
			// System.out.println(147);
			pageCount = userEvaluateService.getPageCount1(10, "表扬");
			rowCount = userEvaluateService.getRowCount("表扬");
		} else {
			key = "0";
			list = userEvaluateService.listPage(currentPage, 10);
			// System.out.println(list);
			pageCount = userEvaluateService.getPageCount(10);
			rowCount = userEvaluateService.getAllRowCount();
			// System.out.println(pageCount);
		}

		// System.out.println(list.get(1).getSubindex_ids());
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i).getSubindex_ids();
			System.out.println("员工姓名"+list.get(i).getStaff().getName());
			if (s == null || s.trim().length() == 0) {
				list.get(i).setSubindex_ids("无");
			} else {
				List<Subindex> list1 = subindexService.getByIds(s);
				// System.out.println(list1.toString());
				String subnames = "";
				for (Subindex sub : list1) {
					// if(sub.getName()!=null)
					subnames += sub.getName()+" ";
				}
				System.out.println(subnames);
				//session管理着的list，是持久化状态不能随便set会更新
				//list.get(i).setSubindex_ids(subnames);
			}
		}
		returnStatusOptions = userEvaluateService.getReturnStatusOptions();
		return "listAll";
	}
	
	/**
	 * 是否回访
	 * @return
	 */
	public String returnBack(){
		if(ids!=null){
			userEvaluateService.updateReturn(ids);
		}
		return "back";
	}
	
	/**
	 * 是否有效
	 * @return
	 */
	public String returnValid(){
		if(ids!=null){
			userEvaluateService.updateValid(ids);
		}
		return "valid";
	}
}
