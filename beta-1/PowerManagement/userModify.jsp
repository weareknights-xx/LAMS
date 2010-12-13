<%@ page contentType="text/html; charset=GBK" %>
<%@ page import= "java.util.*" %>
<%@ page import= "com.dfkj.pm.vo.PUserVO" %>
<%@ page import= "com.dfkj.pm.constants.*"%>
<%@ page import="com.dfkj.pm.data.DaoUtil" %>
<%
   int i=0;
   PUserVO pUserVO = (PUserVO)request.getSession().getAttribute(Constants.PM_USERDETAIL);
%>

<html>
<head>
<title>编辑用户信息</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
<SCRIPT src='<%=request.getContextPath()%>/js/DataValidated.js'></script>
<script language="JavaScript">
function Validation(){
  trimThis(document.thisForm.userName);
  if(document.thisForm.userName.value==""){
  	  alert("用户名不能为空！");
	  return;
  }
  trimThis(document.thisForm.parent_id);
  if(document.thisForm.parent_id.value==""){
		alert("请选择用户所属的部门！");
		return;
	}
	if(document.thisForm.password.value=="" || document.thisForm.passwordConfirm.value==""){
		alert("请填写用户密码！");
		return;
	}else if(document.thisForm.password.value != document.thisForm.passwordConfirm.value){
		alert("请核对密码输入！");
		return;
	}
	if(document.thisForm.userEnabled.value == ""){
		alert("请选择用户是否禁用！");
		return;
	}
	if(document.thisForm.admin.value== ""){
		alert("请选择用户是否为管理员");
		return;
	}
        if(window.confirm("确定修改当前用户？")){
            document.thisForm.submit();
        }else return;
}

function deleteUser(){
	thisForm.action = "./MainController.do?ActionName=com.dfkj.pm.actions.DeleteUserAction&<%=Constants.PMD_USERNAME%>=<%=pUserVO.getUserName()%>"
	thisForm.submit();
}
</script>

</head>
<body>
<form name='thisForm' action="./MainController.do?ActionName=com.dfkj.pm.actions.ModifyUserAction" method="post" >
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr> 
      <td>编辑用户信息</td>
    </tr>
    <tr>
      <td><img src="<%=request.getContextPath()%>/images/table_title.jpg" width="206" height="10"></td>
    </tr>
  </table>
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="content_table">
 <tr><td>
  <table id=dbcolortable width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr> 
            <td>用户名称：</td>
      <td>  
          <input name="userName" class="input_data" type="text" maxlength="20" <%out.print("value=\"" +pUserVO.getUserName()+"\"");%> readOnly="true">
        </td>
    </tr>
          <tr> 
            <td>中文名称：</td>
      <td>  
          <input name="userDescription" class="input_data" type="text" maxlength="40" <%out.print("value=\"" +DaoUtil.NullToStr((String)pUserVO.getUserDescription())+"\"");%>>
        </td>
    </tr>
          <tr> 
            <td>所属部门：</td>
      <td><input name="parent_name" readonly="true" type="text" class="input_data" id="parent_name"> 
          <input type="hidden" name="dept_code" value="" id="dept_code">
          <input type="hidden" name="parent_id" value="" id="parent_id">
			<input name="Submit3" type="button" class="input_button" onClick="getEnterpriseList();" value="选择部门">
            </td>
    </tr>
          <tr> 
            <td>密码：</td>
      <td>  
          <input name="password" type="password" class="input_data" maxlength="20" <%out.print("value=\""+pUserVO.getPassword()+"\"");%>>
        </td>
    </tr>
          <tr> 
            <td>密码确认：</td>
      <td>  
          <input name="passwordConfirm" type="password" class="input_data" maxlength="20" <%out.print("value=\""+pUserVO.getPassword()+"\"");%>>
        </td>
    </tr>
          <tr > 
            <td >禁用：</td>
      <td >  
          <select name="userEnabled" class="input_data">
            <option value="N">禁用</option>
            <option value="Y">不禁用</option>
          </select>
        </td>
    </tr>
          <tr > 
            <td>管理员：</td>
      <td >  
          <select name="admin" class="input_data">
            <option value="Y">管理员</option>
            <option value="N">一般用户</option>
          </select>
        </td>
    </tr>
  </table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
 </td></tr>
</table>
<br>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
      <td align="right">
          <input type="button" class="input_button" name="Submit" value="保存" onClick="Validation()">
          <input type="button" class="input_button" name="Submit2" value="删除" onClick="deleteUser()">
          <input type="button" class="input_button" name="Submit3" value="返回" onClick="history.back()">
      </td>
    </tr>
  </table>
</form>
<script language="JavaScript">
document.thisForm.parent_name.value="<%=request.getAttribute("departmentName")%>";
document.thisForm.parent_id.value="<%=pUserVO.getDepartmentId()%>";
if('<%=pUserVO.getUserEnabled()%>'=='Y'){
      document.thisForm.userEnabled.selectedIndex=1;
   }else{
      document.thisForm.userEnabled.selectedIndex=0;
}
if('<%=pUserVO.getAdmin()%>'=='Y'){
  	  document.thisForm.admin.selectedIndex=0;
  }else{
  	  document.thisForm.admin.selectedIndex=1;
}
  function getEnterpriseList(){
window.open('<%= request.getContextPath() + "/" +  response.encodeURL("setUpTree.do?Flag=SELECT_DEP&sessionName=__deptTreeSel__") %>',"","scrollbars = no,status=no,resizable=no,menuber=no,location=no,toolbar=no,directiries=no,width=200,height=400","部门选择");      
  }
</script>
</body>
</html>
