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
<title>Insert title here</title>
<base href="<%=basePath%>">
</head>
<body>
	Success!
	<a href="staff_loginform.action">进入登录页面</a>
	<a href="Views/page/addRole.jsp">录入角色信息</a>
	<a href="Views/page/addPost.jsp">录入岗位信息</a><br/>
	<a href="Views/page/addSubindex.jsp">录入分项指标</a>
	<a href="Views/page/staff_getRolesAndPosts.action">录入服务人员</a>
	<a href="Views/page/uploadxtjs.jsp">录入系统介绍</a>
	<a href="Views/page/uploadzcfg.jsp">录入政策法规</a>
</body>
</html>