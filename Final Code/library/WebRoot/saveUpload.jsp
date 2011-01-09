<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'saveUpload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
String msg = "";
DiskFileUpload fu = new DiskFileUpload();
// 设置允许用户上传文件大小,单位:字节
fu.setSizeMax(10000000);
// maximum size that will be stored in memory?
// 设置最多只允许在内存中存储的数据,单位:字节
fu.setSizeThreshold(4096);
// 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
fu.setRepositoryPath("C:\\bbstmp1");
//开始读取上传信息
List fileItems = fu.parseRequest(request);
%>
<body>

<%
// 依次处理每个上传的文件
Iterator iter = fileItems.iterator();
while (iter.hasNext()) {
  FileItem item = (FileItem) iter.next();
  //忽略其他不是文件域的所有表单信息
  if (!item.isFormField()) {
   String name = item.getName();
   long size = item.getSize();
   if((name==null||name.equals("")) && size==0)
   continue;

   //保存上传的文件到指定的目录
   
   String filename = item.getName();
   String newname = null;
   String filepath = null;
   filepath = application.getRealPath(path);
   String[] par = filename.split("\\\\");
   String[] spot = filename.split("\\.");
   String ext = "";
   if(spot.length>1){
   	ext = spot[spot.length-1];
   }
   for(int i=0;i<par.length;i++){
   	if(i==(par.length-1)){
   		newname = par[i];
   	}
   }
   double random = Math.random();
   int newrandom = (int)random*1000;
   newname = System.currentTimeMillis()+newrandom+"."+ext;
   
   item.write(new File(filepath+"upload\\"+newname));
    out.println("<script language = javascript>");
    out.println("parent.document.form1.photourl.value='../upload/"+newname+"';");
    out.println("alert('文件上传成功！');");
    out.println("</script>");
  }
}
%>

</body>
</html>