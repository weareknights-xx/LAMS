<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="com.study.dao.*"%>
<%@ page import="com.study.vo.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSPBBS论坛</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
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
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td align="center"><h2><b>J&nbsp;S&nbsp;P&nbsp;B&nbsp;B&nbsp;S&nbsp;论坛</b></h2></td>
    </tr>
  </table>
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <%
        Iterator topicit = topiclist.iterator();
        Topic tmp = null;
        int topiccount = 1;
        while(topicit.hasNext()){
        	tmp = (Topic)topicit.next();
        	out.println("<td align='center'><b><font size='5'><a href='list.jsp?topicid="+tmp.getTopicid()+"'>"+tmp.getTopicname()+"</a></font></b></td>");
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
  <jsp:useBean class="com.study.vo.Member"id="bbsmember" scope="session" type="com.study.vo.Member"/>
  <jsp:setProperty name="bbsmember" property="*"/>
  <table width="100%" border="0" cellspacing="0" cellpadding="4">
  	<tr>
  		<td align='right' bgcolor='0099CC'><font color='#FFFFFF'>
  		<B>
  		<%
  		if(bbsmember.getMemberusername().length()<1||bbsmember.getMemberauthority()>0){
  			out.println("<script language=javascript>");
  			out.println("alert('很抱歉您没有此权限!');");
  			out.println("window.location.href='login.jsp';");
  			out.println("</srcipt>");
  			out.flush();
  			out.clear();
  		}
  		%>
  		</B>
  		</font></td>
  	</tr>
  </table>
<table width="100%" border="0" cellspacing="0" cellpadding="4">
                <tr>
                	<td>您当前所处位置：<font color='#0000FF'>查看会员</font></td>
                </tr>
                <tr>
                  <td bgcolor="#0066FF" height="3"></td>
                </tr>
  </table>
<%
    MemberDAO memberdao = DAOFactory.getMemberDAO();
	Vector memberlist = memberdao.liskMember();
	Iterator memberit = memberlist.iterator();
	Member membertmp = null;
	while(memberit.hasNext()){
	membertmp = (Member)memberit.next();
%>
<!-- <table>...</table>-->
<%
}
%>
  </body>
</html>
