<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.util.*" %>
<html>
<head>
<title>注销界面</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body bgcolor="#FFFFFF">
注销中，请稍后……
<%   
       session.removeAttribute(com.dfkj.pm.constants.Constants.LOGINFOBEAN);
       session.invalidate();
       //response.sendRedirect("login.jsp");
%>
<script language="JavaScript">
//  parent.location.href="login.jsp";
window.close();
</script>
</body>
</html>

