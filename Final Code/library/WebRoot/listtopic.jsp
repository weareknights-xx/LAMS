<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.study.dao.*"%>
<%@ page import="com.study.vo.*"%>
<%@ page isErrorPage="true"%>
<%@ page errorPage="login.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书馆助理管理系统</title>
	<link href="css/main.css" rel="stylesheet" type="text/css">
  </head>
  <body>
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
  %>
  <%@ include file = "header.jsp" %>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td background='img/bg3.gif' class='px13B_black'><a href="listmember.jsp">会员管理</a></td>
	  <td background='img/bg3.gif' class='px13B_black'><a href="list.jsp">主题管理</a></td>
	  <td background='img/bg3.gif' class='px13B_black'><a href="listtopic.jsp">板块管理</a></td>
    </tr>
  </table>
   <table width="99%" border="0" align="center" cellpadding="8" cellspacing="1" bgcolor="#E2E2E1">
  <tr bgcolor="F9F9F9">
	<td align="center">板块信息ID号</td>
	<td align="center">板块信息名称</td>
	<td align="center">操作</td>
　　</tr>
<%
    TopicDAO topicdao = DAOFactory.getTopicDAO();
	Vector topiclist = topicdao.listTopic();
	Iterator topicit = topiclist.iterator();
	Topic topictmp = null;
	while(topicit.hasNext()){
	topictmp = (Topic)topicit.next();
%>
    <tr bgcolor="#FFFFFF">
    <td align="center"><a href='updatetopic.jsp?topicid=<%=topictmp.getTopicid() %>'><%=topictmp.getTopicid()%></a></td>
	<td align="center"><%=topictmp.getTopicname() %></td>
	<td align="center"><a href='./servlet/saveTopic?type=del&topicid=<%=topictmp.getTopicid()%>'>删除</a></td>
	</tr>
<%
}
%>
<tr bgcolor='#FFFFFF'>
	<td colspan="3" align='right'>新增部门<br></td>
</tr>
</table>
<%@ include file = "bottom.jsp"%>
  </body>
</html>
