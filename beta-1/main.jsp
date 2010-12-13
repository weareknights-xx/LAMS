<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=GBK" language="java" import="java.sql.*" errorPage="" %>
<%session.setAttribute("Msg","None");%>
<html>
<head>
<title>图书馆助理管理系统1.0</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="css/mainstyle.css">
<SCRIPT language=JavaScript1.2 src="js/fw_menu.js"></SCRIPT>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);

</script>
<script language="JavaScript">
<!--
function exitWindows(){
window.open("LogoutController.do?ActionName=com.dfkj.pm.actions.LogoutAction&NoCache=1&NextPage=/logout.jsp");
}
function Max()
{
var str='<object id=maxwin type="application/x-oleobject" classid="clsid:adb880a6-d8ff-11cf-9377-00aa003b7a11"><param name="Command" value="MAXIMIZE"></object>';
if(!document.getElementById("maxwin"))
document.body.insertAdjacentHTML("BeforeEnd",str);
maxwin.Click();
}
function Min()
{
var str='<object id=minwin type="application/x-oleobject" classid="clsid:adb880a6-d8ff-11cf-9377-00aa003b7a11"><param name="Command" value="MINIMIZE"></object>';
if(!document.getElementById("minwin"))
document.body.insertAdjacentHTML("BeforeEnd",str);
minwin.Click();
}

function SessionRelease(){
document.location.href=('<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.common.LogoutEepAction');
window.setTimeout("window.close();",5);
}

function openAbout(){
	window.open('about.htm','a','height=312,width=460,resizable=no,scrollbars=no,status=no,toolbar=no,menubar=no,location=no');
}

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
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="writeMenus(); MM_preloadImages('images/b_orange.gif')" scroll=no onunload="exitWindows()">
<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" >
  <tr> 
    <td width="255"><img src="images/top_1.jpg" width="255" height="31"></td>
    <td background="images/top_2.jpg">&nbsp;</td>
    <td background="images/top_2.jpg" width="45">&nbsp;
		
	</td>
  </tr>
</table>
<table width="100%" height="22" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="292" valign="top"><img src="images/top_4.jpg" width="292" height="22"></td>
    <td background="images/top_5.jpg"><img src="images/blank.gif" width="1" height="1"></td>
	<td width="25"><img src="images/top_3.jpg" width="25" height="22"></td>
	<td background="images/top_6.jpg" width="66"><img src="images/b_orange.gif" name="b_1" width="10" height="10" border="0"></td>
	<td background="images/top_6.jpg" width="88"><img src="images/b_orange.gif" name="b_2" width="10" height="10" border="0"></td>
	<td background="images/top_6.jpg" width="70"><img src="images/b_orange.gif" name="b_3" width="10" height="10" border="0"></td>
	<td background="images/top_6.jpg" width="69"><img src="images/b_orange.gif" name="b_4" width="10" height="10" border="0"></td>
	<td background="images/top_6.jpg" width="55"><img src="images/b_orange.gif" name="b_5" width="10" height="10" border="0"></td>
	<td background="images/top_6.jpg" width="55"><img src="images/b_orange.gif" name="b_6" width="10" height="10" border="0"></td>
	
  </tr>
</table>
<table width="100%" height="18" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="140"><img src="images/top_7.jpg" width="140" height="18"></td>
    <td background="images/top_10.jpg"><img src="images/blank.gif" width="1" height="1"></td>
    <td width="25"><img src="images/top_8.jpg" width="25" height="18"></td>
    <td width="403" background="images/top_9.jpg">&nbsp;</td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="0" cellspacing="0">
     <tr> 
         <td> 
           
			<iframe frameborder="0" id="frmrigh" name="main" src="Bottomframe.jsp" scroll="auto" width="100%" height="100%" style="visibility: inherit"> 
           
			</iframe> 
            
		</td>
     </tr>
</table>
</body>
</html>
