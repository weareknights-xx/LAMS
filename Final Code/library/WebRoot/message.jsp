<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.study.dao.*"%>
<%@ page import="com.study.vo.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>ͼ����������ϵͳ</title>
	<link href="css/main.css" rel="stylesheet" type="text/css">
  </head>
  <%
  long messageid = 0;
  Message message = null;
  Member member = null;
  try{
  	messageid = Long.parseLong(request.getParameter("messageid"));
  }catch(Exception ex){
  	out.println("<script language=javascript>");
  	out.println("alert('��������ʧ��!');");
  	out.println("window.location.href='list.jsp';");
  	out.println("</srcipt>");
  	out.flush();
  	out.clear();
  	out.close();
  }
  MessageDAO messagedao = DAOFactory.getMessageDAO();
  message = messagedao.getMessageById(messageid);
  if(message==null){
  	out.println("<script language=javascript>");
  	out.println("alert('��������ʧ��!');");
  	out.println("window.location.href='list.jsp';");
  	out.println("</srcipt>");
  	out.flush();
  	out.clear();
  	out.close();
  }	
  member = message.getMember();
  int topicid = 0;
  try{
  	topicid = Integer.parseInt(request.getParameter("topicid"));
  }catch(Exception ex){
    
  	topicid = 0;
  }
  TopicDAO td = DAOFactory.getTopicDAO();
  Vector topiclist = td.listTopic();
  Topic mtopic = new Topic();
  %>
  <body>
  <%@ include file = "header.jsp" %>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <%
        Iterator topicit = topiclist.iterator();
        Topic tmp = null;
        int topiccount = 1;
        while(topicit.hasNext()){
        	tmp = (Topic)topicit.next();
        	out.println("<td align='center' background='img/bg3.gif' class='px13B_black'><b><a href='list.jsp?topicid="+tmp.getTopicid()+"'>"+tmp.getTopicname()+"</a></b></td>");
        	if(topicid==0&&topiccount==1){
        		topicid = tmp.getTopicid();
        	}
        	if(topicid==tmp.getTopicid()){
        		mtopic.setTopicid(tmp.getTopicid());
        		mtopic.setTopicname(tmp.getTopicname());
        	}
        	topiccount++;
        }
        %>
  </tr>
</table>
  <table width="100%" border="0" cellspacing="0" cellpadding="4">
  	<tr>
  		<td align='right' bgcolor='0099CC'><font color='#FFFFFF'><B>��&nbsp;&nbsp;��</B></font></td>
  	</tr>
  </table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="1%" height="30">&nbsp;</td>
    <td width="99%"><img src="img/icon_3.gif" width="16" height="16" align="absmiddle">&nbsp;<span class="px12B_blue">����ǰ����λ�ã�<font color='#FF0000'><%=mtopic.getTopicname() %></font></span></td>
  </tr>
</table>
  <table width="100%" border="0" cellpadding="8" cellspacing="1" bgcolor="#E2E2E1">
    <tr>
     <td bgcolor="#FFFFFF">
     ��&nbsp;&nbsp;&nbsp;&nbsp;�ߣ�&nbsp;&nbsp;&nbsp;&nbsp;<%=member.getMemberusername()%><br><br>
     ��&nbsp;&nbsp;&nbsp;&nbsp;�⣺&nbsp;&nbsp;&nbsp;&nbsp;<%=message.getMessagetitle() %><br><br>
     ��&nbsp;&nbsp;&nbsp;&nbsp;����&nbsp;&nbsp;&nbsp;&nbsp;<%=member.getMemberscore() %><br><br>
     ����ʱ�䣺&nbsp;&nbsp;&nbsp;&nbsp;<%=message.getMessagedate() %><br><br>
	 �������ݣ�<br><br>
	 &nbsp;&nbsp;&nbsp;&nbsp;<%=message.getMessagecontent() %><br><br><br><br>
     </td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
     <td bgcolor="#000000" height="1"></td>
    </tr>
  </table>
  
<%
	Vector messagelist = messagedao.listMessageByMessage(message);
	Iterator messageit = messagelist.iterator();
	Message messagetmp = null;
	Member membertmp = null;
	while(messageit.hasNext()){
	messagetmp = (Message)messageit.next();
	membertmp = messagetmp.getMember();
%>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
     <td  background='img/bg3.gif'>
     �����ˣ�<font color='#0000FF'><%=membertmp.getMemberusername()%></font>&nbsp;&nbsp;&nbsp;&nbsp;������<%=membertmp.getMemberscore()%>
     </td>
     <td align='right'  background='img/bg3.gif'>����ʱ�䣺<%=messagetmp.getMessagedate() %></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
     <td><br><br>&nbsp;&nbsp;&nbsp;&nbsp;<%=messagetmp.getMessagecontent() %><br><br><br><br></td>
    </tr>
  </table>
<%
}
%>
  </body>
</html>
