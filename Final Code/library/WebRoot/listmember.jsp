<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.study.dao.*"%>
<%@ page import="com.study.vo.*"%>
<%@ page isErrorPage="true"%>
<%@ page errorPage="login.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�����û��б�</title>
	<link href="css/main.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <jsp:useBean id="bbsmember" type="com.study.vo.Member" scope="session"></jsp:useBean>
  <jsp:setProperty property="*" name="bbsmember"/>
  <% 
   if(bbsmember.getMemberusername().length()<1||bbsmember.getMemberauthority()>0){
   	out.println("<script language=javascript>");
  	out.println("alert('�Բ�����û�д�Ȩ��!');");
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
      <td background='img/bg3.gif' class='px13B_black'><a href="listmember.jsp">��Ա����</a></td>
	  <td background='img/bg3.gif' class='px13B_black'><a href="list.jsp">�������</a></td>
	  <td background='img/bg3.gif' class='px13B_black'><a href="listtopic.jsp">������</a></td>
    </tr>
  </table>
   <table width="99%" border="0" align="center" cellpadding="8" cellspacing="1" bgcolor="#E2E2E1">
   <tr bgcolor="F9F9F9">
	<td align="center" class="px13B_gray">ѧ��<br></td>
	<td align="center" class="px13B_gray">�û���</td>
	<td align="center" class="px13B_gray">����ʱ��<br></td>
	<td align="center" class="px13B_gray">qq<br></td>
	<td align="center" class="px13B_gray">Ȩ��</td>
	<td align="center" class="px13B_gray">����</td>
����</tr>
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
			out.println("<font color='#FF0000'>��վ����Ա</font>");
			break;
		case 1:
			out.println("VIP��Ա");
			break;
		case 2:
			out.println("һ���Ա");
			break;
	}
	%></td>
	<td align="center"><a href='./servlet/delMember?type=del&memberid=<%=membertmp.getMemberid() %>'>ɾ��</a></td>
	</tr>
<%
}
%>
</table>
<%@ include file = "bottom.jsp"%>
  </body>
</html>
