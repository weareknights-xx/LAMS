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
		String showMsg = "����ɾ���ɹ���";
		if(retFlag == null){
			retFlag = "false";
		}else{
			if(retFlag.equals("false"))
				showMsg = "����ɾ��ʧ�ܣ�";
			if(retFlag.equals("exist"))
				showMsg = "��ǰѡ��Ĳ��ź����Ӳ��ţ�����ɾ���Ӳ��ţ�";
			if(retFlag.equals("editTrue"))
				showMsg = "�����޸ĳɹ���";
			if(retFlag.equals("editFalse"))
				showMsg = "�����޸�ʧ�ܣ�";
		}
	%>
		alert("<%=showMsg%>");
		parent.window.location.href="<%=request.getContextPath()%>/blank.jsp";
</script>
</body>
</html>