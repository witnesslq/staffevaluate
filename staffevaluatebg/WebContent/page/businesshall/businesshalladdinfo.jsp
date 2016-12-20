<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="utf-8" />
		<base href="<%=basePath%>">
		<title>营业厅维护</title>
		<link rel="stylesheet" href="css/businesshalladdinfo.css" />
		<script type="text/javascript">
			function Submit(){
				document.forms[0].submit();
			}
			function Cancel(){
				window.location="businessHall_listP.action";
			}
</script>
	</head>
	<body>
	<div class="title">
		<div style="margin-top:5px;">新增营业厅</div>
	</div>
		<div class="backsize" >
				<form id="from1" method="post" action="businessHall_add.action">
				<div class="table">
					<table>
						<tr>
							<td >营业厅所属单位：</td>
							<td><select name="unit.id">
								<s:iterator value="list" var="unit">
									<option value="${unit.id}">${unit.name}</option>
								</s:iterator>
							</select></td>
						</tr>
						<tr>
							<td >营业厅名称：</td>
							<td ><input type="text" id="company_name" name="businessHall.name"  size="20"class="inboxtwo"/></td>
						</tr>
						<tr >
							<td >营业厅级别：</td>
							<td >
								<select id="s" name="businessHall.level">
									<option value="A" selected>A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="E">E</option>
								</select>
							</td>
						</tr>
						<tr>
							<td >营业厅地址：</td>
							<td ><input type="text" id="company_address" name="businessHall.address" size="20" class="inboxtwo"/></td>
						</tr>
						<tr>
							<td >营业厅编码：</td>
							<td ><input type="text" id="company_coid" name="businessHall.no"  class="inboxtwo"/></td>
						</tr>
					</table>
					</div>
				</form>
				<div class="function">
						<input type="image" src="images/保存.png" onclick="Submit()" >
						<input type="image" src="images/退出.png" onclick="Cancel()" >
					</div>
		</div>
	</body>
</html>