<%@ page language="java" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import= "java.util.*" %>
<%@ page import= "com.dfkj.pm.vo.*" %>
<%@ page import= "com.dfkj.pm.db.*" %>
<%@ page import= "com.dfkj.pm.constants.Constants" %>

<html>
<head>
<title>�����û�</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
<SCRIPT src='<%=request.getContextPath()%>/js/DataValidated.js'></script>
<SCRIPT language="JavaScript"> 
function  Validation(){
        trimThis(document.thisForm.userName);
	if(document.thisForm.userName.value==""){
		alert("�û�������Ϊ�գ�");
		return;
	}
        trimThis(document.thisForm.parent_id);
	if(document.thisForm.parent_id.value==""){
		alert("��ѡ���û������Ĳ��ţ�");
		return;
	}
	if(document.thisForm.password.value=="" || document.thisForm.passwordConfirm.value==""){
		alert("����д�û����룡");
		return;
	}else if(document.thisForm.password.value != document.thisForm.passwordConfirm.value){
		alert("��˶��������룡");
		return;
	}
	if(document.thisForm.userEnabled.value == ""){
		alert("��ѡ���û��Ƿ���ã�");
		return;
	}
	if(document.thisForm.admin.value == ""){
		alert("��ѡ���û��Ƿ�Ϊ����Ա");
		return;
	}
        if(window.confirm("ȷ�������û���")){
            document.thisForm.submit();
        }else return;
}
  function getEnterpriseList(){
    window.open('<%= request.getContextPath() + "/" +  response.encodeURL("setUpTree.do?Flag=SELECT_DEP&sessionName=__deptTreeSel__") %>',"","scrollbars = no,status=no,resizable=no,menuber=no,location=no,toolbar=no,directiries=no,width=200,height=400","����ѡ��");     
  }
</SCRIPT>
</head>
<body >
<form name="thisForm" action = "./MainController.do?ActionName=com.dfkj.pm.actions.AddUserAction" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr> 
      <td>�����û�</td>
    </tr>
    <tr>
      <td><img src="<%=request.getContextPath()%>/images/table_title.jpg" width="206" height="10"></td>
    </tr>
  </table>
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr > 
            <td >�û�����*��</td>
            <td > <input type="text" class="input_data" name="userName" maxlength="20"> 
            </td>
          </tr>
          <tr > 
            <td >��������*��</td>
            <td > <input type="text" class="input_data" name="userDescription" maxlength="40"> 
            </td>
          </tr>
          <tr > 
            <td >��������*��</td>
            <td ><input name="parent_name" readonly="true"  type="text" class="input_data" id="parent_name">
          <input type="hidden" name="dept_code" value="" id="dept_code">
          <input type="hidden" name="parent_id" value="" id="parent_id">
			<input name="Submit3" type="button" class="input_button" onClick="getEnterpriseList();" value="ѡ����">
            </td>
          </tr>
          <tr> 
            <td >�û�����*��</td>
            <td > <input type="password" class="input_data" name="password" maxlength="20"> 
            </td>
          </tr>
          <tr > 
            <td >����У��*��</td>
            <td > <input type="password" class="input_data" name="passwordConfirm" maxlength="20"> 
            </td>
          </tr>
          <tr > 
            <td >�Ƿ���ã�</td>
            <td > <select name="userEnabled" class="input_data">
                <option value="Y" >������</option>
                <option value="N" >����</option>
              </select> </td>
          </tr>
          <tr > 
            <td >�û����ʣ�</td>
            <td > <select name="admin" class="input_data">
                <option value="N">һ���û�</option>
                <option value="Y">����Ա</option>
              </select> </td>
          </tr>
        </table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
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
			  <input type="button" class="input_button" name="Submit" value='����' onclick='Validation()'>
			</td>
        </tr>
      </table>
    </td>
	<td width="10%">
	  <table width="69" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td align="center">
		  <input type="button" class="input_button" name="Submit2" value="����" onClick="history.back()">
         </td>
        </tr>
      </table>
    </td>      
  </tr>
</table>
</form>
</body>
</html>
