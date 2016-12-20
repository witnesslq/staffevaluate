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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/staffUpdateInfo.css" />
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
<script type="text/javascript">
	function Submit(){
		var pswd1 = $('#password1').val();
		var pswd2 = $('#password2').val();
		
		if(pswd2!=null&&pswd2.length>0&&pswd2.length<7){
		//	alert(pswd1);
			if(pswd1==pswd2){
				document.forms[0].submit();
			}else{
				alert('密码不一致！');
				return false;
			}
		}else{
			alert('密码格式有误！');
			return false;
		}
	}
	function Cancel(){
		location.href = "staff_listP.action";
	}
</script>
</head>
<body>
<div class="title">
		<div style="margin-top:5px;">员工信息维护</div>
	</div>
<div class="backsize">
<div class="left">
	<table>
		<tr>
			<td colspan="2" align="center">原始信息</td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><input type="text" value="${staff.name }" disabled/></td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" value="${staff.username }" disabled/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" value="${staff.password }" disabled/></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td><s:property value="sexMap[staff.sex]" /></td>
		</tr>
		<tr>
			<td>联系电话：</td>
			<td><input type="text" value="${staff.phone }" disabled></td>
		</tr>
		<tr>
			<td>角色：</td>
			<td><input type="text" value="${staff.role.name }" disabled></td>
		</tr>
		<tr>
			<td>岗位：</td>
			<td><input type="text" value="${staff.post.name }" disabled></td>
		</tr>
		<tr>
			<td>营业厅：</td>
			<td><input type="text" value="${staff.businessHall.name }" disabled></td>
		</tr>
		<tr>
			<td>照片：</td>
			<td><img alt="" src="${staff.photo }" width="128px" height="128px;" ></td>
		</tr>
	</table>
</div>
<div class="right">
	<s:form action="staff_update.action" method="post" enctype="multipart/form-data">
	<input type="hidden" value="${staff.id }" name="staff.id">
	<input type="hidden" value="${staff.staff_no }" name="staff.staff_no">
	<table >
		<tr>
			<td colspan="2" align="center">更改信息(*为必填项)</td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><input type="text" name="staff.name" value="${staff.name }"/></td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="staff.username" value="${staff.username }"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="staff.password" id="password1" value="${staff.name }"/></td>
			
		</tr>
		<tr>
			<td>确认密码</td>
			<td><input type="password" id="password2"></td>
		</tr>
		<tr>
			<td>*性别：</td>
			<td><select name="staff.sex" required="required">
				<option value="1" >男</option>
				<option value="2">女</option>
			</select></td>
		</tr>
		<tr>
			<td>联系电话：</td>
			<td><input type="text" name="staff.phone" value="${staff.phone }"></td>
		</tr>
		<tr>
			<td>*角色：</td>
			<td><select name="staff.role.role_id" required="required">
					<s:iterator value="roleList" var="role">
						<option value="${role.role_id}">${role.name}</option>
					</s:iterator>
				</select></td>
		</tr>
		<tr>
			<td>*岗位：</td>
			<td><select name="staff.post.post_id" required="required">
					<s:iterator value="postList" var="post">
						<option value="${post.post_id}">${post.name}</option>
					</s:iterator>
				</select></td>
		</tr>
		<tr>
			<td>*营业厅：</td>
			<td><select name="staff.businessHall.id" required="required">
					<s:iterator value="businessHallList" var="businessHall">
						<option value="${businessHall.id}">${businessHall.name}</option>
					</s:iterator>
				</select></td>
		</tr>
		<tr>
			<td>*图片：</td>
			<td><input type="file" name="upload" ></td>
		</tr>
	</table>
	</s:form>
	<div class="zhuyi">
		<span style="font-size:10px; color:red;">(注意：密码不可超过6位)</span>
	</div>
	<div class="function">
		<input type="image" src="images/保存.png" onclick="Submit();" >
		<input type="image" src="images/退出.png" onclick="Cancel();" >
	</div>
</div>	
</div>
</body>
</html>