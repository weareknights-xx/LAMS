<html>
<head>
<%@ page contentType="text/html; charset=GBK" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/programstyle.css">
<title>文件上传</title>
</head>
<script language="javascript">
  function do_submit()
{
        document.frm_file_upload.submit();
        window.close();
}
  function check(thisForm)
  {   
     if (isEmpty(thisForm.title.value))
     {
       alert("请选择上传的文件！");
       thisForm.title.focus();
       return false;
     }
  }


  function isEmpty(str)
  {
        if (!str) {
            return true;
        }
        str = str.replace(/^\s+/, "");
        str = str.replace(/\s+$/, "");
        return (str.length == 0);
  }
</script>
<%
  String para = (String)request.getParameter("para");
%>
<body topmargin="0">
<br>
<form method=post action="<%=request.getContextPath()%>/AppendixFileUpload"  name="frm_file_upload" ENCTYPE="multipart/form-data" onSubmit="return check(this)">
<input type="hidden" name="file_type" value="deptwork">
<input type="hidden" name="para" value="<%=para%>">
<table  width=458 align=center height="100" border=1 align="center" 
      cellPadding=0 cellSpacing=0 bordercolorlight="#0247A6" bordercolordark="#FFFFFF" class="table_grey">
  <tr class="table_title">
    <td nowrap>请选择上传的文件</td>
  </tr>
  <tr>
    <td  height="45" width="868" align="center">
文件路径 <input class="input_data" type="file" name="title" size="50">
    </td>
  </tr>
  <tr>
    <td height="7" width="868" align="center">
       <span ><input class="input_button" type="submit" value=" 确  定 " name="upfile" id="upfile"></span>
    </td>
  </tr>
</table>
</form>
</body>
</html>