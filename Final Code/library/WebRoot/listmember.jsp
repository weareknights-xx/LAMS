<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.study.dao.*"%>
<%@ page import="com.study.vo.*"%>
<%@ page isErrorPage="true"%>
<%@ page errorPage="login.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>助理用户列表</title>
	<link href="css/main.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <jsp:useBean id="bbsmember" type="com.study.vo.Member" scope="session"></jsp:useBean>
  <jsp:setProperty property="*" name="bbsmember"/>
  <% 
   if(bbsmember.getMemberusername().length()<1||bbsmember.getMemberauthority()>0){
   	out.println("<script language=javascript>");
  	out.println("alert('对不起您没有此权限!');");
  	out.println("window.location.href='login.jsp';");
  	out.println("</srcipt>");
  	out.flush();
  	out.clear();
  	out.close();
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
	<td align="center" class="px13B_gray">学号<br></td>
	<td align="center" class="px13B_gray">用户名</td>
	<td align="center" class="px13B_gray">空余时间<br></td>
	<td align="center" class="px13B_gray">qq<br></td>
	<td align="center" class="px13B_gray">权限</td>
	<td align="center" class="px13B_gray">操作</td>
　　</tr>
<%
    MemberDAO memberdao = DAOFactory.getMemberDAO();
	Vector memberlist = memberdao.liskMember();
	Iterator memberit = memberlist.iterator();
	Member membertmp = null;
	while(memberit.hasNext()){
	membertmp = (Member)memberit.next();
%>
    <tr bgcolor="#FFFFFF">
    <td class='px13B_black'><a href='updatemember.jsp?memberid=<%=membertmp.getMemberid() %>' ><%=membertmp.getMemberid()%></a></td>
	<td class='px13B_black'><%=membertmp.getMemberusername() %></td>
	<td class='px13B_black'><%=membertmp.getMembername() %></td>
	<td class='px13B_black'><%=membertmp.getMemberemail() %></td>
	<td class='px13B_black'><%
	switch(membertmp.getMemberauthority()){
		case 0:
			out.println("<font color='#FF0000'>网站管理员</font>");
			break;
		case 1:
			out.println("VIP会员");
			break;
		case 2:
			out.println("一般会员");
			break;
	}
	%></td>
	<td align="center"><a href='./servlet/delMember?type=del&memberid=<%=membertmp.getMemberid() %>'>删除</a></td>
	</tr>
<%
}
%>
</table>
<%@ include file = "bottom.jsp"%>
  </body>
</html>
