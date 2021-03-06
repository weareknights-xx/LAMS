<!-- Standard Struts Entries -->

<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/controls.tld" prefix="controls" %>

<html:html locale="true">

<!-- Standard Content -->

<%@ include file="header.jsp" %>

<!-- Body -->

<body bgcolor="white" >

<!-- Tree Component -->
<table width='1000px'>
<tr>
<%
 String action = "treeControlTest.do?sessionName=" + request.getParameter("sessionName") + "&tree=${name}";
 
%>

<td >
  <controls:tree tree="<%=request.getParameter("sessionName")%>"
               action="<%=action%>"
                style="tree-control"
        styleSelected="tree-control-selected"
      styleUnselected="tree-control-unselected"
  />
</td>
</tr>
</table>
</body>

<!-- Standard Footer -->

<%@ include file="footer.jsp" %>

</html:html>
