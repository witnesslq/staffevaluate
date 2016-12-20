<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--                 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
<base href="<%=basePath%>">
<script type="text/javascript" src="scripts/jquery-3.0.0.js"></script>
<script type="text/javascript">
$(function(){
	$('#username').focus(function(){
		var data = $('#data').val();
		var arr =  data.split("#");
		if(arr.length>1){
			$("#tips").css('display','block'); 
			$('#tips').empty();
			$('#tips').append("<div class='item'>"+arr[0]+"</div>");
			//当光标经过提示项时加亮
			$('.item').mouseenter(function(){
				$(this).addClass('selected').siblings().removeClass('selected');
			});
			//当光标点击某个选项时将该选项的值 复制到username
			$('.item').mousedown(function(){
				$('#username').val($(this).text());
				$('#password').val(arr[1]);
				$('#tips').empty();
				$("#tips").css('display','none'); 
			});
			$('#username').blur(function(){
				$("#tips").css('display','none'); 
				});
			}
	});
});

window.onload=function(){
	var loginError = "${request.loginError}";
	var username = "${request.username}";
	if(loginError != null && loginError.length>1){
    alert(loginError);
    document.getElementById("username").value=username;
	}
}
</script>
</head>
<link rel="stylesheet" href="styles/login.css">

<body>
<div class="main">
		<form action="staff_login.action" method="post">

			<div style="margin-top: 240px;text-align: center;margin-left:700px;padding-bottom:20px;background-color: #ffffff;width:450px;">
			<div style="color:#4BB395;font-size:25px;padding-top:30px;padding-bottom:20px;font-family:'微软雅黑';font-weight: bold">登录</div>
				<table style="border-spacing:10px;margin-left:30px;">
					<tr align="left"  >
						<td><font size="5px" color="gray">用户名：</font></td>
						<td><input id="username"name="username" style="width:240px;height:30px;"/></td>
					</tr>
					<tr>
					<td></td>
					<td></td>
						<td>
							<div id="tips" style=" position:absolute; margin-top:-10px;margin-left: -256px;width:240px;background-color:#ffffff;height:30px;border:1px solid black; display:none" >
								<input type="hidden" id="data"  name="data" value="${request.data }">
							</div>
						</td>
					</tr>
					<tr align="left">
						<td><font size="5px"color="gray">密码：</font></td>
						<td><input id="password" name="password" type="password" style="width:240px;height:30px;" /></td>
						<td><input type="hidden" id="pwd"  /></td>
					</tr>

					<tr align="center">
					<td></td>
					<td><!-- <font  style="font-size: 15px;font-weight: bold">记住密码</font> -->
						<input id="remberBtn" name="rember" style="margin-left: -310px;" type="checkbox" value="1" /><font  style="font-size: 15px;margin-left: -145px;color: gray;">记住密码</font></td>
						
					</tr>
				</table>
   			<input style="background-color:#4BB395;font-family:'微软雅黑';color:white;font-size:25px;width:350px;" type="submit" value="登  录">
			</div>
		
		</form>
		<div style="position: absolute;left:780px;top:842px;font-size:15px;font-family:'微软雅黑';">
    	${session.ipAddress }
    </div>
    </div>
</body>
</html>
