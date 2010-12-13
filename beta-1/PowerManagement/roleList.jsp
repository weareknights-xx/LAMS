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
<title>角色列表</title>
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
    <td align="right"><a href="#JumptoBottom" target="_self"><img src="<%=request.getContextPath()%>/images/jumptobottom.gif" width="11" height="8" border="0">　跳至页尾</a></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr> 
      <td>角色列表</td>
    </tr>
    <tr>
      <td><img src="<%=request.getContextPath()%>/images/table_title.jpg" width="206" height="10"></td>
    </tr>
</table>
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr > 
            <td class="table_title">角色名称</td>
            <td class="table_title">角色描述</td>
			<td class="table_title">角色性质</td>
            <td class="table_title">操作</td>
          </tr>
          <%for(int i = 0;i<vecRoles.size();i++){ 
		  		pPopedomVO = (PPopedomVO)vecRoles.get(i);
		  %>
                <tr >
                <td ><%=pPopedomVO.getPopedomName()%></td>
                <td><%=DaoUtil.NullToStr((String)pPopedomVO.getPopedomAlias())%></td>
                <td><% if((pPopedomVO.getPopedomType()).compareTo("P")==0){
                           out.print("管理员角色");
                       }else{
                           out.print("一般角色");
                       }%></td>
                <td><a href='./MainController.do?ActionName=com.dfkj.pm.actions.ModifyRolePrepareAction&NextPage=/PowerManagement/roleModify.jsp&<%=Constants.PMR_ROLENAME%>=<%=pPopedomVO.getPopedomName()%>'>修改</a>|
                <A style="cursor:hand" onclick='deleteRole<%=i%>()' >删除</A>|
                <SCRIPT language='javascript'>
                   function deleteRole<%=i%>(){
                       if (window.confirm("确定要删除角色<%=pPopedomVO.getPopedomName()%>吗？")) {
                           window.location.href="./MainController.do?ActionName=com.dfkj.pm.actions.DeleteRoleAction&<%=Constants.PMR_ROLENAME%>=<%=pPopedomVO.getPopedomName()%>"
                       } else  return;
                   }
                </SCRIPT>
                <A href='./MainController.do?ActionName=com.dfkj.pm.actions.ModifyRoleUserPrepareAction&NextPage=/PowerManagement/roleuserModify.jsp&<%=Constants.PMRU_ROLENAME%>=<%=pPopedomVO.getPopedomName()%>&<%=Constants.PMRU_ROLEALIAS%>=<%=pPopedomVO.getPopedomAlias()%>'>用户</A></td>
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
              <input type="button" class="input_button" value='新增' onclick='addRole()'></td>
        </tr>
      </table>
    </td>    
	<td width="12%">
	  <table width="69" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td align="center">
		  <input type="button" class="input_button" name='commitn' value='返回' onclick='doReturn()'> 
         </td>
        </tr>
      </table>
    </td> 	  
  </tr>
</table> 
<a name="JumptoBottom"></a> 
<table width="100%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td valign="bottom"><a href="#BacktoTop" target="_self"><img src="<%=request.getContextPath()%>/images/backtotop.gif" width="11" height="8" border="0">　回到页首</a></td>
  </tr>
</table>  
</form>
</body>
</html>
