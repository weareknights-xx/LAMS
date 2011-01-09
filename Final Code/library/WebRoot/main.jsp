<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图书馆助理管理系统</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>

<body><%@ include file = "header.jsp" %><table width="830"  border="0" bgcolor="#999999" height="53">
      <tr>
        <td width="17%" height="23" class="style1"><br /></td>
        <td width="11%" class="style1">&nbsp;<a href="person_ta.jsp" target=_blank>个人信息</a><td>
        <td width="11%" class="style1">新闻动态<br /></td>
        <td width="15%" class="style1">&nbsp;&nbsp;&nbsp; <a href="search.jsp" target=_blank>排班查询</a></td>
        <td width="16%" class="style1">&nbsp;&nbsp;&nbsp; 个人排班<br /></td>
        <td width="12%" class="style1"><a href="bbsmessage.jsp" target=_blank>留言板</a></td>
        <TD class="style1"><a href="adminta.jsp" target=_blank>助理管理</a></TD>
        </tr>
    </table><br /><table width="835" border="0" bgcolor="#ffffff" height="187" style="height: 187px;">
<tbody><tr>

</tr>
<tr>
<td><br /><table width="120"  border="0" height="385">
          <tr>
            <td height="24" colspan="2">校内连接<br /></td>
            </tr>
          <tr>
            <td width="19%" height="22">&nbsp;</td>
            <td width="81%">东校区图书馆</td>
          </tr>
          <tr>
            <td height="22">&nbsp;</td>
            <td>南校区图书馆<br /></td>
          </tr>
          <tr>
            <td height="22">&nbsp;</td>
            <td>北校区图书馆<br /></td>
          </tr>
          <tr>
            <td height="22">&nbsp;</td>
            <td>珠海校区图书馆<br /></td>
          </tr>
          <tr>
            <td height="22">&nbsp;</td>
            <td><a href="www.sysu.edu.com.cn" title="中山大学">中山大学</a></td>
          </tr>
          <tr>
            <td height="22">&nbsp;</td>
            <td><br /></td>
          </tr>
		  <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td height="23" colspan="2">校外友情链接</td>
            </tr>
          <tr>
            <td height="22">&nbsp;</td>
            <td>大学城</td>
          </tr>
          <tr>
            <td height="22">&nbsp;</td>
            <td>铁路信息查询</td>
          </tr>
		  <tr>
            <td height="22">&nbsp;</td>
            <td>天气查询</td>
          </tr>
		  <tr>
            <td height="22">&nbsp;</td>
            <td>教育网<br /></td>
          </tr>
		  <tr>
            <td height="22">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
		  <tr>
            <td height="22">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
<td>          欢迎访问图书馆助理管理系统</td></tr>
</tbody></table><form id="form1" name="form1" method="post" action="./servlet/CheckLogin" onsubmit="return checkForm();"><table align=center width="1000" border="0" cellspacing="0" cellpadding="2"></table>  
     
      </tr>
    </table></td>
  </tr>
</table>
</form>
<%@ include file = "bottom.jsp"%><br /><br />
</body>
</html>
