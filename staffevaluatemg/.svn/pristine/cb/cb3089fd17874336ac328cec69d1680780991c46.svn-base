<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务品质评价</title>
<link rel="stylesheet" href="styles/style3.css" />
   <style type="text/css">

body{FONT-SIZE:12pt;font-family: "微软雅黑"}

th{FONT-SIZE:12pt;font-family:"微软雅黑"}

td{FONT-SIZE:12pt;font-family:"微软雅黑"}

</style>
<base href="<%=basePath%>">
<script language="javascript">
var id = "${staff.id}";
function changeColor(field)
{
	//document.getElementsByClass("size1").style.fontWeight="bold";
	//alert('123');
	var ck = field.checked;
	//alert(ck);
	//js代码敬爱的功能 复选框
	ck?field.nextSibling.style.fontWeight = "bold":field.nextSibling.style.fontWeight="normal";
	//alert('123');
}
function biaoyang(){
	var chestr="";
	var str=document.getElementsByName("service");
	var objarray=str.length;
	for (i=0;i<objarray;i++)
	{//牛图库JS特效，http://js.niutuku.com/
	  if(str[i].checked == true)
	  {
	   chestr+=str[i].value+",";
	  }
	}
	window.location.href="staff_getNamePic.action?id="+id+"&ids="+chestr+"&satisfaction=表扬";
}
function jianyi(){
	var chestr="";
	var str=document.getElementsByName("service");
	var objarray=str.length;
	for (i=0;i<objarray;i++)
	{//牛图库JS特效，http://js.niutuku.com/
	  if(str[i].checked == true)
	  {
	   chestr+=str[i].value+",";
	  }
	}
	if(chestr.length==0){
		alert("请选择分项指标！");
		return false;
	}
	window.location.href="staff_getNamePic.action?id="+id+"&ids="+chestr+"&satisfaction=建议";
}
function piping(){
	var chestr="";
	var str=document.getElementsByName("service");
	var objarray=str.length;
	for (i=0;i<objarray;i++)
	{//牛图库JS特效，http://js.niutuku.com/
	  if(str[i].checked == true)
	  {
	   chestr+=str[i].value+",";
	  }
	}
	if(chestr.length==0){
		alert("请选择分项指标！");
		return false;
	}
	window.location.href="staff_getNamePic.action?id="+id+"&ids="+chestr+"&satisfaction=批评";
}
</script>
</head>

<body>
<form action="#" method="get" enctype="">
<!--员工头像显示，评价图标-->
<div id="head" class="head">
	<div class="section1">
			<span>服务人员评价</span>
	</div>
</div>
	<div id="picture" class="picture">
		<div id="people" class="people"><img src="${staff.photo }" style="width:128px;height:128px"/></div><!--员工头像-->
		<div id="praise" class="praise">
			<div style="margin-top:5px;background-image: url(images/u27.png)">
				<img src="images/u39.ico" width="80px" height="80px" onclick="piping()"/>
					<p class="size1">批评</p>
			</div>
		</div>
		<div id="propose" class="propose">
			<div style="margin-top:5px;background-image: url(images/u25.png)">
				<img src="images/u29.ico" width="80px" height="80px"  onclick="jianyi()"/>
					<p class="size2">建议</p>
			</div>
		</div>
		<div id="criticize" class="criticize">
			<div style="margin-top:5px;background-image: url(images/u21.png)">
				<img src="images/u23.ico" width="80px" height="80px" onclick="biaoyang()">
					<p class="size3">表扬</p>
			</div>
		</div>
		<div class="back" id="">
        	<a href="staff_listP.action"><img src="images/fanhui.png" width="50px" height="50px" alt="返回" /></a>
        </div>
	</div>


		<!--人员信息具体显示-->
		<div id="person_information">
			<div id="person_list">
				<table id="person_info" border="1px">
					<tr>
						<td id="person_number" style="font-weight: bold;">工号</td>
						<td id="number_value"><s:property value="staff.staff_no"/></td>
						<td id="person_name"style="font-weight: bold;">姓名</td>
						<td id="name_value"><s:property value="staff.username"/></td>
						<td id=""style="font-weight: bold;">角色</td>
						<td id=""><s:property value="staff.role.name"/></td>
					</tr>
					<tr>
						<td id=""style="font-weight: bold;">岗位</td>
						<td><s:property value="staff.post.name"/></td>
						<td><s:property value=""/></td>
						<td><s:property value=""/></td>
						<td><s:property value=""/></td>
						<td><s:property value=""/></td>
					</tr>
				</table>
			</div>
		</div>
			
		<!--评价员工信息-->
        <div id="select" class="select"> 
        <p style="font-weight:bold;">请选择您的评价：</p>
	         <div id="selected" class="selected">
	         <s:iterator value="listSubindex" var="subindex">
			<div class="service">
				<input type="checkbox" name="service" value="${subindex.id}" onclick="changeColor(this)"/><span></>${subindex.name}</span><br/>
			</div>
			</s:iterator>
	        </div>
        </div>
        
        </form>
</body>
</html>
