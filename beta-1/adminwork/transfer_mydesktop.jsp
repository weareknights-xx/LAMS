<%@page	contentType="text/html;	charset=GBK"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%

   RequestDispatcher rd = getServletContext().getRequestDispatcher("/MainController.do?ActionName=com.dfkj.eoa.actions.adminwork.QueryDesktopAction&NoCache=1&NextPage=/adminwork/mydesktop.jsp");  
 

 rd.forward(request,response);  
%>

