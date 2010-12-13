<%@ page language="java" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import= "com.dfkj.pm.vo.*" %>
<%@ page import= "com.dfkj.pm.constants.Constants" %>
<%@page import = "com.dfkj.pm.data.datamodel.*" %>
<%@ page import="com.dfkj.pm.data.DaoUtil" %>

<%
   int i=0,j=0;
   DataModel dm = (DataModel)session.getAttribute(Constants.PM_LISTROLEPOPEDOM);
   PPopedomVO pRoleVO = (PPopedomVO)session.getAttribute(Constants.PM_ROLEDETAIL);
%>
<html>
<head>
<title>�޸Ľ�ɫ</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
</head>
<SCRIPT src='<%=request.getContextPath()%>/js/DataValidated.js'></SCRIPT>
<SCRIPT language="JavaScript"> 
function check_All(){   
        var objCheckbox = document.ModifyRoleForm.all.item("popedoms");
        var j=0;
	if(document.ModifyRoleForm.checkall.checked==true){
		for(j=0;j < objCheckbox.length;j++){
			objCheckbox[j].checked=true;
		}
	}        
        objCheckbox[0].checked=false;       
}
function deleteRole(){
     if (window.confirm("ȷ��Ҫɾ����ǰ��ɫ��")) {
            ModifyRoleForm.action="./MainController.do?ActionName=com.dfkj.pm.actions.DeleteRoleAction&<%=Constants.PMR_ROLENAME%>=<%=pRoleVO.getPopedomName()%>";
            ModifyRoleForm.submit();
     }else return;
}

function  Validation(){  
    var objCheckbox = document.ModifyRoleForm.all.item("popedoms");
	var j=0;
	var count=0;
	for(j=0;j < objCheckbox.length;j++){
		if(objCheckbox[j].checked!=false){
			count++;
			break;
		}
	}
	if(count==0){
		alert("��û��Ϊ�ý�ɫ�����κ�Ȩ��!");
		return;
	}
        trimThis(document.ModifyRoleForm.rolename);
        if(document.ModifyRoleForm.rolename.value==""){
                alert("Ȩ������û����д!");
                return;
        }
        if(window.confirm("ȷ���޸ĵ�ǰ��ɫ��")){
            document.ModifyRoleForm.submit();
        }else return;
}


</SCRIPT>
<body >
<form name="ModifyRoleForm" action = "./MainController.do?ActionName=com.dfkj.pm.actions.ModifyRoleAction" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr> 
      <td>�޸Ľ�ɫ</td>
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
                <input type="text" class="input_data" name="rolename" maxlength="20" readOnly="true" <% out.print("value=\""+pRoleVO.getPopedomName()+"\"");%>>
              </div></td>
          </tr>
          <tr > 
            <td > <div align="center">��ɫ������</div></td>
            <td > <div align="left">
                <input type="text" class="input_data" name="rolealias" maxlength="40" <% out.print("value=\""+DaoUtil.NullToStr((String)pRoleVO.getPopedomAlias())+"\"");%>>
              </div></td>
          </tr>
		  <tr>
		     <td><input type="checkbox" name="checkall" onClick="check_All();">ѡ��ȫ��Ȩ��</TD>
                     <TD>�Ƿ�Ϊϵͳ����Ա��ɫ 
                             <select name='roletype' >
                             <option value='P'>����Ա��ɫ</option>
                             <OPTION value='R'>һ���ɫ</option>
                              </SELECT>
                    </TD>
			
                         
		  </tr>
                  <input name="rolesort" value='<%=pRoleVO.getPopedomSort()%>' style="display:none"><!--Ȩ�������ֶ�-->
                  <input name="roleaction" value='<%=pRoleVO.getPopedomAction()%>' style="display:none"><!--Ȩ�޲����ֶ�-->
        </table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
 </td></tr>
</table>
<br>		
        <input type="checkbox" name="popedoms" style='display:none'><!--λ��Ϊ:1-->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable_1 width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr>
            <td class="table_title">Ȩ������</td>
            <td class="table_title">Ȩ������</td>
            <td class="table_title">Ȩ������</td>
          </tr>
           
		  <tr>
		  <%for(i=0;i<dm.getRowCount();i++){
		  	if(i % 3 ==2){%>
				<td><input type="checkbox" name="popedoms" value="<%=dm.getValueAt(i,"popedom_name")%>" <%=((String)dm.getValueAt(i,"checked")).compareTo("true") == 0?"checked":""%>><%=dm.getValueAt(i,"popedom_name")%></td>
				</tr>
                               
				<tr>
			<%}else{%>
			    <td><input type="checkbox" name="popedoms" value="<%=dm.getValueAt(i,"popedom_name")%>" <%=((String)dm.getValueAt(i,"checked")).compareTo("true") == 0?"checked":""%>><%=dm.getValueAt(i,"popedom_name")%></td>
                             
			<%}
			if(i==dm.getRowCount()-1){
                            for(j=1;j<=2-(i % 3);j++){%>
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
      <td align="right">
          <input type="button" class="input_button" name="Submit" value="����" onClick="Validation()">
          <input type="button" class="input_button" name="Submit2" value="ɾ��" onClick="deleteRole()">
          <input type="button" class="input_button" name="Submit3" value="����" onClick="history.back()">
      </td>
    </tr>
  </table>		
</form>
</body>
</html>
                  <SCRIPT language='javascript'>
                      if('<%=pRoleVO.getPopedomType()%>' =='P'){
                          ModifyRoleForm.roletype.selectedIndex=0;
                      }else{
                          ModifyRoleForm.roletype.selectedIndex=1;
                      }
                      
                  </SCRIPT>
