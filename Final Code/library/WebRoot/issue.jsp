<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>BBS��������</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  <jsp:useBean class="com.study.vo.Member"id="bbsmember" scope="session" type="com.study.vo.Member"/>
  <jsp:setProperty name="bbsmember" property="*"/>
  
  <body>
    <%
  		if(bbsmember.getMemberusername().length()<1){
  			  	out.println("<script language=javascript>");
  				out.println("alert('�����ȵ�¼!');");
  				out.println("window.location.href='login.jsp';");
  				out.println("</srcipt>");
  				out.flush();
  				out.clear();
  				out.close();
  		}
    
  int topicid = 0;
  try{
  	topicid = Integer.parseInt(request.getParameter("messageid"));
  }catch(Exception ex){
  	out.println("<script language=javascript>");
  	out.println("alert('��������ʧ��!');");
  	out.println("window.location.href='list.jsp';");
  	out.println("</srcipt>");
  	out.flush();
  	out.clear();
  	out.close();
  }
%>
    <form id="form1" name="form1" method="post" action="./servlet/saveMessage?type=issue" onsubmit="return checkForm();">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td colspan="2" align="center"><B>B&nbsp;B&nbsp;S&nbsp;��&nbsp;��&nbsp;��&nbsp;��</B></td>
    </tr>
    <tr>
      <td colspan="2">
      <%
      	String err = request.getParameter("err");
      	if(err!=null){
      		if(err.length()>0){
      			if(err.equalsIgnoreCase("messagetitle")){
      				out.println("<font color='#FF0000'>������д��Ϣ����!</font>");
      			}else if(err.equalsIgnoreCase("messagecontent")){
      				out.println("<font color='#FF0000'>������д�������ݣ��������ݲ�������3���ֽ�!</font>");
      			}
      		}
      	}
      %>
      </td>
    </tr>
    <tr>
      <td width="39%" align="right">�������⣺</td>
      <td width="61%"><input name="messagetitle" type="text" id="messagetitle" /></td>
    </tr>
    
    <tr>
      <td align="right">�������ݣ�</td>
      <td>
	    <TEXTAREA name="messagecontent" rows="10" cols="50"></TEXTAREA>
	  <input type="hidden" name="messagememberid" value="<%=bbsmember.getMemberid()%>" id="messagememberid"/>
	  <input type="hidden" name="topicid" value="<%=topicid%>" id="topicid"/>
	  </td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" name="Submit" value="�ύ" />&nbsp;&nbsp;
      <input type="reset" name="Submit2" value="����" /></td>
    </tr>
  </table>
</form>
  </body>
</html>
