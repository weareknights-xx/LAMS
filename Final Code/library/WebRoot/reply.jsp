
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>BBS回复标题</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  <jsp:useBean class="com.study.vo.Member"id="bbsmember" scope="session" type="com.study.vo.Member"/>
  <jsp:setProperty name="bbsmember" property="*"/>
  <body>
    <%
  		if(bbsmember.getMemberusername().length()<1){
  			  	out.println("<script language=javascript>");
  				out.println("alert('请您先登录!');");
  				out.println("window.location.href='login.jsp';");
  				out.println("</srcipt>");
  				out.flush();
  				out.clear();
  				out.close();
  		}

  long messageid = 0;
  try{
  	messageid = Long.parseLong(request.getParameter("messageid"));
  }catch(Exception ex){
  	out.println("<script language=javascript>");
  	out.println("alert('参数传递失败!');");
  	out.println("window.location.href='list.jsp';");
  	out.println("</srcipt>");
  	out.flush();
  	out.clear();
  	out.close();
  }
    %>
    <form id="form1" name="form1" method="post" action="./servlet/saveMessage?type=reply" onsubmit="return checkForm();">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td colspan="2" align="center"><B>B&nbsp;B&nbsp;S&nbsp;回&nbsp;复&nbsp;标&nbsp;题</B></td>
    </tr>
    <tr>
      <td colspan="2">
      <%
      	String err = request.getParameter("err");
      	if(err!=null){
      		if(err.length()>0){
      			if(err.equalsIgnoreCase("messagetitle")){
      				out.println("<font color='#FF0000'>请您填写信息标题!</font>");
      			}else if(err.equalsIgnoreCase("messagecontent")){
      				out.println("<font color='#FF0000'>请您填写主题内容，主题内容不能少于3个字节!</font>");
      			}
      		}
      	}
      %>
      </td>
    </tr>
    <tr>
      <td width="39%" align="right">回复标题：</td>
      <td width="61%"><input name="messagetitle" type="text" id="messagetitle" /></td>
    </tr>
    
    <tr>
      <td align="right">内&nbsp;&nbsp;容：</td>
      <td>
	    <TEXTAREA name="messagecontent" rows="10" cols="50"></TEXTAREA>
	  <input type="hidden" name="messagememberid" value="<%=bbsmember.getMemberid()%>" id="messagememberid"/>
	  <input type="hidden" name="messageid" value="<%=messageid%>" id="messageid"/>
	  </td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" name="Submit" value="提交" />&nbsp;&nbsp;
      <input type="reset" name="Submit2" value="重置" /></td>
    </tr>
  </table>
</form>
  </body>
</html>
