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
// ���������û��ϴ��ļ���С,��λ:�ֽ�
fu.setSizeMax(10000000);
// maximum size that will be stored in memory?
// �������ֻ�������ڴ��д洢������,��λ:�ֽ�
fu.setSizeThreshold(4096);
// ����һ���ļ���С����getSizeThreshold()��ֵʱ���ݴ����Ӳ�̵�Ŀ¼
fu.setRepositoryPath("C:\\bbstmp1");
//��ʼ��ȡ�ϴ���Ϣ
List fileItems = fu.parseRequest(request);
%>
<body>

<%
// ���δ���ÿ���ϴ����ļ�
Iterator iter = fileItems.iterator();
while (iter.hasNext()) {
  FileItem item = (FileItem) iter.next();
  //�������������ļ�������б���Ϣ
  if (!item.isFormField()) {
   String name = item.getName();
   long size = item.getSize();
   if((name==null||name.equals("")) && size==0)
   continue;

   //�����ϴ����ļ���ָ����Ŀ¼
   
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
    out.println("alert('�ļ��ϴ��ɹ���');");
    out.println("</script>");
  }
}
%>

</body>
</html>