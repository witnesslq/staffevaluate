<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title> 使用指南</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style type="text/css">
	video.margin {margin:10px -10px 0 -2px}
	</style>
	<link rel="stylesheet" href="../styles/1.css" />
</head>

<body class="margin" display:block margin:0px>
<div class="section1">
			<span>操作指南</span>
	</div>
	<video class="margin" controls="controls" width="640" height="380" autoplay="autoplay">
  		<source src="<s:property value="czzn.name"/>" type="video/mp4" />
	</video>
</body>
</html>