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
	String flag = request.getParameter("Flag");	
%>
<script language="JavaScript" type="text/JavaScript">

	opener.document.thisForm.parent_id.value = 'jjj';
</script>

    <frame name="treeSel" src='<%= request.getContextPath() + "/" +  response.encodeURL("setUpTree.do?Flag=SELECT&sessionName=__deptTreeSel__") %>' scrolling="auto" title="部门列表">


<%@ include file="footer.jsp" %>

</html:html>
