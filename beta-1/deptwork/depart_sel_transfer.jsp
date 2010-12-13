<%@page contentType="text/html;charset=GBK"%>
<%@ page import = "com.dfkj.eoa.vo.EoaDeptVO"%>
<%@ page import = "com.dfkj.eoa.vo.EoaUsersVO"%>
<%@ page import = "java.util.Vector"%>
<html>
<head>
<title>增加部门</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<link rel="stylesheet" type="text/css" 
      href="<%=request.getContextPath()%>/css/programstyle.css">
<%
	EoaDeptVO vo = new EoaDeptVO();
	vo = (EoaDeptVO)request.getAttribute("DEPTVO");
	String deptId = "";
	String deptCode = "";
	String deptName = "";
	if(vo != null){
		deptId = vo.getDeptId();
		deptName = vo.getDeptName();
		deptCode = vo.getDeptCode();
	}
%>
<script language="JavaScript" type="text/JavaScript">
alert('<%=deptName%>');
	opener.document.thisForm.parent_id.value = 'jjj';
</script>
</head>
<body>

</body>
</html>