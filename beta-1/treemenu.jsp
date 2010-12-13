<%@page import="com.dfkj.eoa.business.eoaTreeBuilder"%>
<%@ page contentType="text/html;charset=GBK" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="com.dfkj.eoa.vo.*" %>
<%@ page import="java.util.*" %> 
<%@ page import="com.dfkj.utilities.*"%>
<%@ page import = "com.dfkj.data.DaoUtil"%>
<%@ page import = "com.dfkj.pm.web.*"%>
<%
LoginInfo loginInfo =(LoginInfo)request.getSession().getAttribute(com.dfkj.constants.Constants.LOGINFOBEAN);
String userName = loginInfo.getUserName();
String userDescription = loginInfo.getUserDescription();
Collection calendarCollection = null;
try {
	calendarCollection =(Collection)request.getAttribute("calendarCollection");
} catch(Exception e) {
	System.out.println("取Collection calendarCollection 错误");
}

Collection onLineCollection = null;
try {
	onLineCollection =(Collection)request.getAttribute("onLineCollection");
} catch(Exception e) {
	System.out.println("取Collection onLineCollection 错误");
}
String sCountMail = "";
String displayCount = "";
try {
	sCountMail = (String)request.getAttribute("countMail");
} catch(Exception e) {
	System.out.println("取countMail 错误");
}
if (sCountMail.trim().equals("0")) 
	displayCount ="";
else
	displayCount ="(" + sCountMail +" 封新邮件)";

Iterator iCalendar = null;
Iterator iOnLine = null;
int NoOfTask = 0;

boolean bFlag = false;
if(calendarCollection!=null&&!calendarCollection.isEmpty())
{
	iCalendar = calendarCollection.iterator();
	bFlag = true;
}
if(onLineCollection!=null&&!onLineCollection.isEmpty())
{
	iOnLine = onLineCollection.iterator();
	bFlag = true;
}

EoaMessagesVO value = null;
PUserVO puserVO = null;

///////////取收到的公告列表/////////////////
Iterator iBulletin = null;
EoaBulletinVO bulletinVO = null;
Collection bulletinCollection = null;
try {
	bulletinCollection =(Collection)request.getAttribute("bulletinCollection");
} catch(Exception e) {
	System.out.println("取Collection bulletinCollection 错误");
}

if(bulletinCollection!=null&&!bulletinCollection.isEmpty())
{
	iBulletin = bulletinCollection.iterator();
	bFlag = true;
}

//////////////////////////////////////////
%>
<html>
<head>
<style>
<!--
#foldheader{cursor:hand ; font-weight:normal ;
list-style-image:     url(images/fold.gif)}
#foldinglist{list-style-image:    url(images/list.gif)}
#treeroot{list-style-image:  url(images/treeroot.gif)}
//-->
</style>
<script language="JavaScript1.2">
<!--


var head="display:''"
img1=new Image()
img1.src="images/fold.gif"
img2=new Image()
img2.src="images/open.gif"

function barmove_r(){
    parent.document.all("AtMovePic2_r").style.display=""
    parent.document.all("AtMovePic_r").style.display="none"
    parent.document.all("frmTitle_r").style.display=""
    parent.document.all("frmBlank_r").style.display="none"
}

function change(){
if(!document.all)
return
if (event.srcElement.id=="foldheader") {
var srcIndex = event.srcElement.sourceIndex
var nested = document.all[srcIndex+1]
if (nested.style.display=="none") {
nested.style.display=''
event.srcElement.style.listStyleImage="url(images/open.gif)"
}
else {
nested.style.display="none"
event.srcElement.style.listStyleImage="url(images/fold.gif)"
}
    parent.document.all("AtMovePic2_r").style.display="none"
    parent.document.all("AtMovePic_r").style.display=""
    parent.document.all("frmTitle_r").style.display="none"
    parent.document.all("frmBlank_r").style.display=""
}
}

document.onclick=change

-->
</script>
<title>树形菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta http-equiv="refresh" content="300,url=<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.actions.adminwork.QueryDesktopAction&NoCache=1&NextPage=/treemenu.jsp">
<link rel="stylesheet" type="text/css" href="css/leftmenu.css">
</head>




<body bgcolor="#FFFFFF" background="images/treemenu_7.jpg" topmargin="0" style="background-repeat: repeat-x; background-attachment: fixed;">
<table width="300px">
<% 
  eoaTreeBuilder eoatreebuilder = new eoaTreeBuilder();
%>
<% 
  out.print(eoatreebuilder.getTree(request));
  eoatreebuilder.closeConnection();
  eoatreebuilder = null;
%>
</table>


<script language="JavaScript1.2">
<!--

function get_cookie(Name) {
	var search = Name + "="
	var returnvalue = "";
	if (document.cookie.length > 0) {
	offset = document.cookie.indexOf(search)

	if (offset != -1) { 
	offset += search.length

	end = document.cookie.indexOf(";", offset);

	if (end == -1) end = document.cookie.length;
	returnvalue=unescape(document.cookie.substring(offset, end))
	}
	}
	return returnvalue;
	}

	if (get_cookie(window.location.pathname) != ''){
	var openresults=get_cookie(window.location.pathname).split(" ")
	for (i=0 ; i < openresults.length ; i++){
	foldinglist[openresults[i]].style.display=''
	document.all[foldinglist[openresults[i]].sourceIndex -
	1].style.listStyleImage="url(images/open.gif)"
	}
	}

	if (document.all){
	var nodelength=foldinglist.length-1
	var nodes=new Array(nodelength)
	var openones=''
}

function check(){
for (i=0 ; i <= nodelength ; i++){
if (foldinglist[i].style.display=='')
openones=openones + " " + i
}
document.cookie=window.location.pathname+"="+openones
}

if (document.all)
document.body.onunload=check

</script>

<% try{
					while(iCalendar.hasNext()){
					value = (EoaMessagesVO) iCalendar.next();
					NoOfTask ++ ;
				}
				}catch(Exception e)
					{
						e.printStackTrace();
					}
if((NoOfTask>0)&&(((String)session.getAttribute("Msg"))=="Done"))out.println("<script language='javaScript'>alert('您有新的事务.');</script>");
%>

</body>
</html>
