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
<title>修改用户密码</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
<SCRIPT src='<%=request.getContextPath()%>/js/DataValidated.js'></script>
<script language="JavaScript">
function goBack()
{
   document.location.href = "./MainController.do?ActionName=com.dfkj.eoa.actions.adminwork.QueryDesktopAction&NoCache=1&NextPage=/adminwork/mydesktop.jsp";
 }
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


</script>

</head>
<body>
<form name='thisForm' action="./MainController.do?ActionName=com.dfkj.pm.actions.ModifyUserPassword" method="post" >
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr> 
      <td>修改用户密码</td>
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
          <input name="userDescription" class="input_data" type="text" maxlength="40" <%out.print("value=\"" +DaoUtil.NullToStr((String)pUserVO.getUserDescription())+"\"");%> readOnly="true">
        </td>
    </tr>
	  <input type="hidden" name="parent_name" readonly="true" type="text" class="input_data" id="parent_name"> 
          <input type="hidden" name="dept_code" value="" id="dept_code">
          <input type="hidden" name="parent_id" value="" id="parent_id">
	  <input type="hidden" name="Submit3" type="button" class="input_button" onClick="getEnterpriseList();" value="选择部门">
        
          <tr> 
            <td>旧密码：</td>
      <td>  
          <input name="pwd" type="password" class="input_data" maxlength="20" >
        </td>
    </tr>
          <tr> 
            <td>新密码：</td>
      <td>  
          <input name="password" type="password" class="input_data" maxlength="20" >
        </td>
    </tr>
          <tr> 
            <td>密码确认：</td>
      <td>  
          <input name="passwordConfirm" type="password" class="input_data" maxlength="20" >
        </td>
    </tr>


<input type="hidden" name="userEnabled"  class="input_data">
<input type="hidden" name="admin"  class="input_data">

  </table>
<SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
 </td></tr>
</table>
<br>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
      <td align="right">
          <input type="button" class="input_button" name="Submit" value="保存" onClick="Validation()">
          <input type="button" class="input_button" name="Submit3" value="返回" onClick="goBack()">
      </td>
    </tr>
  </table>
</form>
<script language="JavaScript">
document.thisForm.parent_name.value="<%=request.getAttribute("departmentName")%>";
document.thisForm.parent_id.value="<%=pUserVO.getDepartmentId()%>";
if('<%=pUserVO.getUserEnabled()%>'=='Y'){
      document.thisForm.userEnabled.value='Y';
   }else{
      document.thisForm.userEnabled.value='N';
}
if('<%=pUserVO.getAdmin()%>'=='Y'){
  	  document.thisForm.admin.value='Y';
  }else{
  	  document.thisForm.admin.value='N';
}
  function getEnterpriseList(){
window.open('<%= request.getContextPath() + "/" +  response.encodeURL("setUpTree.do?Flag=SELECT_DEP&sessionName=__deptTreeSel__") %>',"","scrollbars = no,status=no,resizable=no,menuber=no,location=no,toolbar=no,directiries=no,width=200,height=400","部门选择");      
  }
</script>
</body>
</html>
