<%@ page contentType="text/html; charset=GBK" %>
<%@page import= "com.dfkj.pm.constants.*" %>
<%@ page import= "com.dfkj.pm.vo.*" %>
<%@page import= "java.util.*" %>
<%@ page import="com.dfkj.pm.data.DaoUtil" %>

<%
    Vector vecRoles = (Vector)request.getSession().getAttribute(Constants.PM_LISTROLE);
	PPopedomVO pPopedomVO = new PPopedomVO();
%>
<html>
<head>
<title>��ɫ�б�</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
<SCRIPT LANGUAGE="JavaScript">
function addRole(){
    UserList.action = "./MainController.do?ActionName=com.dfkj.pm.actions.AddRolePrepareAction&NextPage=/PowerManagement/roleAdd.jsp"
    UserList.submit();
}

  function doReturn(){
    document.location.href="/EOFFICE/MainController.do?ActionName=com.dfkj.eoa.actions.adminwork.QueryDesktopAction&NoCache=1&NextPage=/adminwork/mydesktop.jsp";
  }
</SCRIPT>
</head>

<body>
<a name="BacktoTop"></a>
<form name = "UserList" method="post">
<table width="100%" height="30" border="0" cellpadding="0" cellspacing="0" class="top_table">
  <tr> 
    <td align="right"><a href="#JumptoBottom" target="_self"><img src="<%=request.getContextPath()%>/images/jumptobottom.gif" width="11" height="8" border="0">������ҳβ</a></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr> 
      <td>��ɫ�б�</td>
    </tr>
    <tr>
      <td><img src="<%=request.getContextPath()%>/images/table_title.jpg" width="206" height="10"></td>
    </tr>
</table>
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr > 
            <td class="table_title">��ɫ����</td>
            <td class="table_title">��ɫ����</td>
			<td class="table_title">��ɫ����</td>
            <td class="table_title">����</td>
          </tr>
          <%for(int i = 0;i<vecRoles.size();i++){ 
		  		pPopedomVO = (PPopedomVO)vecRoles.get(i);
		  %>
                <tr >
                <td ><%=pPopedomVO.getPopedomName()%></td>
                <td><%=DaoUtil.NullToStr((String)pPopedomVO.getPopedomAlias())%></td>
                <td><% if((pPopedomVO.getPopedomType()).compareTo("P")==0){
                           out.print("����Ա��ɫ");
                       }else{
                           out.print("һ���ɫ");
                       }%></td>
                <td><a href='./MainController.do?ActionName=com.dfkj.pm.actions.ModifyRolePrepareAction&NextPage=/PowerManagement/roleModify.jsp&<%=Constants.PMR_ROLENAME%>=<%=pPopedomVO.getPopedomName()%>'>�޸�</a>|
                <A style="cursor:hand" onclick='deleteRole<%=i%>()' >ɾ��</A>|
                <SCRIPT language='javascript'>
                   function deleteRole<%=i%>(){
                       if (window.confirm("ȷ��Ҫɾ����ɫ<%=pPopedomVO.getPopedomName()%>��")) {
                           window.location.href="./MainController.do?ActionName=com.dfkj.pm.actions.DeleteRoleAction&<%=Constants.PMR_ROLENAME%>=<%=pPopedomVO.getPopedomName()%>"
                       } else  return;
                   }
                </SCRIPT>
                <A href='./MainController.do?ActionName=com.dfkj.pm.actions.ModifyRoleUserPrepareAction&NextPage=/PowerManagement/roleuserModify.jsp&<%=Constants.PMRU_ROLENAME%>=<%=pPopedomVO.getPopedomName()%>&<%=Constants.PMRU_ROLEALIAS%>=<%=pPopedomVO.getPopedomAlias()%>'>�û�</A></td>
                </tr>
            <%}%>
        </table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
 </td></tr>
</table>
<br>		
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="79%" align="right">		
	  <td width="9%">
		<table width="81" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr> 
            <td width="81" align="center"> 
              <input type="button" class="input_button" value='����' onclick='addRole()'></td>
        </tr>
      </table>
    </td>    
	<td width="12%">
	  <table width="69" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td align="center">
		  <input type="button" class="input_button" name='commitn' value='����' onclick='doReturn()'> 
         </td>
        </tr>
      </table>
    </td> 	  
  </tr>
</table> 
<a name="JumptoBottom"></a> 
<table width="100%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td valign="bottom"><a href="#BacktoTop" target="_self"><img src="<%=request.getContextPath()%>/images/backtotop.gif" width="11" height="8" border="0">���ص�ҳ��</a></td>
  </tr>
</table>  
</form>
</body>
</html>
