<%@page contentType="text/html;charset=GBK"%>
<html>
<head><title>JSP Page</title></head>
<body>

<script language='javascript'>
    parent.parent.window.document.location.href="<%=request.getContextPath()%>/login.jsp?loginResult=1";
</script>
</body>
</html>
