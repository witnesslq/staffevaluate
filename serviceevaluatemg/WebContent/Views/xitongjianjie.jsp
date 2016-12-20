<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--                 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
<base href="<%=basePath%>">
<script type="text/javascript" src="scripts/jquery-3.0.0.js"></script>
<script type="text/javascript">
	function xtjj(){
		window.location.href="Views/home.jsp";
	}
	function home(){
		window.location.href="Views/main.jsp"
	}
</script>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title></title>
  	 <!-- <link rel="stylesheet" type="text/css" href="styles/1.css" /> -->
  	 <base href="<%=basePath%>">
  	 <!-- 页面内容不能被选中 -->
  	 <style type="text/css">
  	 	.section2{
				-moz-user-select: none;
				-webkit-user-select: none;
				-ms-user-select: none;
				-khtml-user-select: none;
				user-select: none;
  	 	}
  	 </style>
  	   	 </style>
  	    <style type="text/css">

body{FONT-SIZE:12pt;font-family: "微软雅黑"}

th{FONT-SIZE:12pt;font-family:"微软雅黑"}

td{FONT-SIZE:12pt;font-family:"微软雅黑"}

</style>
<link rel="stylesheet" href="styles/main.css">
</head>
<body>
<div style=" position: absolute;
    background-image: url(images/main_xtjj1.jpg);
	background-size: cover;
    width: 1360px;
    height: 900px;
    top: 10;">
    <img alt="" src="images/zhuye.jpg" style="position: absolute;left:1230px;top:135px"onclick="home()">
		<div class="homeBody">
			<span class="xtjj"><s:property value="xtjs.xtjstxt" escape="false"/></span>
			</div>
		</div>
		<div  style="position: absolute;left:780px;top:857px;color:white;font-family: '微软雅黑';font-size:15px;">
		${session.ipAddress }
		</div>
</body>
</html>
