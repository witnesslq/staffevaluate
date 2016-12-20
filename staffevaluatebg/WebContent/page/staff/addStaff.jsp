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
<link rel="stylesheet" type="text/css" href="css/addStaff.css" />
<script type="text/javascript">
	function Submit(){
		//尽量用这种提交
		document.forms[0].submit();
	}
	function Cancel(){
		location.href = "staff_listP.action";
	}
</script>
</head>
<body>
<div class="title">
		<div style="margin-top:5px;">新增员工</div>
	</div>
<div class="backsize">
<s:form action="staff_add.action" method="post" enctype="multipart/form-data">
	
	<div class="table">
	<table style="border-collapse:separate; border-spacing:0px 15px;">
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
			<option value="1">男</option>
			<option value="2">女</option>
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
			<td>营业厅：</td>
			<td>
				<select name="staff.businessHall.id">
					<s:iterator value="businessHallList" var="businessHall">
						<option value="${businessHall.id}">${businessHall.name}</option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td>图片：</td>
			<td><input type="file" name="upload"></td>
		</tr>
	</table>
	<div>
		<span style="font-size:10px; color:red;">(注意：初始密码默认为123456)</span>
	</div>
	</div >
	</s:form>
	<div class="function">
		<input type="image" src="images/保存.png" onclick="Submit();" style="">
		<input type="image" src="images/退出.png" onclick="Cancel();" style="">
	</div>
	</div>
</body>
</html>