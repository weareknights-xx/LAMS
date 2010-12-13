<%@page	contentType="text/html;	charset=gb2312"%>
<%@ page import="javax.servlet.http.*,com.dfkj.eoa.vo.*,com.dfkj.pm.web.LoginInfo"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>BottomFrame</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" type="text/css" href="css/Bottomframe.css">
<SCRIPT>
<!--
function BarMove_l(){
	if (AtMovePic2_l.style.display==""){
		document.all("AtMovePic2_l").style.display="none"
		document.all("AtMovePic_l").style.display=""
		document.all("frmTitle_l").style.display="none"
	}
	else{
		document.all("AtMovePic2_l").style.display=""
		document.all("AtMovePic_l").style.display="none"
		document.all("frmTitle_l").style.display=""
	}
}

function BarMove_r(){
	if (AtMovePic2_r.style.display==""){
		document.all("AtMovePic2_r").style.display="none"
		document.all("AtMovePic_r").style.display=""
		document.all("frmTitle_r").style.display="none"
		document.all("frmBlank_r").style.display=""
	}
	else{
		document.all("AtMovePic2_r").style.display=""
		document.all("AtMovePic_r").style.display="none"
		document.all("frmTitle_r").style.display=""
		document.all("frmBlank_r").style.display="none"
	}
}

-->
</SCRIPT>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll=no>

<DIV style="Z-INDEX:10">

<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
    <TR>
      <TD id=frmTree vAlign=center noWrap align=middle name="frmTree" >
	  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  	  	<TBODY>
    		<TR>
      			<TD height="100%" align=middle vAlign=top noWrap id=frmTitle_l name="frmTitle_l" >
					<table width="197" height="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="21" valign="top"><img src="images/treemenu_1.gif" width="21" height="6"></td>
							<td background="images/treemenu_2.gif" width="169"><img src="images/blank.gif" width="1" height="1"></td>
							<td width="7" valign="top"><img src="images/treemenu_3.gif" width="7" height="6"></td>
						</tr>
						<tr>
							<td height="100%" colspan="2"><IFRAME id=menu
      				style="Z-INDEX: 2; VISIBILITY: inherit; WIDTH: 190px; HEIGHT: 100%;"
      				name=menu src="MainController.do?ActionName=com.dfkj.eoa.actions.adminwork.QueryDesktopAction&NoCache=1&NextPage=/treemenu.jsp" frameBorder=0></IFRAME></td>
							<td width="7" background="images/treemenu_4.gif"><img src="images/blank.gif" width="1" height="1"></td>
						</tr>
						<tr>
							<td colspan="2" valign="bottom"><img src="images/treemenu_6.jpg" width="190" height="101"></td>
							<td width="7" valign="bottom"><img src="images/treemenu_5.jpg" width="7" height="101"></td>
						</tr>
					</table>
				</TD>
      			<TD id=AtMovePic_l style="DISPLAY: none; WIDTH: 8px; HEIGHT: 100%;" valign="middle"
    	 			name="AtMovePic_l"><a style="cursor:hand">
					<img onclick=BarMove_l() src="images/b_tree_open.gif" alt="显示菜单" name="open" width="10" height="177" border="0"></a></TD>
      			<TD id=AtMovePic2_l style="WIDTH: 8px; HEIGHT: 100%;" valign="middle"
	     			name="AtMovePic2_l"><a style="cursor:hand">
					<img onclick=BarMove_l() src="images/b_tree_close.gif" alt="隐藏菜单" name="close" width="10" height="177" border="0"></a></TD>
	 		</TR>
  		</TBODY>
	  </TABLE>
	  </TD>

      <TD id=frmRight style="WIDTH: 100%" name="frmRight">
	  <TABLE width="100%" height="99%" border=0 cellPadding=0 cellSpacing=0>
  		<TBODY>
    		<TR>
                    <TD id=AtMovePic2_r  style="WIDTH: 8px; HEIGHT: 100%;" valign="top"
	     			name="AtMovePic2_r"><a style="cursor:hand">
					<img onclick=BarMove_r() src="images/b_close.gif" alt="隐藏" name="close" width="10" height="177" border="0"></a></TD>
      			<TD id=frmTitle_r style=" WIDTH: 100%; border: 1px solid #000000" vAlign=center noWrap align=middle name="frmTitle_r"><IFRAME id=right
      				style="Z-INDEX: 2; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 100%;"
      				name=right src="<%=request.getContextPath()%>/MainController.do?ActionName=com.dfkj.eoa.actions.adminwork.QueryDesktopAction&NoCache=1&NextPage=/adminwork/mydesktop.jsp" frameborder=0></IFRAME></TD>

      			<TD id=frmBlank_r style="DISPLAY: none;">&nbsp;</TD>
      			<TD id=AtMovePic_r style="DISPLAY: none; WIDTH: 8px; HEIGHT: 100%;" valign="top"
    	 			name="AtMovePic_r"><a style="cursor:hand">
					<img onclick=BarMove_r() src="images/b_open.gif" alt="显示" name="open" width="10" height="177" border="0"></a></TD>
      							</TR>
  		</TBODY>
	  </TABLE>
	  </TD>
	 </TR>
  </TBODY>
</TABLE>
</DIV>
</body>
</html>
