<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>空余时间查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
 <%@ include file = "header.jsp" %>
  <br>
  <form name="form1" method="post" action="search.jsp">
    请输入你需要的空余时间：
    <input type="text"   name="studentname" id="studentname">
    <input type="submit" name="Submit" value="提交">
  </form><br>.
  <%
 	String studentname = request.getParameter("studentname");
 	
 	if(studentname!=null){
 		studentname = new String(studentname.getBytes("iso8859-1"),"gb2312");
 		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BBS";
		String user = "sa";
		String pwd = "eclipse";
		String query = "select * from [member] where membername like '%"+studentname+"%'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
				.newInstance();
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			out.println("<table width='80%' border='1'cellpadding='1' cellspacing='1' bordercolor='#000000'>");
			out.println(" <tr>");
			out.println(" <td bgcolor='#FFFFFF' align='center'>助理ID</td>");
			out.println(" <td bgcolor='#FFFFFF' align='center'>助理姓名</td>");
			out.println("<td bgcolor='#FFFFFF' align='center'>助理空余时间</td>");
			out.println(" <td bgcolor='#FFFFFF' align='center'>助理QQ</td>");
			out.println("</tr>");
			while(rs.next()){
				out.println("<tr>");
				out.println("<td bgcolor='#FFFFFF' align='center'>"+rs.getString("memberid")+"</td>");
				out.println("<td bgcolor='#FFFFFF' align='center'>"+rs.getString("memberusername")+"</td>");
				out.println("<td bgcolor='#FFFFFF' align='center'>"+rs.getString("membername")+"</td>");
				out.println("<td bgcolor='#FFFFFF' align='center'>"+rs.getString("memberemail")+"</td>");
				out.println("</tr>");
			}
			out.println(" </table>");
		}catch(Exception ex){
			out.println(ex.getMessage());
		}finally{
			try{
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception ex){
				System.out.println(ex);
			}
		}
 	}
  %>
  
   
<%@ include file = "bottom.jsp"%><br /><br />
 
  </body>
</html>
