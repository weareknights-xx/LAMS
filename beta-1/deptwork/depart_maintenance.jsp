<%@page contentType="text/html;charset=GBK"%>
<%@ page import = "com.dfkj.eoa.vo.EoaDeptVO"%>
<%@ page import = "com.dfkj.eoa.vo.PUserVO"%>
<%@ page import = "java.util.Vector"%>
<html>
<head>
<title>���ű༭</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">

</head>
<%
	Vector v = new Vector();
	v = (Vector)request.getAttribute("UserList");
	
	String deptId = request.getParameter("DEPT_ID");
	System.out.println(deptId);
%>
<script language="JavaScript" type="text/JavaScript">
<!--

function openwin_modify(id){
  document.location.href = "";
	}
function openwin_detail(id){
  document.location.href = "";
	}	
function openwin_add(){
  document.location.href ="<%=request.getContextPath()%>/deptwork/dept_add.jsp";
	}
function del(id){
    if(confirm("????????")){ 
      document.location.href= "";  	  
    }
}
   
function delAll()
{
  if(confirm("????????")){ 
      formList.action = "";  	  
      formList.submit();
}
}

function setIsAll()
{
    if(formList.isAllSelected.checked==true)
    {
		for(i=1;i<formList.elements.length;i++)
			{
				formList.elements(i).checked=true;
			}

	}
	else
	{
		for(i=1;i<formList.elements.length;i++)
			{
				formList.elements(i).checked=false;
			}
	}

}
function doQuery(){
   formList.action = "";
   formList.submit();
}
function del(){
	if(<%=deptId%> == null){
		alert("��ѡ��һ�����ţ�");
		return ;
	}
	<%if(v != null && v.size() > 0){%>
		alert("����ѡ��Ĳ��������Ѿ�¼����Ա�����ݣ��޷�ɾ����");
		return ;
	<%}%>
	if(confirm("��ȷ��Ҫɾ����ǰѡ�еĲ�����")){
		formList.action="<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.actions.deptwork.DelEoaDeptAction&NoCache=1&NextPage=/deptwork/dept_transfer.jsp&dept_id=<%=deptId%>"
		formList.submit();
	}
}
//////////////////////////////////
function edit(){
	if(<%=deptId%> == null){
		alert("��ѡ��һ�����ţ�");
		return ;
	}
    formList.action="<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.actions.deptwork.EditEoaDeptAction&NoCache=1&NextPage=/deptwork/dept_edit.jsp&dept_id=<%=deptId%>&actionFlag=list";
    formList.submit();
}
-->
</script>

<body>
<form name="formList" method="post" action="">
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr>
      <td>Ա���б�</td>
    </tr>
	<tr>
		<td><img src="<%=request.getContextPath()%>/images/table_title.jpg"
		width="206" height="10"></td>
	</tr>

  </table>
  <br>
  <table width="100%" border="0" align="center" cellspacing="0" cellpadding="0" class="content_table">
    <tr><td>
	<table id=dbcolortable width="100%" border="0" cellspacing="1" cellpadding="4" align="center">
          <tr > 
            <td width="30%" class="table_title">��� 
              <input type="checkbox" name="isAllSelected" onclick="setIsAll()"> 
            </td>
            <td width="30%" class="table_title">����</td>
            <td width="40%" class="table_title">�û���</td>
            <!--<td width="23%" class="table_title">ְ��</td>
            <td width="10%" class="table_title">����</td>-->
          </tr>
          <%
          	if(v != null && v.size() > 0){
          		for(int i = 0; i < v.size(); i++){
          			PUserVO uservo = (PUserVO)v.elementAt(i); 
          	
          %>
          <tr> 
            <td> <input type="checkbox" name="grnapplyId" value=""><%=i+1%></td>
            <td><%=uservo.getUserName()%></td>
            <td><%=uservo.getUserDescription()%></td>
            <!--<td>&nbsp;</td>
            <td><a href="javascript:openwin_modify()">�޸�</a>/<a href="javascript:del()">ɾ��</a></td>-->
          </tr>
          <%}
          }%>
        </table>
 <SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
 </td></tr>
 

 </table>
  <center>
  </center>
  <br>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      
      <td align="right">
      <input type="button" class="input_button" name="a" value="���Ӳ���" style="cursor:hand" onClick="openwin_add()"> 
      <input type="button" class="input_button" name="e" value="�޸Ĳ���" style="cursor:hand" onClick="edit()"> 
      <input type="button" class="input_button" name="b" value="ɾ������" style="cursor:hand" onClick="del()"> 
        <!--<input type="button" class="input_button" name="b" value="? ?" style="cursor:hand" onClick="delAll()">-->
        <input type="button" class="input_button" name="c" value="��  ��" style="cursor:hand" onClick="parent.history.back();"></td>
    </tr>
  </table>
  </form>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
</body>
</html>
