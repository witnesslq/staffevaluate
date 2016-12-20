package com.app.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 所有action的父类，其所有子类可以直接使用request、response、application对象
 * @author 邢昭武
 *
 */
public class SuperAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;
	
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
