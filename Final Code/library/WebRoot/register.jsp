<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/main.css" rel="stylesheet" type="text/css">
<title>����ע��</title>
</head>

<body>
<script language="javascript">
	function checkForm()
	{
		var form = document.form1;
		if(form.username.value=="")
		{
			alert('����д�û�����');
			form.username.focus();
			return false;
		}
		if(form.password.value=="")
		{
			alert('����д���룡');
			form.password.focus();
			return false;
		}
		return true;
	}
</script>
<%@ include file = "header.jsp" %>
<form id="form1" name="form1" method="post" action="./servlet/saveMember?type=add" onsubmit="return checkForm();">
<table width="1000" border="0" cellspacing="0" cellpadding="2">
  <tr>
    <td><table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#B6D3EC">
      <tr>
        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="1%" height="30">&nbsp;</td>
            <td width="99%"><img src="img/icon_3.gif" width="16" height="16" align="absmiddle"></img> <span class="px12B_blue">����ע��</span></td>
          </tr>
        </table>
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="20" align="center" background="img/bg3.gif">&nbsp;</td>
              </tr>
          </table>
          <br>
          <br>
          <table width="352" border="0" align="center" cellpadding="0" cellspacing="0">
            <!--DWLayoutTable-->
		    <tr>
		      <td  height="12" class="px13B_gray"><img src="img/bg_index1.gif" width="352" height="12"></td>
		      </tr>
		    <tr>
              <td height="125" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="img/Bg_Index.gif">
                <!--DWLayoutTable-->
                <tr>
                  <td width="141" height="45" align="center" class="px13B_gray">�û�����</td>
                  <td width="211"><input name="username" type="text" id="username" style="width:180px"></td>
                </tr>
                <tr>
                  <td height="40" align="center" class="px13B_gray">��&nbsp;&nbsp;�룺</td>
		      <td><input name="password" type="password" id="password" style="width:180px"></td>
		      </tr>
			  <tr>
                  <td height="40" align="center" class="px13B_gray">����QQ��</td>
		      <td><input name="email" type="text" id="email" style="width:180px"></td>
		      </tr>
			  <tr>
                  <td height="40" align="center" class="px13B_gray">����ʱ�䣺</td>
		      <td><input name="name" type="text" id="name" style="width:180px"></td>
		      </tr>
		      
                <tr>
                  <td height="45">&nbsp;</td>
                  <td><input type="submit" name="Submit" value="�ύ��¼"></td>
		      </tr>
              </table>              </td>
              </tr>
		    
		    <tr>
		      <td height="9"><img src="img/bg_index2.gif" width="352" height="9"></td>
		      </tr>
          </table>
          <p>&nbsp;</p></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<%@ include file = "bottom.jsp"%>
</body>
</html>
