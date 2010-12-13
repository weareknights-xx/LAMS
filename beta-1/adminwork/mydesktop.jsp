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

String cApproveLeave = "";
try {
	cApproveLeave = (String)request.getAttribute("sApproveLeave");
} catch(Exception e)	 {
   
}

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
<title>我的办公桌面</title>
<meta http-equiv="Content-Type" content="text/html;charset=GBK">
<meta http-equiv="refresh" content="30,url=<%=request.getContextPath()%>/adminwork/transfer_mydesktop.jsp">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mydesktopstyle.css">
</head>
<script language="JavaScript" type="text/JavaScript">
<!--
function openwin_detail(id){
  document.location.href = "<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.actions.infogarden.ViewEoaBulletinAction&NoCache=1&NextPage=/infogarden/bulletin/eoa_bulletin_detail.jsp&bulletinId="+id+"&desktop=1";
}

function  setReadMark(id)
{
	  formList.action="<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.actions.adminwork.SetReadAction&NoCache=1&NextPage=/adminwork/transfer_mydesktop_1.jsp&curMessageId="+id;
	  formList.submit();
}

function approveLeave()
{
      formList.action="<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.actions.humaninfo.QueryEoaApproveLeaveAction&NextPage=/humaninfo/eoa_leave_approve.jsp&pageSize=15&pageNumber=1";
	  formList.submit();
}
-->

</script>
<body>
<form name="formList" method="post" action="">
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title_table">
    <tr> 
      <td>我的办公桌面[<%=userDescription%>]</td>
    </tr>
    <tr>
      <td><img src="<%=request.getContextPath()%>/images/table_title.jpg" width="206" height="10"></td>
    </tr>
  </table>
  <br>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td width="40"><img src="<%=request.getContextPath()%>/images/mydesk_task.gif" width="33" height="33"></td>
            <td width="948" valign="middle"><strong>待办</strong><strong>事项</strong></td>
          </tr>
          <tr> 
            <td colspan="2"><img src="<%=request.getContextPath()%>/images/line.gif" width="249" height="10"></td>
          </tr>
          <tr> 
            <td colspan="2"><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="mydesk_table">
                <% try{
					while(iCalendar.hasNext()){
					value = (EoaMessagesVO) iCalendar.next();
					NoOfTask ++ ;
			  %>
                <tr> 
                  <td width="5%">&nbsp;</td>
                  <td><a href="javascript:setReadMark(<%=value.getMessageId()%>)"><%=StringUtil.nullToHtmlSpace(value.getDescription())%></a></td>
                </tr>
                <%
				}
				}catch(Exception e)
					{
						e.printStackTrace();
					}
			  %>
			<%  if(cApproveLeave != null && cApproveLeave.length() > 0 && !cApproveLeave.equals("0") )  { %>
                <tr> 
                  <td width="5%">&nbsp;</td>
                  <td><a href="javascript:approveLeave()">请假审批 :当前有<%=cApproveLeave%>条信息</a></td>
                </tr>			
			<% } %>			  
                <tr> 
                  <td width="5%">&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
              </table></td>
          </tr>
        </table>
	</td>
  </tr>
  <tr>
    <td>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td width="40"><img src="<%=request.getContextPath()%>/images/mydesk_file.gif" width="33" height="33"></td>
            <td width="948" valign="middle"><strong>公告列表</strong></td>
          </tr>
          <tr> 
            <td colspan="2"><img src="<%=request.getContextPath()%>/images/line.gif" width="249" height="10"></td>
          </tr>
          <tr> 
            <td colspan="2"><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="mydesk_table">
                <% try{
				while(iBulletin.hasNext()){
				bulletinVO = (EoaBulletinVO)iBulletin.next();
			%>
                <tr>
                  <td width="40">&nbsp;</td>
                  <td><a href="javascript:openwin_detail('<%=bulletinVO.getBulletinId()%>')"><font size="+1"><%=bulletinVO.getBTitle()%></font></a><em><font color="#0033FF"> (发布人：<%=bulletinVO.getSenderName()%>，发布时间：<%=bulletinVO.getSendTime()%>)</a></font></em> </td>
                </tr>
                <%
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			%>
              </table></td>
          </tr>
        </table>
	</td>
  </tr>
  <tr>
    <td>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td width="40"><img src="<%=request.getContextPath()%>/images/mydesk_mail.gif" width="33" height="33"></td>
            <td width="96%" valign="middle"><strong>内部邮件</strong></td>
          </tr>
          <tr> 
            <td colspan="2"><img src="<%=request.getContextPath()%>/images/line.gif" width="249" height="10"></td>
          </tr>
          <tr> 
            <td colspan="2"> <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="mydesk_table">
                <tr> 
                  <td width="5%">&nbsp;</td>
                  <td><a href="./MainController.do?ActionName=com.dfkj.eoa.actions.officework.FindMailListAction&NextPage=/officework/eoa_mail_list.jsp">收件箱</a><font color="#FF0000" ><%=displayCount%></font></td>
                </tr>
                <tr> 
                  <td width="5%">&nbsp;</td>
                  <td><a href="./MainController.do?ActionName=com.dfkj.eoa.actions.officework.PrepareSendMailAction&NextPage=/officework/eoa_mail_send.jsp">发邮件</a></td>
                </tr>
              </table></td>
          </tr>
        </table>
	</td>
  </tr>
  <tr>
    <td>
		<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td width="40"><img src="<%=request.getContextPath()%>/images/mydesk_online.gif" width="33" height="33"></td>
            <td width="948" valign="middle"><strong>在线人员</strong></td>
          </tr>
          <tr> 
            <td colspan="2"><img src="<%=request.getContextPath()%>/images/line.gif" width="249" height="10"></td>
          </tr>
          <tr> 
            <td colspan="2"> <table width="95%" border="0" align="center" cellspacing="0" cellpadding="0" class="mydesk_table">
                <%
					  	try{ int iCol = 0;
							while(iOnLine.hasNext()){
								puserVO = (PUserVO) iOnLine.next();
								if (iCol % 4 == 0) 
								{
									  out.println("<tr>");
									  out.println("<td width=\"5%\">&nbsp;</td>");
									  out.println("<td>" + StringUtil.nullToHtmlSpace(puserVO.getUserDescription())+ "</td>");
								 }
								 else 
								 {
									  out.println("<td>" + StringUtil.nullToHtmlSpace(puserVO.getUserDescription())+ "</td>");
								 }
								if (iCol % 4 == 3) 
								{
									  out.println("</tr>");
								}
								iCol++; 
							}
						}catch(Exception e)
							{
								e.printStackTrace();
							}
					  %>
              </table></td>
          </tr>
        </table>
	</td>
  </tr>
</table>
</form>
<%
if(((String)session.getAttribute("Msg"))=="None"&&(NoOfTask!=0))
{
	out.println("<embed src=/EOFFICE/other/EventNotify.wav loop=false autostart=FALSE hidden=true></embed>");
	
}
session.setAttribute("Msg","Done");
%>
</body>
</html>
