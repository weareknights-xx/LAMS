<%@page contentType="text/html;charset=GBK"%>
<%@ page import = "com.dfkj.eoa.vo.EoaDeptVO"%>
<%@ page import = "com.dfkj.eoa.vo.PUserVO"%>
<%@ page import = "java.util.Vector"%>
<html>
<head>
<title>部门编辑</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
<%
	Vector v = new Vector();
	v = (Vector)request.getAttribute("UserList");
	String multi = com.dfkj.data.DaoUtil.NullToStr(request.getParameter("Multi"));
	System.out.println("user_list.jsp /" + multi+"/");
	//boolean bMulti = multi.equals("true");	
	
%>
</head>
<script language="JavaScript" type="text/JavaScript">
<!--

function openwin_modify(id){
  document.location.href = "";
	}
function openwin_detail(id){
  document.location.href = "";
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

function doSelUser(id,name,deptid){
	
	parent.opener.document.thisForm.deptname.value = deptid;
	parent.opener.document.thisForm.username.value = name;
	parent.opener.document.thisForm.userid.value = id;
	parent.close();
}
<%if(multi.equals("muldepartment")){%>
	function doSelectUser(){
		src = "";  
		src1 = "";                                                         																																																										
		sUserName = "";
		tmpUserName = "";
		tmpUserId = "";                                                     																																																										                                                                   																																																										
		for(i=0;i<formList.elements.length-1;i++)                           																																																										
		{                                                               																																																										
			j=i+1;   
			k=i+2;                                                   																																																										
			if(formList.elements(i).checked)                            																																																										
			{                                                           																																																										
			if(formList.elements(i).name=="grnapplyId" && formList.elements(k).name=="userIdforkp")                 																																																										
				//src = formList.elements(i).value +"-"+formList.elements(k).value+"|"+src; 
				src = formList.elements(k).value+"|"+src;
				//alert(src);
			if(formList.elements(j).name=="userName")             																																																										                																																																										
				sUserName = formList.elements(j).value+","+sUserName;																																																											
			}                                                           																																																										
		}                                                                 																																																										
			tmpUserId = parent.opener.document.thisForm.sendToId.value + src;
			parent.opener.document.thisForm.sendToId.value = tmpUserId;
			tmpUserName = parent.opener.document.thisForm.sendToName.value + sUserName;
			parent.opener.document.thisForm.sendToName.value = tmpUserName;			
	}
<%
  }else if(multi.equals("MultiReceiver")){
%>
	  function doSelectUser(){                                                                  																																																										
			src = "";
			sUserName = "";
                              																																																										
			for(i=0;i<formList.elements.length-1;i++){
				j=i+1;
				if(formList.elements(i).checked){
				  if(formList.elements(i).name=="grnapplyId")
					  src = formList.elements(i).value+"|"+src;
				  if(formList.elements(j).name=="userName")
				    sUserName = formList.elements(j).value+","+sUserName;
				}
			}
			
			parent.opener.document.formAdd.authorityId.value += src;
			parent.opener.document.formAdd.authorityName.value += sUserName;
			//parent.close();
	  }                                                                      																																																										
<%}else{%>
	function doSelectUser(){                                                                  																																																										
			src = "";                                                           																																																										
			sUserName = "";                                                     																																																										
	                                                                            																																																										
			for(i=0;i<formList.elements.length-1;i++)                           																																																										
				{                                                               																																																										
					j=i+1;                                                      																																																										
					if(formList.elements(i).checked)                            																																																										
					{                                                           																																																										
					if(formList.elements(i).name=="grnapplyId")                 																																																										
						src = formList.elements(i).value+"|"+src;               																																																										
				    if(formList.elements(j).name=="userName")                   																																																										
				    	sUserName = formList.elements(j).value+","+sUserName;																																																											
				   	}                                                           																																																										
			  }                                                                 																																																										
			parent.opener.document.formAdd.authorityId.value=src;               																																																										
			parent.opener.document.formAdd.authorityName.value = sUserName;     																																																										
			parent.close();                                                     																																																										
	     }                                                                      																																																										
<%}%>
-->
</script>
<%
	//Vector v = new Vector();
	//v = (Vector)request.getAttribute("UserList");
	//String multi = com.dfkj.data.DaoUtil.NullToStr(request.getParameter("Multi"));
	//boolean bMulti = multi.equals("true");	
%>
<body>
<form name="formList" method="post" action="">
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
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
            <td width="20%" class="table_title">序号 
            <%
            if(multi.equals("true") || multi.equals("muldepartment") || multi.equals("MultiReceiver") )
              out.println("<input type=\"checkbox\" name=\"isAllSelected\" onclick=\"setIsAll()\"> ");
            %>
            </td>
            <td width="25%" class="table_title">姓名</td>
            <td width="25%" class="table_title">用户名</td>
            <td width="30%" class="table_title">所属部门</td>
          </tr>
          <%
          	if(v != null && v.size() > 0){
          		for(int i = 0; i < v.size(); i++){
          			PUserVO uservo = (PUserVO)v.elementAt(i); 
          %>
          <tr> 
            <td height="20"> 
            <%if(multi.equals("true") || multi.equals("muldepartment") || multi.equals("MultiReceiver"))
            {
            out.println("<input type=\"checkbox\" name=\"grnapplyId\" value=\" "+uservo.getUserId()+"-"+uservo.getUserDescription()+"\" >"+ (i+1) );
            out.println("<input type=\"hidden\" name=\"userName\" value=\" "+uservo.getUserDescription()+"\" >	</td>");
            out.println("<input type=\"hidden\" name=\"userIdforkp\" value=\""+uservo.getUserId()+"\" >	</td>");
             }
            else
            out.println((i+1) +"</td>");
            
            if(multi.equals("null"))
            { 
              %>
            <td title = '单击选择人员' height="20" style="cursor:hand" onCLick="javascript:doSelUser('<%=uservo.getUserId()%>','<%=uservo.getUserDescription()%>','<%=uservo.getDepartmentName()%>');"><%=uservo.getUserDescription()%></td>
            <%
            }
            else
            {%>
              <td height="20"><%=uservo.getUserDescription()%></td>
          <%}
          %>
 	    <td height="20" ><%=uservo.getUserName()%></td>
            <td height="20"><%=uservo.getDepartmentName()%></td>
          </tr>
          <%}
          }%>
        </table>
 <SCRIPT language="Javascript" src="<%=request.getContextPath()%>/js/trdbcolor.js"></SCRIPT>
 </td></tr>
 <%if(multi.equals("true") || multi.equals("muldepartment") || multi.equals("MultiReceiver") )
 {
 %>
 <tr>
 <br>
 <td align="right"><input type="button" name="btnOk" value="确 定"  onclick="doSelectUser();" class="input_button">
        <input type="button" name="btnClose" value="关 闭" onClick="parent.close()"  style="cursor:hand" class="input_button"></td>
 </tr>
 <%
 }
 %>
 </table>
  <center>
  </center>
  <br>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      
      <td align="right"> 
        <!--<input type="button" class="input_button" name="b" value="? ?" style="cursor:hand" onClick="delAll()">
        <input type="button" class="input_button" name="c" value="关  闭" style="cursor:hand" onClick="window.close();">--></td>
    </tr>
  </table>
  </form>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<%
if(multi.equals("true"))
{
%>
<script language="JavaScript" type="text/JavaScript">
<!--
//var authorityId = parent.opener.document.formAdd.authorityId.value;
//var arrayId = authorityId.split("|");
	//for(var i=0;i<formList.elements.length-1;i++)
	//{
		//if(formList.elements(i).name=="grnapplyId")
				//{
				 //  var pos = authorityId.indexOf(formList.elements(i).value);
				   
					//if(pos >= 0)
					//   	formList.elements(i).checked =true;
					
					//for(var j=0;i<arrayId.length-1;j++)
					//{
					//if(arrayId[j] == formList.elements(i).value)
					//	formList.elements(i).checked =true;
				   // }
		//	}
  // }	
-->
</script>
<%
}
%>
</body>
</html>
