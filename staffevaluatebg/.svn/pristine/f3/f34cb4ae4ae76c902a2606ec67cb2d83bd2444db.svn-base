package com.app.log;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;

import com.app.entity.Staff;

/**
 * 
 * 记录操作日志的处理组建
 *
 * @author 吴雨桐
 */
public class LoggerBean {
	private Logger logger = Logger.getLogger(LoggerBean.class);

	public void afterThrowing(JoinPoint joinPoint, Throwable e) throws Throwable {
		if (e != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Staff user = (Staff) session.getAttribute("user");
			String ip = request.getRemoteAddr();
			Class c1 = joinPoint.getTarget().getClass();
			Method[] methods = c1.getMethods();
			for (Method m : methods) {
				if (m.getName().equals(joinPoint.getSignature().getName())) {
					logger.info("----------------异常信息----------------");
					logger.info(new SimpleDateFormat("MM-dd HH:mm:ss").format(new Date()));
					if (user != null) {
						logger.info("员工：" + user.getName() + "访问ip:" + ip + "在执行方法" + m.getName() + "时抛出异常...");
					}
					logger.info("-----------------报错信息---------------");
					logger.info(e.getMessage());
				}
			}
		}

	}
}
