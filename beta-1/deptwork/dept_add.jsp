<%@page contentType="text/html;charset=GBK"%>
<html>
<head>
<title>增加部门</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" 
      href="<%=request.getContextPath()%>/css/programstyle.css">
<script language="JavaScript" type="text/JavaScript">
<%
	String retFlag = (String)request.getAttribute("FLAG");
	if(retFlag != null){
		//out.println("<script language='javascript'>");
		if(retFlag.equals("true"))
			out.println("alert('新部门添加成功！')");
		else
			out.println("alert('新部门添加失败！')");
		out.println("history.back();");
	}
%>
<!--

function do_add(){

      if(confirm("您确定要增加部门吗？")){ 
		  if (checkValue()){
			  //thisForm.action="";
			  document.thisForm.submit();
		  }
     }
}
function selDept(){
	//window.open("deptTreeSel.jsp?Flag=SELECT","","scrollbars = yes,status=yes,resizable=yes,menuber=no,location=no,toolbar=no,directiries=no,width=200,height=400","部门选择");
    window.open('<%= request.getContextPath() + "/" +  response.encodeURL("setUpTree.do?Flag=SELECT_DEP&sessionName=__deptTreeSel__") %>',"","scrollbars = no,status=no,resizable=no,menuber=no,location=no,toolbar=no,directiries=no,width=200,height=400","部门选择");
}
function checkValue(){
    if(isEmpty(document.thisForm.dept_name.value)){
    	alert("部门名称不能为空！");
    	return false;
	}
    if(document.thisForm.dept_name.value.length > 50){
    	alert("部门名称不能超过50个字符！");
    	return false;
	}
	if(isEmpty(document.thisForm.parent_name.value)){
    	alert("请选择上级部门！");
    	return false;
	}
	if(document.thisForm.queue.value.length > 4){
    	alert("排序不能超过4个字符！");
    	return false;
	}
	if(document.thisForm.description.value.length > 50){
    	alert("部门描述不能超过50个字符！");
    	return false;
	}
    return true;
}
function number_check()
{
  if(event.keyCode == 46)
  	return;
  if(event.keyCode == 13)
  	return;
  if( event.keyCode>59 || event.keyCode<48 )
  {
    alert("请输入数字类型！");
    event.keyCode = 0;
  }
  return;
}
function isEmpty(str)
  {
        if (!str) {
            return true;
        }
        str = str.replace(/^\s+/, "");
        str = str.replace(/\s+$/, "");
        return (str.length == 0);
  }
-->
</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="title_table">
  <tr>
    <td>部门增加</td>
  </tr>
  <tr>
    <td><img src="<%=request.getContextPath()%>/images/table_title.jpg" width="206" height="10"></td>
  </tr>
</table>
<form name="thisForm" method="post" action="<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.actions.deptwork.AddEoaDeptAction&NoCache=1&NextPage=/deptwork/dept_add.jsp">
  <table width="100%" border="0" align="center" cellspacing="0" cellpadding="0" class="content_table">
    <tr><td>
	<table id=dbcolortable width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr> 
            <td width="13%">部门名称</td>
            <td width="87%" ><input name="dept_name" type="text" class="input_data" size="30" maxlength="50"></td>
          </tr>
          <tr> 
            <td>上级部门</td>
            <td><input name="parent_name" type="text" class="input_data" size="30" readonly>&nbsp;<input type="button" class="input_button" name="deptSel" value="选择部门" onClick="selDept()"></td>
          </tr>
          <tr> 
            <td>部门类型</td>
            <td><input name="dept_type" type="text" class="input_data" size="30" maxlength="10"></td>
          </tr>
          <tr> 
            <td>可用标志</td>
            <td><select name="enabled">
            	<option value="Y">启用&nbsp;&nbsp;&nbsp;&nbsp;</option>
            	<option value="N">禁用&nbsp;&nbsp;&nbsp;&nbsp;</option>
            </td>
          </tr>
          <tr> 
            <td>部门排序</td>
            <td><input name="queue" type="text" class="input_data" size="30" onKeyPress=number_check() maxlength="4"></td>
          </tr>
          <tr> 
            <td>部门描述</td>
            <td><textarea name="description" cols="80" class="input_data" rows="10"></textarea>
            </td>
          </tr>
          <input type="hidden" name="dept_code" value="">
          <input type="hidden" name="parent_id" value="">
        </table>
  <SCRIPT language="Javascript" src="../js/trdbcolor.js"></SCRIPT>
  </td></tr>
  </table>
  <br>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td align="right"><input type="button" class="input_button" name="a" value="保 存" onClick="do_add()">
        <input type="button" class="input_button" name="b" value="返 回" onClick="history.back()"></td>
    </tr>
  </table>
    </form>
<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>
