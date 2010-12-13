<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=GBK" language="java"%>
<html>
<head>
<title>图书馆助理管理系统1.0</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<style type="text/css">
<!--
	.login_input { border-top: 0; border-left: 0; border-right: 0; border-bottom: 1px dotted #000000; width: 120px; color: #000000}
	BODY {
				scrollbar-highlight-color: #065AB7; 
				scrollbar-shadow-color: #065AB7; 
				scrollbar-arrow-color: #065AB7; 
				scrollbar-face-color: #FFFFFF; 
				scrollbar-track-color: #FFFFFF; 
				scrollbar-3dlight-color: #FFFFFF; 
				scrollbar-darkshadow-color: #FFFFFF;
				font-size: 9pt; 
				color: #000000; 
				font-family: "宋体";
	}
	.input_button{
				font-family: "宋体,Arial,Helvetica,sans-serif";
				font-size: 9pt;
				color: #000000;
				background-color: #81D6FE;
}
-->
</style>
<script language="JavaScript">


function openwin()
{
formLogin.action="MainController.do?ActionName=com.dfkj.pm.actions.LoginAction";
formLogin.submit();

}
</script>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
<script language="JavaScript" type="text/JavaScript">
  function checkInput(myform){    
    checkResult=true;
    if (myform.userName.value==""){	;  
      checkResult=false;
      myform.userName.select();
      alert("请输入用户名称！");
      return checkResult;
    }
    if (myform.password.value==""){
      checkResult=false;
      myform.password.select();
      alert("请输入密码！");
      return checkResult;
    }
    return checkResult;
  }
  function gotoLogin(){       
    if (checkInput(formLogin)!=true){	   
       return;
    } 
	openwin(formLogin);   
     
  }
  function doLogin(){   
    if (event.keyCode == '13')
    {  
      gotoLogin();  
    }
  }
</script>
<%
  String loginResult=(String)request.getAttribute("loginResult");
  if (loginResult!=null && loginResult.length()>0){
      if(loginResult.compareTo("succeed")==0)
          {
          %>
          <script language='javascript'>
           window.open("<%=request.getContextPath()%>/main.jsp","用户管理系统1.0","width="+(screen.availwidth-10)+",height="+ (screen.availheight-30) +",top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=yes, status=no");
          </script>      
<%
   }
  }else{
    loginResult = request.getParameter("loginResult");
    if (loginResult == null)
    {
        loginResult = "&nbsp;";
    }
    else if (loginResult.compareTo("1") == 0)
    {
        loginResult = "Session过期！请重新登陆！";
    }
    
  }
%>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<form name="formLogin" method="post"  onKeyPress="doLogin();">
<table width="800" height="600" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top" background="images/image_login.jpg"><table width="100%" height="433" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td height="133">&nbsp;</td>
          </tr>
          <tr>
            <td valign="top"><table width="270" height="115" border="0" cellpadding="0" cellspacing="0">
                <tr> 
                  <td width="70" height="28"><img src="images/login_user.gif" width="56" height="28"></td>
                  <td><input name="userName" type="text" class="login_input" id="userName"></td>
                  <td>&nbsp;</td>
                </tr>
                <tr> 
                  <td width="70" height="28"><img src="images/login_password.gif" width="56" height="28"></td>
                  <td><input type="password" name="password" class="login_input"></td>
                  <td>&nbsp;</td>
                </tr>
                <tr> 
                  <td>&nbsp;</td>
                  <td><%=loginResult%></td>
                  <td width="70" height="39"> <a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('login_btn','','images/login_b2.jpg',1)"> 
                    <img onclick="gotoLogin();" src="images/login_b1.jpg" alt="请登陆！" name="login_btn" width="41" height="39" border="0" style="cursor:hand"></a></td>
                </tr>
              </table></td>
          </tr>
        </table></td>
  </tr>
</table>
</form>
</body>
</html>
