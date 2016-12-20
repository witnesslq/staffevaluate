<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.0.0.js"></script>
<script type="text/javascript">
	$(function() {
		//alert('123');
		var key = $('#keyvalue').val();
		//	alert(key);
		$('#s').val(key);
	});
	function change() {
		//var sat = $('#s').text;
		//alert(sat);
		var sat = $("#s").val();
		//alert('sat');
		window.location = "userevaluate_listAll.action?key=" + sat;
	}
</script>
</head>
<body>
	<s:form>
		<div>
			<s:select id="s" label="评价结果" list=" #{'0':'全部','1':'批评','2':'建议','3':'表扬' }" headerKey="0" onchange="change()"></s:select>
			<input type="hidden" value="${key }" id="keyvalue" />
		</div>
		<table style="width: 100%">
			<tr>
				<td>序号</td>
				<td>服务人员</td>
				<td>被评价日期</td>
				<td>评价结果</td>
				<td>业务短板</td>
				<td>客户电话</td>
				<td>是否回访</td>
				<td>评级是否有效</td>
			</tr>
			<s:iterator value="list">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="staff.name" /></td>
					<td><s:property value="date" /></td>
					<td><s:property value="satisfaction" /></td>
					<td><s:property value="subindex_ids" /></td>
					<td><s:property value="evaluateUserPhone" /></td>
					<td><s:property value="returnStatusOptions[isReturn]" /></td>
					<td><s:property value="returnStatusOptions[isValid]" /></td>
				</tr>
			</s:iterator>
		</table>
		<div>
			<div style="float: left;">
				<a href="userevaluate_listAll.action?currentPage=1&key=${key }">首页</a>
			</div>
			<div style="float: left;">
				<span>&nbsp;&nbsp;</span>
			</div>
			<div style="float: left;">
				<c:choose>
					<c:when test="${currentPage>1 }">
						<a
							href="userevaluate_listAll.action?currentPage=${currentPage-1}&key=${key }">上一页</a>
					</c:when>
					<c:otherwise> 上一页</c:otherwise>
				</c:choose>
				<s:iterator begin="1" end="pageCount">
					<s:if test="top==currentPage">
						<a href="#" class="current_page"><s:property /></a>
					</s:if>
					<s:else>
						<a
							href="userevaluate_listAll.action?currentPage=${top }&key=${key }"><s:property /></a>
					</s:else>

				</s:iterator>
				<c:choose>
					<c:when test="${currentPage<pageCount }">
						
						<a href="userevaluate_listAll.action?currentPage=${currentPage+1 }&key=${key }">下一页</a>
					</c:when>
					<c:otherwise> 下一页</c:otherwise>
				</c:choose>
			</div>
			<div style="float: left;">
				<span>&nbsp;&nbsp;</span>
			</div>
			<div style="float: left;">
				<a
					href="userevaluate_listAll.action?currentPage=${pageCount }&key=${key }">尾页</a>
			</div>
			<div style="float: left;">
				<span>&nbsp;&nbsp;</span>
			</div>
			<div style="float: left;">当前第${currentPage }页</div>
		</div>
	</s:form>
</body>
</html>