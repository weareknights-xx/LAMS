<%@ page language="java" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import= "java.util.*" %>
<%@ page import= "com.dfkj.pm.vo.*" %>
<%@ page import= "com.dfkj.pm.constants.Constants" %>


<%
   int i=0,j=0;
   Vector vecPopedoms = (Vector)request.getSession().getAttribute(Constants.PM_LISTPOPEDOM);
   PPopedomVO pPopedomVO = new PPopedomVO();
%>
<html>
<head>
<title>���ӽ�ɫ</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
<SCRIPT src='<%=request.getContextPath()%>/js/DataValidated.js'></SCRIPT>
<SCRIPT language="JavaScript"> 
function  Validation(){
    var objCheckbox = document.AddRoleForm.all.item("popedoms");
	var j=0;
	var count=0;
	for(j=0;j<objCheckbox.length;j++){
		if(objCheckbox[j].checked!=false){
			count++;
			break;
		}
	}
	if(count==0){
		alert("��û��Ϊ�ý�ɫ�����κ�Ȩ��!");
		return;
	}
        trimThis(document.AddRoleForm.rolename);
        if(document.AddRoleForm.rolename.value==""){
                alert("��ɫ����û����д!");
                return;
        }
        if(window.confirm("ȷ�����ӽ�ɫ��")){
            document.AddRoleForm.submit();
        }else return;
}
function checkAll(){
	if(document.AddRoleForm.checkall.checked==true){
		var objCheckbox = document.AddRoleForm.all.item("popedoms");
	    var j=0;
		for(j=0;j<objCheckbox.length;j++){
                        if(j!=0){
                            objCheckbox[j].checked=true;
                        }
		}
	}
}
</SCRIPT>
</head>
<body >
<form name="AddRoleForm" action = "./MainController.do?ActionName=com.dfkj.pm.actions.AddRoleAction" method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr> 
      <td>������ɫ</td>
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
                <input type="text" class="input_data" name="rolename" maxlength="20">
              </div></td>
          </tr>
          <tr > 
            <td > <div align="center">��ɫ������</div></td>
            <td > <div align="left">
                <input type="text" class="input_data" name="rolealias" maxlength="40">
              </div></td>
          </tr>
          <tr > 
            <td > <div align="center">��ɫ���ʣ�</div></td>
            <td > <div align="left">
                <select name='roletype'>
                <OPTION value='P'>ϵͳ����Ա</OPTION>
                <OPTION value='R'>һ���ɫ</OPTION> 
                </SELECT>
              </div></td>
          </tr>
		  <tr>
		     <td><input type="checkbox" name="checkall" onClick="checkAll()">ѡ��ȫ��Ȩ��</td>
			 <td></td>
		  </tr>
        </table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
 </td></tr>
</table>
<br>		
        <input type="checkbox" name="popedoms" style='display:none' value='-1'><!--λ��Ϊ:1-->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable_1 width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr>
            <td class="table_title">Ȩ������</td>
            <td class="table_title">Ȩ������</td>
            <td class="table_title">Ȩ������</td>
          </tr>
		  <tr>
		  <%for(i=0;i<vecPopedoms.size();i++){
		  		pPopedomVO = (PPopedomVO)vecPopedoms.get(i);
		  	if(i % 3 ==2){%>
				<td><input type="checkbox" name="popedoms" value="<%=pPopedomVO.getPopedomName()%>" ><%=pPopedomVO.getPopedomName()%></td>
				</tr>
				<tr>
			<%}else{%>
			    <td><input type="checkbox" name="popedoms" value="<%=pPopedomVO.getPopedomName()%>" ><%=pPopedomVO.getPopedomName()%></td>
			<%}
			if(i==vecPopedoms.size()-1){
                            for(j=1;j<=2-(i % 3);j++){%>
                               <TD></TD>
                            <%}%>
			    </tr>
			<%}%>
		  <%}%>
        </table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor_1.js"></SCRIPT>
 </td></tr><input name="rolesort" value='' style="display:none"><!--Ȩ�������ֶ�-->
           <input name="roleaction" value='' style="display:none"><!--Ȩ�޲����ֶ�-->
</table>
<br>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="80%" align="right">		
	  <td width="10%">
		<table width="69" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr> 
            <td align="center"> 
              <input type="button" class="input_button" value='����' onclick='Validation()'></td>
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
</form>
</body>
</html>
