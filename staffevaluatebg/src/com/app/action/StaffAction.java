package com.app.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.app.entity.BusinessHall;
import com.app.entity.Post;
import com.app.entity.Role;
import com.app.entity.Staff;
import com.app.entity.Subindex;
import com.app.entity.UserCookie;
import com.app.service.BusinessHallService;
import com.app.service.PostService;
import com.app.service.RoleService;
import com.app.service.StaffService;
import com.app.service.SubindexService;

/**
 * 
 * @author 邢昭武
 * 
 *         员工action类
 *
 */
public class StaffAction extends SuperAction {
	private Staff staff;
	private StaffService staffService;
	private SubindexService subindexService;
	private RoleService roleService;
	private PostService postService;
	private BusinessHallService businessHallService;
	private String satisfaction;
	private String ids;
	private String roleid;
	private String postid;
	List<Post> postList;
	List<Role> roleList;
	List<Subindex> sbuindexList;
	List<BusinessHall> businessHallList;
	private Integer id;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String result;
	private Integer pageCount; //页面总数
	private Integer currentPage; //输出当前第几页
	private Integer staffCount;//记录总数
	private String no;
	private String name;
	private Integer BusinessHallid;
	private Map sexMap;
	

	public Map getSexMap() {
		return sexMap;
	}

	public void setSexMap(Map sexMap) {
		this.sexMap = sexMap;
	}

	public BusinessHallService getBusinessHallService() {
		return businessHallService;
	}

	public void setBusinessHallService(BusinessHallService businessHallService) {
		this.businessHallService = businessHallService;
	}

	public List<BusinessHall> getBusinessHallList() {
		return businessHallList;
	}

