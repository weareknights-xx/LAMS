<!-- Standard Struts Entries -->

<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="java.util.*"%>
<html:html locale="true">
<head>
<title>员工选择</title>
</head>
<%
	String actionflag = request.getParameter("actionflag");
	if(actionflag == null)
		actionflag = "";
%>
<!-- Standard Content -->

<%@ include file="header.jsp" %>

<!-- Body -->
<%
	String flag = request.getParameter("flag");
	String multi = request.getParameter("Multi");
	System.out.println("multi is "+multi);
	if(flag == null)
		flag = "LIST";
%>
<table width="100%" height="100%" border=0>
  <td  width="30%" align="left">
  <!--
  <frameset cols="200,*" frameborder="YES" border="2">
    <frame name="tree" src='<%= request.getContextPath() + "/" +  response.encodeURL("setUpTree.do?Flag=SELECT_USER&Multi="+multi+"&sessionName=__deptTreeUser__") %>' scrolling="auto" title="部门列表">
    <frame name="content" src="<%=request.getContextPath()%>/deptwork/user_list.jsp" scrolling="auto" title="员工选择">
  </frameset>
  -->
  <IFRAME id ="list" name=b src="<%= request.getContextPath() + "/" +  response.encodeURL("setUpTree.do?Flag=SELECT_USER&Multi="+multi+"&sessionName=__deptTreeUser__") %>" frameBorder=0 width="100%" height="110%"></IFRAME>
  </td>
  <td width="70%">
  <IFRAME border = 0 id ="content" name=content src="<%=request.getContextPath()%>/deptwork/user_list.jsp" frameBorder=0 width="100%" height="100%"></IFRAME>
  </td>
</table>
<!-- Standard Footer -->

<%@ include file="footer.jsp" %>

</html:html>
