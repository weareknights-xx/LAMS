<%@ page contentType="text/html; charset=GBK" %>
<%@page import= "com.dfkj.pm.constants.*" %>
<%@page import= "com.dfkj.pm.data.datamodel.*" %>
<%@ page import="com.dfkj.pm.data.DaoUtil" %>
<html>
<head>
<title>�û��˺��б�</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
<SCRIPT LANGUAGE="JavaScript">
function addUser(){
    UserList.action = "./MainController.do?ActionName=com.dfkj.pm.actions.AddUserPrepareAction&NextPage=/PowerManagement/userAdd.jsp"
    UserList.submit();
}
  function doReturn(){
    document.location.href="/EOFFICE/MainController.do?ActionName=com.dfkj.eoa.actions.adminwork.QueryDesktopAction&NoCache=1&NextPage=/adminwork/mydesktop.jsp";
  }
</SCRIPT>
</head>
<%
    DataModel dm = (DataModel)request.getSession().getAttribute(Constants.PM_LISTUSER);
%>
<body>
<form name = "UserList" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr> 
      <td>�û��б�</td>
    </tr>
    <tr>
      <td><img src="<%=request.getContextPath()%>/images/table_title.jpg" width="206" height="10"></td>
    </tr>
  </table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
    <tr > 
            <td width="15%" class="table_title">�û�����</td>
      <td width="14%" class="table_title">��������</td>
            <td width="8%" class="table_title">��������</td>
      <td width="7%" class="table_title">����</td>
      <td width="16%" class="table_title">�û����� </td>
      <td width="40%" class="table_title">����</td>
    </tr>
    <%for(int i = 0;i<dm.getRowCount();i++){ %>
    <tr > 
      <td ><%=dm.getValueAt(i,"USER_NAME")%></td>
      <td><%=DaoUtil.NullToStr((String)dm.getValueAt(i,"USER_DESCRIPTION"))%></td>
      <td><%=dm.getValueAt(i,"REGION_NAME")%></td>
      <td>
        <% if(((String)dm.getValueAt(i,"USER_ENABLED")).compareTo("Y")==0){
                           out.print("������");
                       }else{
                           out.print("����");
                       }%>
      </td>
      <td>
        <% if(((String)dm.getValueAt(i,"ADMIN")).compareTo("Y")==0){
                           out.print("����Ա");
                       }else{
                           out.print("һ���û�");
                       }%>
      </td>
      <td><a href='./MainController.do?ActionName=com.dfkj.pm.actions.ModifyUserPrepareAction&NextPage=/PowerManagement/userModify.jsp&<%=Constants.PMD_USERNAME%>=<%=dm.getValueAt(i,"USER_NAME")%>'>�޸�</a>
          |<a style="cursor:hand" onclick='deleteUser<%=i%>()'>ɾ��</a>
          <SCRIPT language='javascript'>
              function deleteUser<%=i%>(){
                  if (window.confirm("ȷ��Ҫɾ���û�<%=dm.getValueAt(i,"USER_NAME")%>��")) {
                           window.location.href="./MainController.do?ActionName=com.dfkj.pm.actions.DeleteUserAction&<%=Constants.PMD_USERNAME%>=<%=dm.getValueAt(i,"USER_NAME")%>"
                       } else  return;
              }
          </SCRIPT>
          |<a href='./MainController.do?ActionName=com.dfkj.pm.actions.ModifyUserRolePrepareAction&<%=Constants.PMUR_USERNAME%>=<%=dm.getValueAt(i,"USER_NAME")%>&<%=Constants.PMUR_USERDESCRIPTION%>=<%=dm.getValueAt(i,"USER_DESCRIPTION")%>&NextPage=/PowerManagement/userroleModify.jsp'>Ȩ��</a></td>
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
		<table width="86" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr> 
            <td width="86" align="center">               
			  <input type="button" class="input_button" name='commitn' value='����' onclick='addUser()'> 
			 </td>
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
</form>
</body>
</html>
