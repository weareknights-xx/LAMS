<%@ page contentType="text/html;charset=GBK" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="com.dfkj.eoa.vo.*" %>
<%@ page import="java.util.*" %> 
<%@ page import="com.dfkj.utilities.*"%>
<%@ page import = "com.dfkj.data.DaoUtil"%>
<%@ page import = "com.dfkj.pm.web.*"%>
<%
LoginInfo loginInfo =(LoginInfo)request.getSession().getAttribute(com.dfkj.constants.Constants.LOGINFOBEAN);
String userName = loginInfo.getUserName();
String pwdURL = "../MainController.do?ActionName=com.dfkj.pm.actions.ModifyUserPrepareAction&NextPage=/PowerManagement/userChangePassword.jsp&userName="+userName;
%>


<html>
<head>
<title>修改密码</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<meta http-equiv="refresh" content="1;url=<%=pwdURL%>">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
</head>
<BODY>
请稍等……
</BODY>
</html>