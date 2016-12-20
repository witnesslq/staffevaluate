package com.app.action;

import com.app.entity.Zcfg;
import com.app.service.ZcfgService;

/**
 * 政策法规的action类
 * 
 * @author 吴雨桐
 *
 */
public class UploadZCFGAction {
	private Zcfg zcfg;
	private ZcfgService zcfgService;

	public void setZcfgService(ZcfgService zcfgService) {
		this.zcfgService = zcfgService;
	}

	public Zcfg getZcfg() {
		return zcfg;
	}

	public void setZcfg(Zcfg zcfg) {
		this.zcfg = zcfg;
	}

	/**
	 * 添加政策法规
	 * 
	 * @return
	 */
	public String add() {
		System.out.println(zcfg.getZcfgtxt());
//		String zcfgTxt = zcfg.getZcfgtxt();
//		zcfgTxt = zcfgTxt.replaceAll(" ", "&nbsp;").replaceAll("\r", "<br/>");
//		zcfg.setZcfgtxt(zcfgTxt);
		if (zcfgService.addZcfg(zcfg)) {
			return "add";
		} else {
			return "error";
		}
	}

	public String show() {
		zcfg = zcfgService.get();
		return "show";
	}
}
