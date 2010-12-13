<%@page	contentType="text/html;	charset=GBK"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%
	String destination = (String)request.getAttribute("WHERETOGO");
%>

 <html>
 <head>
</head>
 <body>
<script language="JavaScript" type="text/JavaScript">
<!--
  document.location.href ='<%=destination%>';
-->
</script>
</body>
</html>