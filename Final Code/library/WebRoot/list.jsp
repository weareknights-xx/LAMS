<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.study.dao.*"%>
<%@ page import="com.study.vo.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书馆助理管理系统</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
</head>
<%
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
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="1%" height="30">&nbsp;</td>
    <td width="99%"><img src="img/icon_3.gif" width="16" height="16" align="absmiddle">&nbsp;<span class="px12B_blue">您当前所处位置：<font color='#FF0000'><%=mtopic.getTopicname() %></font></span></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td></td>
  </tr>
</table>
<table width="99%" border="0" align="center" cellpadding="8" cellspacing="1" bgcolor="#E2E2E1">
  <%
    	mtopic.setTopicid(topicid);
    	MessageDAO md = DAOFactory.getMessageDAO();
    	Vector messagelist = md.listMessageByTopic(mtopic);
    	Message messagetmp = null;
        Member membertmp = null;
      	Iterator messageit = messagelist.iterator();
      	while(messageit.hasNext()){
      	    messagetmp = (Message)messageit.next();
      	    membertmp = messagetmp.getMember();
      		out.println("<tr bgcolor='F9F9F9'>");
      		out.println("<td align='left' class='px13B_gray'><a href='message.jsp?messageid="+messagetmp.getMessageid()+"' target='blank'>"+messagetmp.getMessagetitle()+"</a></td>");
      		out.println("<td align='left'>"+membertmp.getMemberusername()+"&nbsp;&nbsp;<a href='delMessage?type=del&messageid="+messagetmp.getMessageid()+"'>删除</a></td>");
      		out.println("</tr>");
      	}
      %>
 
</table>
<%@ include file = "bottom.jsp"%>
</body>
</html>
