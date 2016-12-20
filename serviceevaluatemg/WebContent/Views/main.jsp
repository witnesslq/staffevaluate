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
<style type="text/css">

body{FONT-SIZE:12pt;font-family: "微软雅黑"}

th{FONT-SIZE:12pt;font-family: "微软雅黑"}

td{FONT-SIZE:12pt;font-family: "微软雅黑"}
p{FONT-SIZE:12pt;font-family: "微软雅黑"}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
<base href="<%=basePath%>">
<script type="text/javascript" src="scripts/jquery-3.0.0.js"></script>
<script type="text/javascript">
	function xtjj(){
		window.location.href="uploadxtjs_show.action";
	}
	function fwpj(){
		window.location.href="staff_listP.action";
	}
	function zcfg(){
		window.location.href="uploadzcfg_show.action";
	}
</script>
</head>
<link rel="stylesheet" href="styles/main.css">

<body>
<div class="main">
		<form action="staff_login.action" method="post">
		<div style="margin-top: 285px;float: left" ; align="center">
			<img style="margin-left: 249px;" alt="" src="images/xtnejs.jpg" onclick="xtjj()">
			<img style="margin-left: 92px;"alt="" src="images/fwpzpj.jpg"onclick="fwpj()">
			<img alt=""style="margin-left: 92px;" src="images/zcfgjj.jpg" onclick="zcfg()">
		</div>
		</form>
    </div>
    <div style="position: absolute;left:780px;top:842px;">
    	${session.ipAddress }
    </div>
</body>
</html>
