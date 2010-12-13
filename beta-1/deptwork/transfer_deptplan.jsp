<%@ page contentType="text/html;charset=GBK"%>

<SCRIPT LANGUAGE="JavaScript">
<!--
alert('<%=request.getAttribute("feedback")%>');
window.location.href="<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.actions.deptwork.QueryEoaDeptPlanByConditionAction&pageSize=15&pageNumber=1&NoCache=1&NextPage=/deptwork/eoa_deptplan_main.jsp";

//-->
</SCRIPT>