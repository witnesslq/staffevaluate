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
		$(function() {
			//alert('123');
			var key = $('#keyvalue').val();
			//	alert(key);
			$('#s').val(key);
		});
		function doGo() {
			//var sat = $('#s').text;
			//alert(sat);
			var sat = $("#s").val();
			//alert('sat');
			window.location = "userevaluate_listAll.action?key=" + sat;
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
		function turntoPage(){
			var page = document.getElementById("currentPage").value;
			var key = document.getElementById("keyvalue").value;
		//	alert(page+","+key);
			location.href = "userevaluate_listAll.action?currentPage="+page+"&key="+key;
		}
		function doReturn(){
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
			alert("确定标记为已回访?");
			window.location.href="userevaluate_returnBack.action?ids="+chestr;
		}
		function doValid(){
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
			alert("确定标记为有效记录?");
			window.location.href="userevaluate_returnValid.action?ids="+chestr;
		}
		</script>
		<link rel="stylesheet" type="text/css" href="css/userevaluate.css" />
	</head>
	<body>
		<div class="background">
			<!-------------------------------------标题------------------------------------->
			<div class="title">
				<div>评价记录查询</div>
			</div>
			<div class="backsize">
			<div class="head1">
				<!-------------------------------------------下拉选择列表-------------------------------------------->
				<div class="select">
						<s:select id="s" label="评价结果" list=" #{'0':'全部','1':'批评','2':'建议','3':'表扬' }" headerKey="0" onchange="change()"></s:select>
						<input type="hidden" value="${key }" id="keyvalue" />
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
							
										<th>序号</th>
										<th>服务人员</th>
										<th>被评价日期</th>
										<th>评价结果</th>
										<th>业务短板</th>
										<th>客户电话</th>
										<th>是否回访</th>
										<th>评级是否有效</th>
							</tr>
							<!-------------------------------------------表体-------------------------------------------->
							</thead>
							<tbody id="tbody-result">  
							<s:iterator value="list" status="ss" var="userevaluate">
								<tr>
									<td><input type="checkbox" id="check" value="${userevaluate.id }" name="cbunit"><input type="hidden" value="${userevaluate.id }" id="bhid"/></td>
									<td>${ss.index +1}</td>
									<td><s:property value="staff.name" /></td>
									<td><s:property value="date" /></td>
									<td><s:property value="satisfaction" /></td>
									<td><s:property value="subindex_ids" /></td>
									<td><s:property value="evaluateUserPhone" /></td>
									<td><s:property value="returnStatusOptions[isReturn]" /></td>
									<td><s:property value="returnStatusOptions[isValid]" /></td>
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
						共<span class="page_number">${pageCount }</span>&nbsp;页<span class="page_number">${rowCount }</span>&nbsp;条<span class="now_page">当前第&nbsp;<span class="page_number">${currentPage }</span>/<span class="page_number">${pageCount }</span>&nbsp;页</space>
					</div>
					<!-----------------------------------五个页面跳转按钮----------------------------------------->
					<div class="page_select">
						<a href="userevaluate_listAll.action?currentPage=1&key=${key }">
							<div class="ic"><img src="images/u01.png" title="点击跳转到首页" /></div>
						</a>
						<s:if test="currentPage>1 ">
							<a href="userevaluate_listAll.action?currentPage=${currentPage-1}&key=${key }">
							<div class="ic"><img src="images/u03.png" title="点击跳转到上一页" /></div>
							</a>
						</s:if>
						<s:else>
							<div class="ic"><img src="images/u03.png" title="已到达首页" /></div>
						</s:else>
						<s:if test="pageCount>currentPage">
							<a href="userevaluate_listAll.action?currentPage=${currentPage+1}&key=${key }">
								<div class="ic"><img src="images/u04.png" title="点击跳转到下一页" /></div>
							</a>
						</s:if>	
						<s:else>
							<div class="ic"><img src="images/u04.png" title="已到达尾页" /></div>
						</s:else>
						<a href="userevaluate_listAll.action?currentPage=${pageCount}&key=${key }">
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
						<div class="public edit" title="点击是否有效">
							 <a href="JavaScript:void(0)" onclick="doValid()" class="link"><img src="images/02.png" class="ico"/></a>
						</div>
						<div class="public delete" title="点击回访">
							 <a href="JavaScript:void(0)" onclick="doReturn()" class="link"><img src="images/03.png" class="ico"/></a>
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