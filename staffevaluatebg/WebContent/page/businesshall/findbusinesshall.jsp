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
			var unitid = document.getElementById("unitid").value;
			$('#company_blo').val(unitid);
		}
		function turntoPage(){
			var page = document.getElementById("currentPage").value;
			var unitid = document.getElementById("unitid").value;
		//	alert(page+","+unitid);
			location.href = "businessHall_listP.action?currentPage="+page+"&unitid="+unitid;
		}
		function doGo(){
			var unitid =  document.getElementById("company_blo").value;
		//	alert(unitid);
			location.href = "businessHall_listP.action?unitid="+unitid;
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
			location.href = "businessHall_updateInfo.action?id="+chestr;
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
			window.location.href="businessHall_delete.action?ids="+chestr;
		}
			/* var myAjaxObject;
			function getListBean() {
				if(window.ActiveXObject) {
					myAjaxObject = new ActiveXObject("Microsoft.XMLHTTP");
				}else {
					myAjaxObject = new XMLHttpRequest();
				}
				myAjaxObject.open("GET", "unit_getAjax.action",true);
				myAjaxObject.onreadystatechange = returnListBean;
				myAjaxObject.send();
			}
			
			function returnListBean() {
				if(myAjaxObject.readyState == 4) {
					if(myAjaxObject.status == 200) {
						var returnJSONString = myAjaxObject.responseText;
						alert(returnJSONString)
						var returnJSON = JSON.parse(returnJSONString);
						var showString = "";
						for(var i = 0; i < returnJSON.length; i++){
							showname = returnJSON[i].name;
							showid = returnJSON[i].id;
							var shosetype = document.getElementById("company_blo");
							shosetype.options.add(new Option(showname,showid));
						}
						alert (showString);
					}
				}
			}	
			 */
		</script>
		<link rel="stylesheet" type="text/css" href="css/yytcx.css" />
	</head>
	<body>
		<div class="background">
			<!-------------------------------------标题------------------------------------->
			<div class="title">
				<div>营业厅查询</div>
			</div>
			<div class="backsize">
				<!-------------------------------------------下拉选择列表-------------------------------------------->
				<div class="select">
					<div class="left">
					<div class="s1">
						<span style="font-size:12px">所属单位：</span>
					</div>	
					<div class="s2">
						
						<select id="company_blo" name="unitid">
							<option value="0">全部</option>
							<s:iterator>
								<s:iterator value="list" var="unit">
									<option value="${unit.id}">${unit.name}</option>
								</s:iterator>
							</s:iterator>
						</select>
					</div>	
						<input type="hidden" id="unitid" value="${unitid }">
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
								<th class="cols234">营业厅名称</th>
								<th class="cols234">所属单位</th>
								<th class="cols234">营业厅级别</th>
								<th class="cols5">营业厅地址</th>
								<th class="cols6">服务人员数量</th>
							</tr>
							<!-------------------------------------------表体-------------------------------------------->
							</thead>
							<tbody id="tbody-result">  
							<s:iterator value="listAll" var="bh" status="ss">
							<tr>
								<td><input type="checkbox" id="check" value="${bh.id }" name="cbunit"><input type="hidden" value="${bh.id }" id="bhid"/></td>
								<td>${ss.index +1}</td>
								<td>${bh.name}</td>
								<td>${bh.unit.name}</td>
								<td>${bh.level}</td>
								<td>${bh.address}</td>
								<td>${bh.size }</td>
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
						<a href="businessHall_listP.action?currentPage=1&unitid=${unitid }">
							<div class="ic"><img src="images/u01.png" title="点击跳转到首页" /></div>
						</a>
						<s:if test="currentPage>1 ">
							<a href="businessHall_listP.action?currentPage=${currentPage-1}&unitid=${unitid }">
							<div class="ic"><img src="images/u03.png" title="点击跳转到上一页" /></div>
							</a>
						</s:if>
						<s:else>
							<div class="ic"><img src="images/u03.png" title="已到达首页" /></div>
						</s:else>
						<s:if test="pageCount>currentPage">
							<a href="businessHall_listP.action?currentPage=${currentPage+1}&unitid=${unitid }">
								<div class="ic"><img src="images/u04.png" title="点击跳转到下一页" /></div>
							</a>
						</s:if>	
						<s:else>
							<div class="ic"><img src="images/u04.png" title="已到达尾页" /></div>
						</s:else>
						<a href="businessHall_listP.action?currentPage=${pageCount}&unitid=${unitid }">
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
						   <a href="businessHall_addinfo.action" class="link"><img src="images/01.png" class="ico"/></a>
						</div>
						<div class="public edit" title="点击跳转到编辑界面">
							 <a href="JavaScript:void(0)" onclick="updateInfo()" class="link"><img src="images/02.png" class="ico"/></a>
						</div>
						<div class="public delete" title="点击跳转到删除界面">
							 <a href="JavaScript:void(0)" onclick="doDelete()" class="link"><img src="images/03.png" class="ico"/></a>
						</div>
						<div class="public exit" title="点击退出">
							 <a href="page/index.jsp" target="_parent" class="link" ><img src="images/04.png" class="ico"/></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>