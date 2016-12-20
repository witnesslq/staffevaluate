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
<title>Insert title here</title>
<base href="<%=basePath%>">
</head>
<body>
<s:form action="staff_add.action" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>姓名：</td>
			<td><input type="text" name="staff.name"/></td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="staff.username"/></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td><select name="staff.sex">
			<option value="男">男</option>
			<option value="女">女</option>
			</select></td>
		</tr>
		<tr>
			<td>联系电话：</td>
			<td><input type="text" name="staff.phone"></td>
		</tr>
		<tr>
			<td>角色：</td>
			<td>
				<select name="staff.role.role_id">
					<s:iterator value="roleList" var="role">
						<option value="${role.role_id}">${role.name}</option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td>岗位：</td>
			<td>
				<select name="staff.post.post_id">
					<s:iterator value="postList" var="post">
						<option value="${post.post_id}">${post.name}</option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td>图片：</td>
			<td><input type="file" name="upload"></td>
		</tr>
	</table>
	<input type="submit" text="提交">
	</s:form>
</body>
</html>