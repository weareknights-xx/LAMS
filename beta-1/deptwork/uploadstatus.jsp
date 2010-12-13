<html>
<head>
<%@ page contentType="text/html; charset=GBK" %>
</head>
<body topmargin="0" >
<table cellpadding=0 cellspacing=0 border=0 width=456 align=center height="38">
<%
  String uploadstatus = (String)request.getAttribute("uploadstatus");
  String para = (String)request.getAttribute("para");
  String fileName = "",filePath = "",docPath = "";
  System.out.println(fileName);
  if (para.equals("p")||para.equals("a"))
 {   fileName = (String)request.getAttribute("file_name");
     filePath = (String)request.getAttribute("file_path");}
  else
     docPath = (String)request.getAttribute("doc_path");
	if(uploadstatus.equals("true")){ 
%>

<script language="javascript">
     alert("附件文件上传成功");
<%
  if (para.equals("a")){
  %>
         opener.document.formAdd.file_name.value="<%=fileName%>";
         opener.document.formAdd.file_path.value="<%=filePath%>";
  <%
  }
  if (para.equals("m")){
  %>
         opener.document.formAdd.doc_path.value="<%=docPath%>";
         opener.document.formAdd.act_result.value="上传成功";
  <%
  }if (para.equals("p")){
  %>
         opener.document.formModify.file_name.value="<%=fileName%>";
         opener.document.formModify.file_path.value="<%=filePath%>";
  <%
  }
  %>
opener.saveData()
window.close();    
</script>
   
  <%}else{%>
	<script language="javascript">
         alert("附件文件上传失败");
  <%
  if (para.equals("p")){
  %>
         opener.document.formAdd.file_name.value="上传失败";
  <%
  }else{
  %>
         opener.document.formAdd.act_result.value="上传失败";
  <%
  }
  %>
         window.close();
      </script>
  <%}%>
</table>
</body>
</html>