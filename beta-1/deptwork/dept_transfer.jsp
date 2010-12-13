<%@ page contentType="text/html;charset=GBK" language="java"  errorPage="" %>
<%@ page import="java.util.*" %> 
<%@ page import = "com.dfkj.utilities.StringUtil"%>
<html>
<head>
<title></title>
</head>
<body>
<script language="javascript">
	<%
		String retFlag = (String)request.getAttribute("FLAG");
		String showMsg = "部门删除成功！";
		if(retFlag == null){
			retFlag = "false";
		}else{
			if(retFlag.equals("false"))
				showMsg = "部门删除失败！";
			if(retFlag.equals("exist"))
				showMsg = "当前选择的部门含有子部门，请先删除子部门！";
			if(retFlag.equals("editTrue"))
				showMsg = "部门修改成功！";
			if(retFlag.equals("editFalse"))
				showMsg = "部门修改失败！";
		}
	%>
		alert("<%=showMsg%>");
		parent.window.location.href="<%=request.getContextPath()%>/blank.jsp";
</script>
</body>
</html>