<!-- Standard Struts Entries -->

<%@ page language="java" contentType="text/html;charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html locale="true">

<!-- Standard Content -->

<%@ include file="header.jsp" %>

<!-- Body -->
<%
	String flag = request.getParameter("flag");
	if(flag == null)
		flag = "LIST";
%>
  <frameset cols="200,*" framespacing="1"  frameborder="no" border="1" bordercolor="#ff0000"> 
    <frame  name="tree" src='<%= request.getContextPath() + "/" +  response.encodeURL("setUpTree.do?Flag=LIST&sessionName=__deptTree__") %>' scrolling="auto" title="部门列表">
    <frame  name="content" src="<%=request.getContextPath()%>/deptwork/depart_maintenance.jsp" scrolling="auto" title="部门编辑">
  </frameset>

<!-- Standard Footer -->

<%@ include file="footer.jsp" %>

</html:html>
