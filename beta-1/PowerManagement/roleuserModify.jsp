<%@ page language="java" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import= "com.dfkj.pm.vo.*" %>
<%@ page import = "java.util.*" %> 
<%@ page import= "com.dfkj.pm.constants.Constants" %>
<%@ page import="com.dfkj.pm.data.datamodel.*" %>


<%
  
   String RoleName = (String)session.getAttribute(Constants.PMRU_ROLENAME);
   String RoleAlias = (String)session.getAttribute(Constants.PMRU_ROLEALIAS);
   DataModel dm = (DataModel)session.getAttribute(Constants.PM_LISTUSER);
   int i=0,j=0;
%>
<html>
<head>
<title>�޸Ľ�ɫ��Ȩ�û�</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
</head>
<SCRIPT src='<%=request.getContextPath()%>/js/DataValidated.js'></SCRIPT>
<SCRIPT language="JavaScript"> 
function check_All(){   
        var objCheckbox = document.ModifyRoleUserForm.all.item("users");
        var j=0;
	if(document.ModifyRoleUserForm.checkall.checked==true){
		for(j=0;j < objCheckbox.length;j++){
			objCheckbox[j].checked=true;
		}
	}        
        objCheckbox[0].checked=false;       
}
function confirmation(){
        if(window.confirm("ȷ���޸�ӵ�иý�ɫ���û���")){
            ModifyRoleUserForm.submit();
        }else return;
}
</SCRIPT>
<body >
<a name="BacktoTop"></a>
<form name="ModifyRoleUserForm" action = "./MainController.do?ActionName=com.dfkj.pm.actions.ModifyRoleUserAction" method="post">
<table width="100%" height="30" border="0" cellpadding="0" cellspacing="0" class="top_table">
  <tr> 
    <td align="right"><a href="#JumptoBottom" target="_self"><img src="<%=request.getContextPath()%>/images/jumptobottom.gif" width="11" height="8" border="0">������ҳβ</a></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr> 
      <td>�޸Ľ�ɫ��Ȩ�û�</td>
    </tr>
    <tr>
      <td><img src="<%=request.getContextPath()%>/images/table_title.jpg" width="206" height="10"></td>
    </tr>
</table>
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr > 
            <td ><div align="center">��ɫ���ƣ�</div></td>
            <td > <div align="left">
                <input type="text" class="input_data" name="rolename" maxlength="20" readOnly="true" <% out.print("value=\""+RoleName+"\"");%>>
              </div></td>
          </tr>
          <tr > 
            <td > <div align="center">��ɫ������</div></td>
            <td > <div align="left">
                <input type="text" class="input_data" name="rolealias" maxlength="40" readOnly="true" <% out.print("value=\""+RoleAlias+"\"");%>>
              </div></td>
          </tr>
		  <tr>
		     <td><input type="checkbox" name="checkall" onClick="check_All();">
              ѡ��ȫ���û�</TD>
                     
            <TD>&nbsp; </TD>
			
                         
		  </tr>
      
        </table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
 </td></tr>
</table>
<br>		
        <input type="checkbox" name="users" style='display:none'><!--λ��Ϊ:1-->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable_1 width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr>
            <td class="table_title">�û�����</td>
            <td class="table_title">�û�����</td>
            <td class="table_title">�û�����</td>
            <td class="table_title">�û�����</td>
			<td class="table_title">�û�����</td>
			<td class="table_title">�û�����</td>
          </tr>
           
		  <tr>
		  <%for(i=0;i<dm.getRowCount();i++){
		  	if(i % 6 ==5){%>
				<td><input type="checkbox" name="users" value="<%=dm.getValueAt(i,"user_name")%>" <%=((String)dm.getValueAt(i,"checked")) == null?"":"checked"%> <%=((((String)dm.getValueAt(i,"user_name")).compareTo(Constants.ADMIN_USERNAME)==0))?"style=\"display:none\" > <input type=\"checkbox\" name=\"users\" value=\""+dm.getValueAt(i,"user_name")+"\" "+ (((String)dm.getValueAt(i,"checked")).compareTo("") == 0?"":"checked")+" disabled=\"true\"":""%> > <%=dm.getValueAt(i,"user_name")%></td>
				</tr>
                               
				<tr>
			<%}else{%>
			    <td><input type="checkbox" name="users" value="<%=dm.getValueAt(i,"user_name")%>" <%=((String)dm.getValueAt(i,"checked")) == null?"":"checked"%> <%=((((String)dm.getValueAt(i,"user_name")).compareTo(Constants.ADMIN_USERNAME)==0))?"style=\"display:none\" > <input type=\"checkbox\" name=\"users\" value=\""+dm.getValueAt(i,"user_name")+"\" "+ (((String)dm.getValueAt(i,"checked")).compareTo("") == 0?"":"checked")+" disabled=\"true\"":""%>  ><%=dm.getValueAt(i,"user_name")%></td>
                             
			<%}
			if(i==dm.getRowCount()-1){
                            for(j=1;j<=5-(i % 6);j++){%>
                               <TD></TD>
                            <%}%>
			    </tr>
			<%}%>
		  <%}%>
                  
        </table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor_1.js"></SCRIPT>
 </td></tr>
</table>
<br>		
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="80%" align="right">		
	  <td width="10%">
		<table width="69" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr> 
            <td align="center"> 
              <input type="button" class="input_button" value='����' onclick='confirmation()'></td>
        </tr>
      </table>
    </td>
	<td width="10%">
	  <table width="69" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td align="center">
        <input type="button" class="input_button" value='����' onclick='history.back();'></td>
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
                  
