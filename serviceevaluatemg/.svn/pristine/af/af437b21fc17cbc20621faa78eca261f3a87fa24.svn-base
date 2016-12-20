<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%--                 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
<base href="<%=basePath%>">
<script type="text/javascript" src="scripts/y_js.js"></script>
<script type="text/javascript" src="scripts/jquery-3.0.0.js"></script>
<script type="text/javascript">
	var name="";
	var no;
	var photo;
	var staffid;
	var satisfaction;
	var chestr="";
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
	function xtjj() {
		window.location.href = "Views/home.jsp";
	}
	function home() {
		window.location.href = "Views/main.jsp"
	}
	function getDetail(nop,namep,post,role,photop,staffidp){
		document.getElementById("detail").style.display="block";
		document.getElementById("username").innerText=namep;
		document.getElementById("no").innerText=nop;
		document.getElementById("post").innerText=post;
		document.getElementById("role").innerText=role;
		document.getElementById("photo").src=photop;
		no = nop;
		name = namep;
		photo = photop;
		staffid = staffidp;
	}
	function closes(){
		document.getElementById("detail").style.display="none";	
	}
	function closeshuifang(){
		document.getElementById("huifang").style.display="none";	
	}
	function biaoyang(){
	
		document.getElementById("detail").style.display="none";
		document.getElementById("huifang").style.display="block";
		document.getElementById("huifangPhoto").src=photo;
		document.getElementById("huifangName").innerText=name;
		satisfaction="表扬";
		
		var str=document.getElementsByName("service");
		var objarray=str.length;
		for (i=0;i<objarray;i++)
		{//牛图库JS特效，http://js.niutuku.com/
		  if(str[i].checked == true)
		  {
		   chestr+=str[i].value+",";
		  }
		}
		
	}
	function jianyi(){
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
		document.getElementById("detail").style.display="none";
		document.getElementById("huifang").style.display="block";
		document.getElementById("huifangPhoto").src=photo;
		document.getElementById("hfsatisfaction").src="images/jianyi.png";
		document.getElementById("huifangName").innerText=name;
		satisfaction="建议";
		
		
	}
	function piping(){
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
		document.getElementById("detail").style.display="none";
		document.getElementById("huifang").style.display="block";
		document.getElementById("huifangPhoto").src=photo;
		document.getElementById("hfsatisfaction").src="images/piping.png";
		document.getElementById("huifangName").innerText=name;
		satisfaction="批评";
		
		
	}
	window.onload=function(){
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
	 	document.getElementById("satisfaction").value = satisfaction;
		document.getElementById('staffid').value = staffid;
		document.getElementById('ids').value = chestr;
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title></title>
<!-- <link rel="stylesheet" type="text/css" href="styles/1.css" /> -->
<base href="<%=basePath%>">
<!-- 页面内容不能被选中 -->
<style type="text/css">
.section2 {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
	-khtml-user-select: none;
	user-select: none;
}
</style>
</style>
<style type="text/css">
body {
	FONT-SIZE: 12pt;
	font-family: "微软雅黑"
}

th {
	FONT-SIZE: 12pt;
	font-family: "微软雅黑"
}

td {
	FONT-SIZE: 12pt;
	font-family: "微软雅黑"
}
</style>
</head>
<link rel="stylesheet" href="styles/main.css">
<link rel="stylesheet" href="styles/y_css.css">

<body>
<form>
	<div
		style="position: absolute; background-image: url(images/main_fwpzpj.png); background-size: cover; width: 1360px; height: 900px; top: 10;">
		<div style="position: absolute; left: 80px; top: 135px; float: left">
			</div>
		<img alt="" src="images/zhuye.jpg"
			style="position: absolute; left: 1230px; top: 135px" onclick="home()">
		<div class="stafflist">
			<s:iterator value="#request.listStaff" var="staff">
				<div class="staffbg" onclick="getDetail('${staff.staff_no}','${staff.username}','${staff.post.name}','${staff.role.name}','${staff.photo}','${staff.id}')">
					<img alt="" style="margin-top: 10px;"width="80px" height="80px;"src="<s:property value="#staff.photo"/>">
					<div>
					${staff.username}
					</div>
					<div>
					工号：${staff.staff_no}
					</div>
					<div style="margin-left:8px;padding-top:3px;margin-top:10px;background-image: url('images/bg_post.jpg');width:180px;height:30px;background-size: cover;">
						${staff.post.name}
					</div>
				</div>
			</s:iterator>
		</div>
		<div style="margin-left:500px;margin-top:30px;width:90%;height:80px;">
		<div class="fenye">
			<s:if test="#request.currentPage>1">
				<a href="staff_listP.action?pageNo=${request.currentPage-1}"><img alt="" src="images/lastpage.png"></a>
			</s:if>
			<s:else>
				<img alt="" src="images/lastpage.png">
			</s:else>
		</div>
		<div class="fenye">
			<s:if test="#request.pageCount>#request.currentPage">
				<a href="staff_listP.action?pageNo=${request.currentPage+1}"><img alt="" src="images/nextpage.png"></a>
			</s:if>	
			<s:else>
				<img alt="" src="images/nextpage.png">
			</s:else>
		</div>
		<div class="total">共 <font style="color:blue;size: 12px;font-family: '微软雅黑'">${request.pageCount}</font>页,当前第 <font style="color:red;size: 12px;font-family: '微软雅黑'">${request.currentPage}</font>页 </div>
	</div>
	</div>
	
	<div id="detail" style="position:absolute;text-align:center; top:200px;left:300px;display:none; width:700px;height:500px;background-color: #ffffff">
		<img alt="" onclick="closes()" src="images/close.png" style="position:absolute;top:20px;;left:650px" >
		<div style="width:100%">
		<img alt="" id="photo"src=""style="margin-top: 50px;"width="90px" height="90px;">
		</div>
		<div style="margin-top:10px;width:100%;heigth:80px;">
			<span id="username"></span>
		</div>
		<div style="margin-top:20px;width:100%;height:45px;">
			<div style="margin-left:150px;float:left">
				<img alt=""style="float:left" src="images/gonghao.png">工号：<span id="no"></span>
			</div>
		
			<div style="float:left">
			<img alt="" src="images/juese.png" style="float:left">角色：<span id="role"></span>
			</div>
		
			<div style="float:left">
			<img alt=""style="float:left" src="images/gangwei.png">岗位：<span id="post"></span>
			</div>
		</div>
		
		 <div id="select" style="margin-top:5px;width:100%" > 
        <div style="font-weight:bold;font-family: '微软雅黑';text-align: center;">请选择您的评价：</div>
	         <div id="selected" class="selected">
	         <s:iterator value="listSubindex" var="subindex">
			<div class="service">
				<input type="checkbox" name="service" value="${subindex.id}" onclick="changeColor(this)"/><span></>${subindex.name}</span><br/>
			</div>
			</s:iterator>
	        </div>
        </div>
		
		<div style="margin-top:100px;;width:100%;">
		<div style="margin-left:150px;float:left">
			<img alt="" src="images/biaoyang.png" onclick="biaoyang()">
			</div>
			<div style="margin-left:20px;float:left">
			<img alt="" style="margin-left:20px;"src="images/piping.png"onclick="piping()" >
			</div>
			<div style="margin-left:20px;float:left">
			<img alt="" style="margin-left:20px;"src="images/jianyi.png"onclick="jianyi()">
			</div>
		</div>
	</div>
	</form>
	<form id="myform"action="userevaluate_add.action" method="post">
	<div id="huifang"style="position:absolute;text-align:center; top:200px;left:300px;display:none; width:700px;height:500px;background-color: #ffffff">
		<img alt="" id="hfsatisfaction" src="images/biaoyang.png" style="top:-20px;left:450px" >
		<img alt="" onclick="closeshuifang()" src="images/close.png" style="position:absolute;top:20px;;left:650px" >
	<div style="width:100%">
		<img alt="" id="huifangPhoto"style="margin-top: 10px;"width="80px" height="80px;">
		</div>
		<input type="hidden" id="staffid"name="userEvaluate.staff.id" value=""/>
					<input id="evaluateid" type="hidden" name="userEvaluate.evaluate_id" value="1"/>
					<input id="satisfaction"type="hidden" name="userEvaluate.satisfaction" value=""/>
					<input id="ids"type="hidden" name="userEvaluate.subindex_ids" value=""/>
		<div style="margin-top:10px;width:100%">
			<span id="huifangName"></span>
		</div>
		<div>
					<div>
					<div  style="float:left;margin-left:100px;"class="phone">回访电话：</div>
					<div style="float:left;"><input type="text" name="userEvaluate.evaluateUserPhone" class="input" id="btn" />
					</div>
					</div>
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
					<i class="tu1"><img width="100px"  src="images/002.png" onclick="doSubmit()"/></i>
					<i class="tu2" id="tu1"><img width="100px"  src="images/003.png"/></i>
		</div>
	</div>
	</form>
	<div  style="position: absolute;left:780px;top:857px;color:white;font-family: '微软雅黑';font-size:15px;">
    	${session.ipAddress }
    </div>
</body>

</html>
