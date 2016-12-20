<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
 <HEAD>
  <TITLE> New Document </TITLE>
 </HEAD>
  <frameset rows="10%,*" framespacing="1" >
    <frame name="top" src="top.jsp"  frameborder="1" scrolling=no  >
	
	<frameset rows="80%,*" framespacing="1" >
		<frameset cols="15%,85%">
		   <frame name="left"  src="left.jsp"   scrolling=no  >
		   <frame id="right" name="right" src="right.jsp" style="height:450px" scrolling=yes  >
		</frameset>
		<frame name="bottom" src="bottom.jsp"   frameborder="1" scrolling=no  >
	</frameset>
  </frameset>
</HTML>