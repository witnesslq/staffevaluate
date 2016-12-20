package com.app.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.app.entity.Czzn;
import com.app.service.CzznService;

public class UploadCZZNAction extends SuperAction{
	private Czzn czzn;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private CzznService czznService;
	public Czzn getCzzn() {
		return czzn;
	}
	public void setCzzn(Czzn czzn) {
		this.czzn = czzn;
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
	public CzznService getCzznService() {
		return czznService;
	}
	public void setCzznService(CzznService czznService) {
		this.czznService = czznService;
	}
	public String add(){
		String path = ServletActionContext.getServletContext().getRealPath("/video");
		System.out.println("--------------------------------"+path);
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		try {
			FileUtils.copyFile(upload, new File(file,uploadFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		czzn = new Czzn();
		czzn.setName("video" + "/" + uploadFileName);
//		staff.setSex('1');
		if (czznService.addCzzn(czzn)) {
			return "add";
		}
		return "error";
	}
	public String show(){
		czzn = czznService.get();
		return "show";
	}
}
