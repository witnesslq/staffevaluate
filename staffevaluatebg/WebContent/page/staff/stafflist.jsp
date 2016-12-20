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
		<meta charset="utf-8" />
		<title>营业厅查询</title>
		<base href="<%=basePath%>">
		<script type="text/javascript" src="js/json2.js"></script>
		<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
		<script type="text/javascript">
		window.onload = function go(){
			var BusinessHallid = document.getElementById("BusinessHallid").value;
			$('#company_blo').val(BusinessHallid);
		}
		function turntoPage(){
			var page = document.getElementById("currentPage").value;
			var BusinessHallid = document.getElementById("BusinessHallid").value;
		//	alert(page+","+BusinessHallid);
			location.href = "staff_listP.action?currentPage="+page+"&BusinessHallid="+BusinessHallid;
		}
		function doGo(){
			var BusinessHallid =  document.getElementById("company_blo").value;
			var no =  document.getElementById("staffno").value;
			var name =  document.getElementById("staffname").value;
		//	alert(BusinessHallid+no+name);
			location.href = "staff_listP.action?BusinessHallid="+BusinessHallid+"&no="+no+"&name="+name;
		}
		function selectAll() {
			 var obj = document.getElementById('check1');
			 var cks = document.getElementsByTagName("input");
			 var ckslen = cks.length;
			 for(var i=0;i<ckslen-1;i++) {
			  if(cks[i].type == 'checkbox') {
			   cks[i].checked = obj.checked;
			  }
			 }
			}
		function updateInfo(){
			var arr = $('#check:checked').next();
			if(arr.length!=1){
				alert('请选择一项');
				return false;
			}
			//alert(chestr);
			var chestr = $(arr).val();
			location.href = "staff_updateInfo.action?id="+chestr;
		}
		function doDelete(){
			var chestr="";
			var str=document.getElementsByName("cbunit");
			var objarray=str.length;
			for (i=0;i<objarray;i++)
			{//牛图库JS特效，http://js.niutuku.com/
			  if(str[i].checked == true)
			  {
			   chestr+=str[i].value+",";
			  }
			}
			alert('确定删除'+chestr+"?");
			window.location.href="staff_delete.action?ids="+chestr;
		}
			
		</script>
		<link rel="stylesheet" type="text/css" href="css/stafflist.css" />
	</head>
	<body>
		<div class="background">
			<!-------------------------------------标题------------------------------------->
			<div class="title">
				<div>员工查询</div>
			</div>
			<div class="backsize">
			<div class="head1">
				<div class="staffno">
					<span style="font-size:12px">服务人员工号：<input name="no" style="width:100px;" id="staffno"></span>
				</div>
				<div class="staffname">
					<span style="font-size:12px">服务人员姓名：<input name="name" style="width:100px;" id="staffname"></span>
				</div>
				<!-------------------------------------------下拉选择列表-------------------------------------------->
				<div class="select">
						<span style="font-size:12px">所属营业厅：
							<select id="company_blo" name="BusinessHallid">
							<option value="0">全部</option>
							<s:iterator>
								<s:iterator value="businessHallList" var="businessHall">
									<option value="${businessHall.id}">${businessHall.name}</option>
								</s:iterator>
							</s:iterator>
						</select>
						</span>
						<input type="hidden" id="BusinessHallid" value="${BusinessHallid }">
				</div>
					<!-------------------------------------------查询按钮-------------------------------------------->
					<div class="right">
						<div id="btSearch" class="find" title="点击查询">
						   <a href="JavaScript:void(0)" onclick="doGo()" class="link"><img src="images/00.png" class="ico"/></a>
						</div>
					</div>
				</div>
				<!-------------------------------------------表格-------------------------------------------->
				<div class="infomation">
					<div class="information_list">
						<table>
							<!-------------------------------------------表头-------------------------------------------->
							 <thead>  
							<tr>
								<th>全选<input type="checkbox" id="check1" onclick="selectAll()" name="selectall"/></th>
								<th class="cols1">序号</th>
								<th class="cols234">工号</th>
								<th class="cols234">姓名</th>
								<th class="cols234">所属营业厅</th>
								<th class="cols5">岗位</th>
								<th class="cols6">电话</th>
							</tr>
							<!-------------------------------------------表体-------------------------------------------->
							</thead>
							<tbody id="tbody-result">  
							<s:iterator value="#request.listStaff" var="staff" status="ss">
							<tr>
								<td><input type="checkbox" id="check" value="${staff.id }" name="cbunit"><input type="hidden" value="${staff.id }" id="bhid"/></td>
								<td>${ss.index +1}</td>
								<td>${staff.staff_no}</td>
								<td>${staff.name }</td>
								<td>${staff.businessHall.name}</td>
								<td>${staff.post.name}</td>
								<td>${staff.phone}</td>
								
							</tr>
							</s:iterator>
            				</tbody>  
						</table>
					</div>
				</div>
				<!----------------------------------------页数展览区------------------------------------------>
				<div class="page_session">
					<!--------------------------------------当前页数------------------------------------>
					<div class="page_file">
						共<span class="page_number">${pageCount }</span>&nbsp;页<span class="page_number">${businessHallCount }</span>&nbsp;条<span class="now_page">当前第&nbsp;<span class="page_number">${currentPage }</span>/<span class="page_number">${pageCount }</span>&nbsp;页</space>
					</div>
					<!-----------------------------------五个页面跳转按钮----------------------------------------->
					<div class="page_select">
						<a href="staff_listP.action?currentPage=1&BusinessHallid=${BusinessHallid }">
							<div class="ic"><img src="images/u01.png" title="点击跳转到首页" /></div>
						</a>
						<s:if test="currentPage>1 ">
							<a href="staff_listP.action?currentPage=${currentPage-1}&BusinessHallid=${BusinessHallid }">
							<div class="ic"><img src="images/u03.png" title="点击跳转到上一页" /></div>
							</a>
						</s:if>
						<s:else>
							<div class="ic"><img src="images/u03.png" title="已到达首页" /></div>
						</s:else>
						<s:if test="pageCount>currentPage">
							<a href="staff_listP.action?currentPage=${currentPage+1}&BusinessHallid=${BusinessHallid }">
								<div class="ic"><img src="images/u04.png" title="点击跳转到下一页" /></div>
							</a>
						</s:if>	
						<s:else>
							<div class="ic"><img src="images/u04.png" title="已到达尾页" /></div>
						</s:else>
						<a href="staff_listP.action?currentPage=${pageCount}&BusinessHallid=${BusinessHallid }">
							<div class="ic"><img src="images/u02.png" title="点击跳转到尾页" /></div>
						</a>
						<div class="goto_page">
							<div class="goto_box">
								跳转到<input type="text" id="currentPage" size="3" />页
							</div>
							<div class="gotoico">
									<div class="ic"><img src="images/u05.png" onclick="turntoPage()" title="点击跳转" style="cursor:pointer"/></div>
							</div>
						</div>
					</div>
				</div>
				<!----------------------------------------四个跳转按钮-------------------------------------------->
				<div class="footer">
					<div class="function_sesstion">
						<div class="public new_add" title="点击跳转到新增界面">
						   <a href="staff_addinfo.action" class="link"><img src="images/01.png" class="ico"/></a>
						</div>
						<div class="public edit" title="点击跳转到编辑界面">
							 <a href="JavaScript:void(0)" onclick="updateInfo()" class="link"><img src="images/02.png" class="ico"/></a>
						</div>
						<div class="public delete" title="点击跳转到删除界面">
							 <a href="JavaScript:void(0)" onclick="doDelete()" class="link"><img src="images/03.png" class="ico"/></a>
						</div>
						<div class="public exit" title="点击退出">
							 <a href="page/index.jsp" target="_parent"  class="link" ><img src="images/04.png" class="ico"/></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>