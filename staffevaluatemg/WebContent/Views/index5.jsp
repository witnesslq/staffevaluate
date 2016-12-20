<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
	<style type="text/css">

body{FONT-SIZE:12pt;font-family: "微软雅黑"}

th{FONT-SIZE:12pt;font-family:"微软雅黑"}

td{FONT-SIZE:9pt;font-family:"微软雅黑"}

</style>
		<meta charset="utf-8" />
		<title></title>
		<link type="text/css" href="styles/huifang.css" rel="stylesheet" />
		<script type="text/javascript">
		window.onload=function(){
			var satisfaction = "${userEvaluate.satisfaction}";
			if(satisfaction=="表扬"){
				 document.getElementById("satisfactionBg").style.backgroundImage="url(images/u21.png)";
				    document.getElementById("size2").style.color="white";
		    document.getElementById("satisfaction").src="images/u24.ico";
			}else if(satisfaction=="建议"){
				 document.getElementById("satisfactionBg").style.backgroundImage="url(images/u25.png)";
				    document.getElementById("size2").style.color="white";
		    document.getElementById("satisfaction").src="images/u29.ico";
			}else if(satisfaction=="批评"){
				 document.getElementById("satisfactionBg").style.backgroundImage="url(images/u27.png)";
				    document.getElementById("size2").style.color="white";
		    document.getElementById("satisfaction").src="images/u39.ico";
			}
			
		}
		
		</script>
	</head>
	<body>
		<div class="lianxi">
			<span class="header"></span>
			<span class="content">
				<left class="left">
					<span class="left1">
						<tu><img  src="${staff.photo}"style="width:128px;height:128px"/></tu>
						<a>
							<table>
								<tr align="left"><td>工号：${staff.staff_no}</td></tr>
								<tr align="left"><td>姓名：${staff.username}</td></tr>
							</table>
						</a>
					</span>
					<div id="satisfactionBg"style="background-image: url(images/u25.png);text-align: center;width:128px;
	height:128px;">
						<img id="satisfaction"src="images/u24.ico"width="80px" height="80px"/>
						<p id="size2"class="size2">${userEvaluate.satisfaction }</p>
						<br/>
					</div>
					<!-- <i><img id="satisfaction"src="images/u24.ico"style="width:80px;height:80px"/></i>
					<b></b> -->
				</left>
				<right class="right">
					<phone class="phone2">回访电话</phone>
					<div class="neirong">
						<c>提示</c>
						<p>&nbsp;&nbsp;&nbsp;${staff.username }服务人员，评价成功。谢谢您的参与！</p>
					</div>
					<i class="tu1"style="width: 100px;height: 50px;margin: 37px 0 0 140px;cursor: pointer;"><a href="staff_login.action" target="_parent"><img src="images/tu3.png"/></a></i>
					
				</right>
			</span>
		</div>
	</body>
</html>
