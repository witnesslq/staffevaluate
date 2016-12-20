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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title></title>
   <link rel="stylesheet" type="text/css" href="styles/1.css">
   <link rel="stylesheet" type="text/css" href="styles/2.css">
   <base href="<%=basePath%>">
   <style type="text/css">

body{FONT-SIZE:12pt;font-family: "微软雅黑"}

th{FONT-SIZE:12pt;font-family:"微软雅黑"}

td{FONT-SIZE:10pt;font-family:"微软雅黑"}


</style>
</head>
<body>
<div class="section">
	<div class="section1">
		<span>服务人员评价 </span>
	</div>
	<div class="section2">
	<s:iterator value="#request.listStaff" var="staff">
		<div class="staffw" >
		<img src="<s:property value="#staff.photo"/>" style="margin-left:10px;width:100px;height:100px;margin-top:10px">
		<div class="staffs" onclick="javascript:window.location.href='staff_getOne.action?id=${staff.id}'">
			
			<table class="table1" cellpadding="0" cellspacing="1">
				<tr align="left"><td>&nbsp;&nbsp;&nbsp;工号：${staff.staff_no}</td></tr>
				<tr align="left"><td>&nbsp;&nbsp;&nbsp;姓名：${staff.username}</td></tr>
			</table>
		</div> 
	</div>
	</s:iterator>
	<div style="position:absolute;bottom:25px;right:30px;">
		
		<div class="fenye"><a href="staff_listP.action?pageNo=1"><img alt="" src="images/sy.jpg"></a></div>
		<div class="fenye">
			<s:if test="#request.currentPage>1">
				<a href="staff_listP.action?pageNo=${request.currentPage-1}"><img alt="" src="images/3.gif"></a>
			</s:if>
			<s:else>
				<img alt="" src="images/3.gif">
			</s:else>
		</div>
		<div class="fenye">
			<s:if test="#request.pageCount>#request.currentPage">
				<a href="staff_listP.action?pageNo=${request.currentPage+1}"><img alt="" src="images/4.gif"></a>
			</s:if>	
			<s:else>
				<img alt="" src="images/4.gif">
			</s:else>
		</div>
		<div class="fenye"><a href="staff_listP.action?pageNo=${request.pageCount}"><img alt="" src="images/wy.jpg"></a></div>
		<div class="total">共 <font style="color:blue;size: 12px;font-family: '微软雅黑'">${request.pageCount}</font>页,当前第 <font style="color:red;size: 12px;font-family: '微软雅黑'">${request.currentPage}</font>页 </div>
	</div>
	</div>
</div>
</body>
</html>