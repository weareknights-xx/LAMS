<%@ page contentType="text/html;charset=GBK" language="java" import="java.sql.*" errorPage="" %>
<%@page import = "java.util.*"%>
<%@ page import="com.dfkj.eoa.vo.*" %>
<%@ page import="com.dfkj.utilities.*"%>
<%@page import = "com.dfkj.data.DaoUtil"%>

<%
Iterator iter = null;
java.util.Collection collection = null;
EoaDeptVO value = null;
collection = (java.util.Collection)request.getAttribute("deptCollection");
iter = collection.iterator();

%>

<html>
<head>
<title>选择部门</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
</head>
<script language="JavaScript" type="text/JavaScript">
<!--
function setIsAll()
{
    if(formList.isAllSelected.checked==true)
    {
		for(i=1;i<formList.elements.length;i++)
			{
				formList.elements(i).checked=true;
			}
	}
	else
	{
		for(i=1;i<formList.elements.length;i++)
			{
				formList.elements(i).checked=false;
			}
	}
}

function doConfirm() {
	var deptments = "";
	var obj = document.getElementsByName("deptIds");
	var deptname = document.getElementsByName("deptName");
	
	for(var i=0; i<obj.length;i++){
		if(obj[i].checked){  
			deptments += deptname[i].value;
			deptments += ",";
		}
	}
    opener.document.FormList.sendRange.value= deptments;

	formList.action="<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.actions.deptwork.SelectDepartments";
	formList.submit();
    window.close();
}
function cancel() {
    opener.document.FormList.sendRange.value= "";
    window.close();
}
-->
</script>

<body>
<form name="formList" method="post" action="">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
	<table id=dbcolortable width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
	  <tr>
		    <td class="table_title">全选<input type="checkbox"  name="isAllSelected" onclick="setIsAll()"></td>
		<td class="table_title">部门</td>
	  </tr>
	  <% try{
		while(iter.hasNext()){
			value = (EoaDeptVO)iter.next();
	  %>
			  <tr> 
				<td><input type="checkbox" name="deptIds"  value="<%=value.getDeptId()%>"></td>
				<td><%=value.getDeptName()%>
					<input type="hidden" name="deptName" value="<%=value.getDeptName()%>">
				</td>
			  </tr>
	   <%
		 }
		 }catch(Exception e) {
			e.printStackTrace();
		}
		%>
	</table>
 </td></tr>
</table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td align="right">
        <input type="button" class="input_button" name="Button3" value="确定" style="cursor:hand" onClick="doConfirm()"> 
        <input type="button" class="input_button" name="Button2" value="取消" style="cursor:hand" onClick="cancel()">
      </td>
    </tr>
</table>

</form>
</body>
</html>
