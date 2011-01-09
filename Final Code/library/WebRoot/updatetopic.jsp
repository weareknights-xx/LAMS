<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.study.dao.*"%>
<%@ page import="com.study.vo.*"%>
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
<title>BBS修改板块</title>
</head>

<body>
<script language="javascript">
	function checkForm()
	{
		var form = document.form1;
		if(form.username.value=="")
		{
			alert('请填写用户名！');
			form.username.focus();
			return false;
		}
		return true;
	}
</script>
<% 
  if(session.getAttribute("bbsmember")==null){
  	out.println("<script language=javascript>");
  	out.println("alert('参数传递失败!');");
  	out.println("window.location.href='login.jsp';");
  	out.println("</script>");
  	out.flush();
  	out.close();
  }
  Member bbsmember = (Member)session.getAttribute("bbsmember");
  if(bbsmember.getMemberauthority()>0){
  	out.println("<script language=javascript>");
  	out.println("alert('参数传递失败!');");
  	out.println("window.location.href='login.jsp';");
  	out.println("</srcipt>");
  }
  int topicid = Integer.parseInt(request.getParameter("topicid"));
  TopicDAO topicdao = DAOFactory.getTopicDAO();
  Topic topic = topicdao.getTopicById(topicid);
  %>
<%@ include file = "header.jsp" %>
<form id="form1" name="form1" method="post" action="./servlet/saveTopic?type=update" onsubmit="return checkForm();">
<table width="1000" border="0" cellspacing="0" cellpadding="2">
  <tr>
    <td><table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#B6D3EC">
      <tr>
        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="1%" height="30">&nbsp;</td>
            <td width="99%"><img src="img/icon_3.gif" width="16" height="16" align="absmiddle">&nbsp;<span class="px12B_blue">添加板块</span></td>
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
                  <td width="141" height="45" align="center" class="px13B_gray">板块名称：</td>
                  <td width="211"><input name="topictitle" type="text" id="topictitle" value="<%=topic.getTopicname() %>" />
      <input name="topicid" type="hidden" id="topicid" value="<%=topic.getTopicid()%>" /></td>
                </tr>
               <tr>
                  <td width="141" height="45" align="center" class="px13B_gray">&nbsp;</td>
                  <td width="211">&nbsp;</td>
                </tr>
               
                <tr>
                  <td height="45">&nbsp;</td>
                  <td><input type="submit" name="Submit" value="提交登录"></td>
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
</body>
</html>
