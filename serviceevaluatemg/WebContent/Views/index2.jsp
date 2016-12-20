<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript">
	function changebgColor(id){
		
	}
	
</script>
<style type="text/css">

body{FONT-SIZE:12pt;font-family: "微软雅黑"}

th{FONT-SIZE:12pt;font-family: "微软雅黑"}

td{FONT-SIZE:12pt;font-family: "微软雅黑"}
p{FONT-SIZE:12pt;font-family: "微软雅黑"}

</style>
</head>
<link rel="stylesheet" href="styles/mycss.css">
<body >
	<div class="main">
		<div style="margin-top:125px">
			<div class="left" style="width:280px;padding-left:10px;height:540px;float:left">
				<div class="accordion-toggle">
					<a class="caidanA" href="uploadxtjs_show.action" target="ifraRight">
						<span class="left-title">系统介绍</span>
					</a>
                </div>
				<div class="accordion-toggle" onclick="changebgColor(id)">
					<a class="caidanA" href="staff_listP.action" target="ifraRight">
						<span class="left-title" ><font size="3px">服务人员评价</font></span>
					</a>
                </div>
				<div class="accordion-toggle">
					<a class="caidanA" href="uploadzcfg_show.action" target="ifraRight">
						<span class="left-title" ><font size="3px">政策法规</font></span>
					</a>
                </div>
				<div class="accordion-toggle">
					<a class="caidanA"  href="Views/czzn.html" target="ifraRight">
						<span class="left-title" ><font size="3px">操作指南</font></span>
					</a>
                </div>
				
			</div>
			<div class="right"style="width:auto;height:540px;">
				<iframe style="width:650px;height:500px" name="ifraRight" id="ifraRight"  src="uploadxtjs_show.action" frameborder="0" onload ="javascript:getWidth()" scrolling="no"></iframe>

			</div>
			
		</div>
		<div style="position: absolute;right: 20px;top:660px;color: #949A9A;font-weight: bold;">
			${session.ipAddress }
		</div>
	</div>
    
</body>
</html>