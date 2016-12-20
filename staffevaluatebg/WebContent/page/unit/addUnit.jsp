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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加岗位</title>
<script type="text/javascript">
function submit1(){
	var unit = document.getElementById("name").value;
	if(unit!==null && unit!=="undefined" && unit!==""){
		document.forms[0].submit();
	}else{
		alert("不能为空!");
		return false;
	}
}
	function back(){
		window.location = "unit_listP.action";
	}
</script>
<style type="text/css">
	.back1{
		background-color:rgb(234,238,240);
		margin:0px left;
		height:135px;
		width:600px;
	}
	.d1{
    margin-left: 350px;
    margin-top: -52px;
    height: 35px;
	}
</style>
</head>
<body>
<div class="back1" style="border:solid 1px gray; ">
	<s:form action="unit_add.action" method="post">
	<div >
	<table style="margin-left:100px;margin-top:30px">
		<tr>
			<td><span style="font-size: 20px;;font-family:微软雅黑; ">新增单位名称：</span></td>
			<td><input type="text" name="unit.name" id="name"/></td>
		</tr>
	</table>
	</div>
	<div class="d1" >
		<div class="submit"><img src="images/保存.png" onclick="submit1()" style="width:80px;height:34px;float:left;cursor:pointer;"></div>
		<div class="back"><img src="images/退出.png" onclick="back()" style="width:80px;height:34px;float:left;cursor:pointer;"></div>
	</div>
	</s:form>
</div>	
</body>
</html>