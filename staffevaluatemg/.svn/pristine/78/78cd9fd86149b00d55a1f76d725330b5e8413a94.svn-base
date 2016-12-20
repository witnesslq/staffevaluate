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
		<base href="<%=basePath%>">
		<link type="text/css" href="styles/y_css.css" rel="stylesheet" />
		<script type="text/javascript" src="scripts/y_js.js"></script>
		<script type="text/javascript" src="scripts/jquery-3.0.0.js"></script>
		<script type="text/javascript" >
		window.onload=function(){
			var satisfaction = "${satisfaction}";
			if(satisfaction=="表扬"){
		    document.getElementById("satisfactionBg").style.backgroundImage="url(images/u21.png)";
		    document.getElementById("size2").style.color="white";
		    document.getElementById("satisfaction").src="images/u24.ico";
			}else if(satisfaction=="建议"){
			    document.getElementById("satisfactionBg").style.backgroundImage="url(images/u25.png)";
			    document.getElementById("size2").style.color="yellow";
			    document.getElementById("satisfaction").src="images/u29.ico";
			}else if(satisfaction=="批评"){
			    document.getElementById("satisfactionBg").style.backgroundImage="url(images/u27.png)";
			    document.getElementById("size2").style.color="red";
			    document.getElementById("satisfaction").src="images/u39.ico";
			}
			
			var oBtn=document.getElementById("btn");
			var oDiv=document.getElementById("div");
			var aLi = oDiv.getElementsByTagName("li");
			var oTu=document.getElementById("tu1");
			
			oBtn.onfocus=function(){
				oDiv.style.display='block';
			}
			
			var n=0;
			for(var i=0;i<aLi.length;i++){
				aLi[i].onclick=function(){
					var n;
					if(oBtn.value.length<11){
							var n=this.innerHTML;
							oBtn.value+=n;
						}
				}
			}
			
			oTu.onclick=function(){
				oBtn.value='';
				oDiv.style.display='none';
			}

			}
			function doSubmit() {
				var phone = document.getElementById('btn').value; 
				//var sat = "${satisfaction}";
			//	alert(phone.length);
				if(phone.length>0){
					//alert('...');
						if(!(/^1[34578]\d{9}$/.test(phone))){ 
							alert("手机号码有误，请重填"); 
						//	if(sat = '批评')
						return false; 
					}else{
						document.getElementById('myform').submit();
						}
			} else{
				 document.getElementById('myform').submit();
				}
			
			}
		</script>
	</head>
	<body>
	<form id="myform" action="userevaluate_add.action" method="post">
		<div class="lianxi">
		
				<div class="section1">
					<span>服务人员评价</span>
				</div>
			<span class="content">
				<left class="left">
					<span class="left1">
						<tu><img  src="${staff.photo}"style="width:128px;height:128px"/></tu>
						<a>
							<table>
								<tr align="left"style="width:128px;"><td>工号：${staff.staff_no}</td></tr>
								<tr align="left"style="width:128px;"><td>姓名：${staff.username}</td></tr>
							</table>
						</a>
					</span>
					<div id="satisfactionBg"style="background-image: url(images/u25.png);text-align: center;width:128px;
	height:128px;">
						<img id="satisfaction"src="images/u24.ico"width="80px" height="80px"/>
						<p id="size2"class="size2">${satisfaction }</p>
						<br/>
					</div>
					<%-- <i><img id="satisfaction"src="images/u24.ico"style="width:80px;height:80px"/></i>
					<b>${satisfaction }</b> --%>
				</left>
				<right class="right">
				<div class="phone">
					评价结果
				<div class="back" id="">
	        	<a href="staff_getOne.action?id=${staff.id}"><img src="images/fanhui.png" width="50px" height="50px" alt="返回" /></a>
	        	</div>
				</div>
				<div style="margin-top:10px;height:100px;width:380px;overflow-x:hidden;overflow-y:scroll;background-color: #CCCCCC">
					<s:iterator var="subindex" value="listSubindex">
						<div class="service">
							<span>${subindex.name }</span><br/>
						</div>
					</s:iterator>
				</div>
					<phone class="phone">联系电话</phone>
					<input type="hidden" name="userEvaluate.staff.id" value="${staff.id}"/>
					<input type="hidden" name="userEvaluate.evaluate_id" value="1"/>
					<input type="hidden" name="userEvaluate.subindex_ids" value="${ids}"/>
					<input type="hidden" name="userEvaluate.satisfaction" value="${satisfaction}"/>
					<input type="text" name="userEvaluate.evaluateUserPhone" class="input" id="btn" />
					<div class="shuzi" id="div">
						<ul class="ul1">
							<li>1</li>
							<li>2</li>
							<li>3</li>
							<li>4</li>
							<li>5</li>
						</ul>
						<ul class="ul1">
							<li>6</li>
							<li>7</li>
							<li>8</li>
							<li>9</li>
							<li>0</li>
						</ul>
						<br>
					</div>
					<i class="tu1"><img width="65px" height="50px" src="images/qd.jpg" onclick="doSubmit()"/></i>
					<i class="tu2" id="tu1"><img width="65px" height="50px" src="images/qc.jpg"/></i>
				
				</right>
			</span>
		</div>
		</form>
	</body>
</html>
