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
     alert("�����ļ��ϴ��ɹ�");
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
         opener.document.formAdd.act_result.value="�ϴ��ɹ�";
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
         alert("�����ļ��ϴ�ʧ��");
  <%
  if (para.equals("p")){
  %>
         opener.document.formAdd.file_name.value="�ϴ�ʧ��";
  <%
  }else{
  %>
         opener.document.formAdd.act_result.value="�ϴ�ʧ��";
  <%
  }
  %>
         window.close();
      </script>
  <%}%>
</table>
</body>
</html>