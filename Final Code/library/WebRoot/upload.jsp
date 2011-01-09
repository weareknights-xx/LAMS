<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<style type="text/css">
<!--
BODY{
font-size:9pt
}
.tx1 { height: 20px;font-size: 9pt; border: 1px solid; border-color: #000000; color: #0000FF}
-->
</style>

<SCRIPT language=javascript>
function check_file() 
{
  var strFileName=form1.FileName.value;
  
  if (strFileName=="")
  {
    alert("请选择要上传的文件");
    return false;
  }
}
</SCRIPT>
</head>
<body leftmargin="0" topmargin="0" background="img/Bg_Index.gif">
<form action="<%=basePath+"saveUpload.jsp" %>" method="post" name="form1" enctype="multipart/form-data" onSubmit="javascript: return check_file();">
  <input name="FileName" type="FILE" size="20" id="FileName">
  <input type="submit" name="Submit" value="上传">
</form>
</body>
</html>