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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加分项指标</title>
</head>
<body>
	<s:form action="subindex_add.action" method="post">
	<table>
		<tr>
			<td>分项指标名称：</td>
			<td><input type="text" name="subindex.name"/></td>
		</tr>
	</table>
	<input type="submit" text="提交">
	</s:form>
</body>
</html>