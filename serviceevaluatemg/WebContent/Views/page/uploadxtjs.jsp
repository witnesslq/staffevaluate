<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传系统介绍</title>
<base href="<%=basePath%>">
</head>
<body>
	<form id="text" action="uploadxtjs_add.action"  method="post">
		<label style="font-size: 30px">请输入系统介绍(500字以内，带空格)</label><br/>
		<textarea rows="30" cols="100" name="xtjs.xtjstxt"  id="xtjs"></textarea><br/>
		<input type="submit" value="应用"/>
		<input type="reset" value="重置"/>
	</form>
</body>
</html>