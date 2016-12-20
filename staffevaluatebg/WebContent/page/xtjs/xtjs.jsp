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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/gyxx.css" />
<script type="text/javascript">
function Submit(){
	var content = document.getElementById("content").value;
	if(content!==null && content!=="undefined" && content!==""){
		var flag = confirm("确定应用？")
		if(flag==true){
			document.forms[0].submit();
		}else{
			return false;
		}
	}else{
		alert('请输入内容！');
	}
}
</script>
</head>
<body>
	<div class="title"><div class="titlew">系统介绍录入</div></div>
	<div class="back" >
		<form action="uploadxtjs_add.action" method="post">
		<div >
			<div class="tishi" >请输入要显示的系统介绍文本：</div>
			<div class="font">
				<span>请选择前台要显示的字体大小：</span>
				<select name="xtjs.fsize">
					<option value="10">1</option>
					<option value="20">2</option>
					<option value="30" selected>3</option>
					<option value="40">4</option>
					<option value="50">5</option>
					<option value="60">6</option>
					<option value="70">7</option>
				</select>
			</div>
		</div>
		<div class="content">
				<textarea rows="30" cols="120" name="xtjs.xtjstxt" id="content"></textarea>
		</div>
		<div class="s1">
			<div class="baocun"><a href="JavaScript:void(0)" onclick="Submit()"><img src="images/保存.png"></a></div>
			<div class="back1"><a href="page/index.jsp" target="_parent" ><img src="images/back.png"></a></div>		
		</div>
		</form>
	</div>
</body>
</html>