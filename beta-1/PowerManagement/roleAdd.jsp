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
<title>增加角色</title>
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
		alert("您没有为该角色赋予任何权限!");
		return;
	}
        trimThis(document.AddRoleForm.rolename);
        if(document.AddRoleForm.rolename.value==""){
                alert("角色名称没有填写!");
                return;
        }
        if(window.confirm("确定增加角色？")){
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
      <td>新增角色</td>
    </tr>
    <tr>
      <td><img src="<%=request.getContextPath()%>/images/table_title.jpg" width="206" height="10"></td>
    </tr>
</table>
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr > 
            <td ><div align="center">角色名称：</div></td>
            <td > <div align="left">
                <input type="text" class="input_data" name="rolename" maxlength="20">
              </div></td>
          </tr>
          <tr > 
            <td > <div align="center">角色描述：</div></td>
            <td > <div align="left">
                <input type="text" class="input_data" name="rolealias" maxlength="40">
              </div></td>
          </tr>
          <tr > 
            <td > <div align="center">角色性质：</div></td>
            <td > <div align="left">
                <select name='roletype'>
                <OPTION value='P'>系统管理员</OPTION>
                <OPTION value='R'>一般角色</OPTION> 
                </SELECT>
              </div></td>
          </tr>
		  <tr>
		     <td><input type="checkbox" name="checkall" onClick="checkAll()">选择全部权限</td>
			 <td></td>
		  </tr>
        </table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
 </td></tr>
</table>
<br>		
        <input type="checkbox" name="popedoms" style='display:none' value='-1'><!--位置为:1-->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable_1 width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr>
            <td class="table_title">权限名称</td>
            <td class="table_title">权限名称</td>
            <td class="table_title">权限名称</td>
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
 </td></tr><input name="rolesort" value='' style="display:none"><!--权限排序字段-->
           <input name="roleaction" value='' style="display:none"><!--权限操作字段-->
</table>
<br>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="80%" align="right">		
	  <td width="10%">
		<table width="69" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr> 
            <td align="center"> 
              <input type="button" class="input_button" value='保存' onclick='Validation()'></td>
        </tr>
      </table>
    </td>
	<td width="10%">
	  <table width="69" height="31" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td align="center">
        <input type="button" class="input_button" value='返回' onclick='history.back();'></td>
        </tr>
      </table>
    </td>      
  </tr>
</table>		
</form>
</body>
</html>
