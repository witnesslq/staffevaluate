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
<link rel="stylesheet" type="text/css" href="css/businesshallweihu.css" />
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
<script type="text/javascript">
			function Submit(){
				document.forms[0].submit();
			}
			function Cancel(){
				location.href = "businessHall_listP.action";
			}
</script>
</head>
<body>
<div class="title">
		<div style="margin-top:5px;">营业厅信息维护</div>
	</div>
<div class="backsize">
<div class="left">
	<table>
		<tr>
			<td colspan="2" align="center">原始信息</td>
		</tr>
		<tr>
			<td>营业厅名称：</td>
			<td><input type="text" value="${businessHall.name }" disabled/></td>
		</tr>
		<tr>
			<td>营业厅所属单位：</td>
			<td><input type="text" value="${businessHall.unit.id }" disabled></td>
		</tr>
		<tr>
			<td>营业厅级别：</td>
			<td><input type="text" value="${businessHall.level }" disabled></td>
		</tr>
		<tr>
			<td>营业厅地址：</td>
			<td><input type="text" value="${businessHall.address }" disabled></td>
		</tr>
	</table>
</div>
<div class="right">
	<s:form action="businessHall_update.action" method="post" >
	<input type="hidden" value="${businessHall.id }" name="businessHall.id">
	<table >
		<tr>
			<td colspan="2" align="center">更改信息</td>
		</tr>
		<tr>
			<td>营业厅名称：</td>
			<td><input type="text" value="${businessHall.name }" name="businessHall.name"/></td>
		</tr>
		<tr>
			<td>营业厅所属单位：</td>
			<td><select name="businessHall.unit.id">
								<s:iterator value="list" var="u">
									<option value="${u.id}">${u.name}</option>
								</s:iterator>
							</select></td>
		</tr>
		<tr>
			<td>营业厅级别：</td>
			<td><select id="s" name="businessHall.level">
									<option value="A" selected>A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="E">E</option>
								</select></td>
		</tr>
		<tr>
			<td>营业厅地址：</td>
			<td><input type="text" value="${businessHall.address }" name="businessHall.address"></td>
		</tr>
	</table>
	</s:form>
	<div class="function">
		<input type="image" src="images/保存.png" onclick="Submit();" >
		<input type="image" src="images/退出.png" onclick="Cancel();" >
	</div>
</div>	
</div>
</body>
</html>