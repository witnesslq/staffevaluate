<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>¼�������Ա</title>
</head>
<body>
	<h2>����Ա����Ϣ</h2><br/>
	<form action="">
		<table>
		<tr>
			<td>���</td>
			<td>Ա�����</td>
			<td>�û���</td>
			<td>Ա������</td>
			<td>��ϵ�绰</td>
			<td>ͷ��</td>
		</tr>
		<s:iterator value="#request.listStaff" var="staff">
			<tr>
				<td><s:property value="#staff.username"/></td>
				<td><s:property value="#staff.username"/></td>
				<td><s:property value="#staff.username"/></td>
				<td><s:property value="#staff.username"/></td>
				<td><s:property value="#staff.username"/></td>
				<td><s:property value="#staff.username"/></td>
			</tr>
		</s:iterator>
	</table>
	</form>
</body>
</html>