	public void setBusinessHallList(List<BusinessHall> businessHallList) {
		this.businessHallList = businessHallList;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBusinessHallid() {
		return BusinessHallid;
	}

	public void setBusinessHallid(Integer businessHallid) {
		BusinessHallid = businessHallid;
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



	public Integer getStaffCount() {
		return staffCount;
	}

	public void setStaffCount(Integer staffCount) {
		this.staffCount = staffCount;
	}

	public List<Subindex> getSbuindexList() {
		return sbuindexList;
	}

	public void setSbuindexList(List<Subindex> sbuindexList) {
		this.sbuindexList = sbuindexList;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}

	List<Subindex> listSubindex;

	public List<Subindex> getListSubindex() {
		return listSubindex;
	}

	public void setListSubindex(List<Subindex> listSubindex) {
		this.listSubindex = listSubindex;
	}

	public SubindexService getSubindexService() {
		return subindexService;
	}

	public void setSubindexService(SubindexService subindexService) {
		this.subindexService = subindexService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	/**
	 * 添加员工
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		// 获取项目在服务器的真实路径，并将上传的员工照片放在upload文件夹下面
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		if (upload != null) {
			FileUtils.copyFile(upload, new File(file, uploadFileName));
			staff.setPhoto("upload" + "/" + uploadFileName);
			String maxId = staffService.getNewStaffId();
			staff.setStaff_no(maxId);
			staff.setPassword("123456");
		} else {
			// 如果未选择上传的图片，则将其默认设置为nan.ico和nv.ico;
			if ('男' == staff.getSex()) {
				staff.setPhoto("images" + "/" + "nan.ico");
			} else if ('女' == staff.getSex()) {
				staff.setPhoto("images" + "/" + "nv.ico");
			}
			String maxId = staffService.getNewStaffId();
			staff.setStaff_no(maxId);
			staff.setPassword("123456");
		}
		result = "上传成功";
		if (staffService.addStaff(staff)) {
			return "add";
		}
		return "error";
	}

	/**
	 * 获取所有员工列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<Staff> listStaff = staffService.getAllStaff();
		for (Staff s : listStaff) {
			System.out.println(s.toString());
		}
		request.setAttribute("listStaff", listStaff);
		return "list";
	}

	/**
	 * 分页获取所有员工信息
	 * 
	 * @return
	 */
	public String listP() {
		if(BusinessHallid==null){
			BusinessHallid = 0;
		}
		if(no==null){
			no = "";
		}
		if(name==null){
			name="";
		}
		try {
			staffCount = staffService.getStaffCountByParam(no, name, BusinessHallid);
			System.out.println("共有记录条数:"+staffCount);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (staffCount < 1) {
			return "No";
		}
		pageCount = staffService.getPageCount(staffCount, staffService.STAFF_PAGE_SIZE);
		System.out.println("共有页数："+pageCount);
		if (currentPage==null) {
			currentPage = 1;
		}
		
		if (currentPage > pageCount) {
			currentPage = pageCount;
		}
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("currentPage", currentPage);
		try {
			List<Staff> listStaff = staffService.findAllByPage(currentPage, staffService.STAFF_PAGE_SIZE, no, name, BusinessHallid);
			for(Staff staff:listStaff){
				System.out.println(staff.getName());
			}
			businessHallList = businessHallService.findAllBusinessHall();
			for(BusinessHall businessHall:businessHallList){
				System.out.println(businessHall.getName());
			}
			request.setAttribute("listStaff", listStaff);
			request.setAttribute("businessHallList", businessHallList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listP";
	}

	/**
	 * 根据员工id获取指定员工信息
	 * @return
	 * @throws Exception
	 */
	public String getStaffById() throws Exception {
		staff = staffService.getStaff(id);
		return "get";
	}

	/**
	 * 保存用户信息到cookie中
	 * @param name cookie名
	 * @param value cookie值
	 * @param timeLong 有效时间
	 */
	private void addCookie(String name, String value, int timeLong) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(timeLong);
		ServletActionContext.getResponse().addCookie(cookie);
	}

	/**
	 * 根据cookie的name得到对应的cookie值
	 * 
	 * @return
	 * @throws Exception
	 */
	private String getCookie(String name) {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * 登录流程
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		Staff staff = (Staff) request.getSession().getAttribute("user");
		if (staff != null) {
			return "login";
		}
		String rememberMe = request.getParameter("rember");
		if (rememberMe != null) {
			if (!username.equals("") && !password.equals("")) {
				// 创建Cookie
				System.out.println("username:---------------------" + URLEncoder.encode(username, "utf8"));
				String userinfo = URLEncoder.encode(username, "utf8") + "," + password;
				Cookie userCookies = new Cookie("userCookies", userinfo);
				userCookies.setMaxAge(60 * 60 * 24 * 60);// 周期是60天
				response.addCookie(userCookies);
			}
		}
		List<Staff> list = staffService.getStaffByUserAndPassword(username, password);
		if (list != null && list.size() > 0) {
			Staff staff1 = list.get(0);
			System.out.println(list.get(0).toString());
			request.getSession().setAttribute("user", staff1);
			return "login";

		}
		request.setAttribute("loginError", "用户名密码不合法,请重新出入");
		request.setAttribute("username", username);
		return "loginError";

	}

	/**
	 * 登录前，取得cookie的值，然后做相应的判断，如果cookie中有值，将其保存在request中
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String loginform() throws UnsupportedEncodingException {
		List<UserCookie> userCookies = new ArrayList<UserCookie>();
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println("ip地址1：-------------" + request.getRemoteAddr());
		System.out.println("ip地址1：-------------" + request.getHeader("X-Real-IP"));
		System.out.println("ip地址1：-------------" + request.getHeader("WL-Proxy-Client-IP"));
		System.out.println("ip地址1：-------------" + request.getHeader("WL-Proxy-Client-IP"));
		System.out.println("ip地址1：-------------" + request.getHeader("Proxy-Client-IP"));
		String ipAddress = getIpAddr(request);
		Cookie[] cookies = request.getCookies();
		request.getSession().setAttribute("ipAddress", "IP:" + ipAddress);
		if (cookies != null) {
			for (Cookie c : cookies) {
				System.out.println(c.getName() + "-----" + c.getValue());

				if (c.getName().equals("userCookies")) {

					String str = URLDecoder.decode(c.getValue(), "utf-8");
					request.setAttribute("data", str);
				}

			}

		}
		return "loginform";
	}

	/**
	 * 获取客户端的ip地址
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 根据id获取指定的员工信息，这里取到了分项指标的列表信息，作为前台选择分项指标的列表
	 * @return
	 */
	public String getOne() {
		String idStr = request.getParameter("id");
		listSubindex = subindexService.findAllSubindex();
		int id = Integer.parseInt(idStr);
		staff = staffService.getStaff(id);
		return "getOne";
	}

	/**
	 * 也是getOne,只不过result不一样
	 * 
	 * @return
	 */
	public String getNamePic() {
		String idStr = request.getParameter("id");
		if (ids.length() >= 1) {
			ids = ids.substring(0, ids.length() - 1);
		}
		int id = Integer.parseInt(idStr);
		staff = staffService.getStaff(id);
		listSubindex = subindexService.getByIds(ids);
		System.out.println(listSubindex);
		return "getNamePic";
	}

	/**
	 * 获取所有的角色和岗位信息，在添加员工时候，需要这两个列表信息
	 * @return
	 */
	public String addinfo() {
		postList = postService.findAllPost();
		roleList = roleService.findAllRole();
		businessHallList = businessHallService.findAllBusinessHall();
		return "addinfo";
	}
	
	/**
	 * 得到要更新的员工信息
	 * @return
	 */
	public String updateInfo(){
		postList = postService.findAllPost();
		roleList = roleService.findAllRole();
		businessHallList = businessHallService.findAllBusinessHall();
		staff = staffService.getStaff(id);
		sexMap = staffService.getSex();
		return "updateInfo";
	}
	
	public String update() throws Exception{
		System.out.println(staff);
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		if (upload != null) {
			FileUtils.copyFile(upload, new File(file, uploadFileName));
			staff.setPhoto("upload" + "/" + uploadFileName);
		} else {
			// 如果未选择上传的图片，则将其默认设置为nan.ico和nv.ico;
			if ('男' == staff.getSex()) {
				staff.setPhoto("images" + "/" + "nan.ico");
			} else if ('女' == staff.getSex()) {
				staff.setPhoto("images" + "/" + "nv.ico");
			}
		}
		if(staffService.updateStaff(staff)>0){
			return "update";
		}else{
			return "updateError";
		}
	}
	
	public String delete(){
		if(ids!=null||ids.trim().length()>0){
			staffService.deleteByIds(ids);
		}
		return "delete";
	}
}
