package com.app.action;

import com.app.entity.Xtjs;
import com.app.service.XtjsService;

public class UploadXTJSAction {
	private Xtjs xtjs;
	private XtjsService xtjsService;
	

	public void setXtjsService(XtjsService xtjsService) {
		this.xtjsService = xtjsService;
	}

	public Xtjs getXtjs() {
		return xtjs;
	}

	public void setXtjs(Xtjs xtjs) {
		this.xtjs = xtjs;
	}


	public String add(){
		System.out.println(xtjs.getXtjstxt());
		String xtjsTxt = xtjs.getXtjstxt();
		xtjsTxt = xtjsTxt.replaceAll(" ","&nbsp;").replaceAll("\r","<br/>");
		System.out.println(xtjsTxt);
		xtjs.setXtjstxt(xtjsTxt);
		if(xtjsService.addXtjs(xtjs)){
			return "add";
		}else{
			return "error";
		}
	}
	public String show(){
 		xtjs = xtjsService.get();
		return "show";
	}
}
