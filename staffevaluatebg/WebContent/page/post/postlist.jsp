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
			function turntoPage(){
				var page = document.getElementById("currentPage").value;
				//alert(page);
				location.href = "post_listAll?currentPage="+page;
			}
			function selectAll(form) {
				 var obj = document.getElementsByName('selectall');
				 var cks = document.getElementsByTagName("input");
				 var ckslen = cks.length;
				 for(var i=0;i<ckslen-1;i++) {
				  if(cks[i].type == 'checkbox') {
				   cks[i].checked = obj[0].checked;
				  }
				 }
				}

			function updateInfo() {
				//var chestr="";
				//var str=document.getElementsByName("cbunit");
				//var objarray=str.length;
				
				//for (i=0;i<objarray;i++)
				//{//牛图库JS特效，http://js.niutuku.com/
				//  if(str[i].checked == true)
				//  {
				  // chestr=str[i].value;
				  // break;
				//  }
				//}
				var arr = $('.che:checked').parent().next().children();
				if(arr.length!=1){
					alert('请选择一项');
					return false;
				}
				//alert(chestr);
				var chestr = $(arr).val();
				location.href = "post_updateInfo.action?id="+chestr;
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
				window.location.href="post_delete.action?ids="+chestr;
			}
		</script>
		<link rel="stylesheet" type="text/css" href="css/yytcx.css" />
	</head>
	<body>
	<form>
		<div class="background">
			<!-------------------------------------标题------------------------------------->
			<div class="title">
				<div>岗位信息列表</div>
			</div>
			<div class="backsize">
				<!-------------------------------------------下拉选择列表-------------------------------------------->
				
				<!-------------------------------------------表格-------------------------------------------->
				<div class="infomation">
					<div class="information_list">
						<table>
							<!-------------------------------------------表头-------------------------------------------->
							 <thead>  
							<tr class="thead_tr">
								<th class="cols_checkbox">全选<input type="checkbox" name="selectall" onclick="selectAll()"/></th>
								<th class="cols_unitno">序号</th>
								<th class="cols_unitname">岗位</th>
							</tr>
							<!-------------------------------------------表体-------------------------------------------->
							</thead>
							<tbody id="tbody-result">  
							<s:iterator value="list" var="p" status="ss">
							<tr class="tbody_tr">
								<td height="20px"><input type="checkbox" value="${p.post_id }"name="cbunit" class="che" /></td>
								<td>${ss.index +1}
								<input type="hidden" value="${p.post_id }" id="ids"name="ids"/>
								</td>
								<td>${p.name}</td>
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
						共<span class="page_number">${pageCount }</span>&nbsp;页<span class="page_number">${totalCount }</span>&nbsp;条<span class="now_page">当前第&nbsp;<span class="page_number">${currentPage }</span>/<span class="page_number">${pageCount }</span>&nbsp;页</space>
					</div>
					<!-----------------------------------五个页面跳转按钮----------------------------------------->
					<div class="page_select">
						<a href="post_listAll.action?currentPage=1">
							<div class="ic"><img src="images/u01.png" title="点击跳转到首页" /></div>
						</a>
						
						
						<s:if test="currentPage>1 ">
							<a href="post_listAll.action?currentPage=${currentPage-1}">
							<div class="ic"><img src="images/u03.png" title="点击跳转到上一页" /></div>
							</a>
							
						</s:if>
						<s:else>
							<div class="ic"><img src="images/u03.png" title="已到达首页" /></div>
						</s:else>
						
						
						<s:if test="pageCount>currentPage">
							<a href="post_listAll.action?currentPage=${currentPage+1}">
								<div class="ic"><img src="images/u04.png" title="点击跳转到下一页" /></div>
							</a>
						</s:if>	
						<s:else>
							<div class="ic"><img src="images/u04.png" title="已到达尾页" /></div>
						</s:else>
						
						<a href="post_listAll?currentPage=${pageCount}">
							<div class="ic"><img src="images/u02.png" title="点击跳转到尾页" /></div>
						</a>
						<div class="goto_page">
							<div class="goto_box">
								跳转到<input type="text" name="" id="currentPage" value="" size="3" />页
							</div>
							<div class="gotoico">
									<div class="ic"><img src="images/u05.png" onclick="turntoPage()" title="点击跳转"  style="cursor:pointer"/></div>
							</div>
						</div>
					</div>
				</div>
				<!----------------------------------------四个跳转按钮-------------------------------------------->
				<div class="footer">
					<div class="function_sesstion">
						<div class="public new_add" title="点击跳转到新增界面">
						   <a href="page/post/addpost.jsp" class="link"><img src="images/01.png" class="ico"/></a>
						</div>
						<div class="public edit" title="点击跳转到编辑界面">
							 <a href="JavaScript:void(0)" onclick="updateInfo()" class="link"><img src="images/02.png" class="ico"/></a>
						</div>
						<div class="public delete" title="点击跳转到删除界面">
							 <a href="JavaScript:void(0)" class="link"><img src="images/03.png" onclick="doDelete()" class="ico"/></a>
						</div>
						<div class="public exit" title="点击退出">
							 <a href="page/index.jsp" target="_parent"  class="link" ><img src="images/04.png" class="ico"/></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		</form>
		
		
	</body>
</html>