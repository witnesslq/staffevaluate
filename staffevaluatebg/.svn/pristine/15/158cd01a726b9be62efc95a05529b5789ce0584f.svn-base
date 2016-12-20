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

	public Subindex getSubindex() {
		return subindex;
	}

	public void setSubindex(Subindex subindex) {
		this.subindex = subindex;
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

}
