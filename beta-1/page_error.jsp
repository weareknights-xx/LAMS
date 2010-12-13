<%@page contentType="text/html;charset=GBK"%>
<%
  //±íÊ¾²ã´íÎó  
  //tomcat 4.1.29
  //String sReturn=new String(request.getParameter("BusinessError").getBytes("ISO8859_1"),"UTF-8");  
  //out.println(sReturn);
  
  //tomcat 4.1.18
  out.println(request.getParameter("BusinessError"));
  
 %>