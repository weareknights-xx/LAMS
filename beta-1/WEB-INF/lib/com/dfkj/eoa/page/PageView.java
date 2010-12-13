
package com.dfkj.eoa.page;


import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;


/** 
  * ͨ��JSP���ã�����ҳ������ʾ��WEBҳ�档
  * ��֧��ͼƬ����ť�ȣ�ֻ֧�����֡�
  * �÷�:
  * ��JSPҳ�水������ʽ����:
  * <% PageView view = new PageView(request,out,page); %>
  * ��ȱʡ��ʽ��ʾ
  * <% view.setVisible(true); %>
  * ��ָ����ʽ��ʾ
  * <% view.setVisible(true,0,1); %>
  */
public class PageView {
	/**
	 * ��ǰҳ���URL
	 */
	private String currentUrl;
	/**
	 * ���
	 */
	private String style;
	/**
	 * ��"��һҳ"�����Ƿ����"["��"]"
	 */
	private boolean useSquareBrackets;
	/**
	 * �ͻ�������
	 */
	private HttpServletRequest request;
	/**
	 * ҳ���������
	 */
	private JspWriter out;
	/**
	 * WEBҳ��
	 */
	private Page page;

	/**
	 * ������,����һ����ҳ����
	 * @param: request �ͻ�������
	 * @param: out ҳ���������
	 * @param: page WEBҳ��
	 */
	public PageView(HttpServletRequest request, JspWriter out, Page page) {
		this.request = request;
		this.out = out;
		currentUrl = request.getRequestURL().toString();
		this.page = page;
	}

	/**
	 * ��ʾһ���ж�����
	 */
	private void viewTotal() throws IOException {
		out.print("�ܼ�¼��:" + page.getTotal() + "&nbsp;");
	}
	/**
	 * ��ʾһ���ж���ҳ
	 */
	private void viewTotalPage() throws IOException {
		out.print("��ҳ����:" + page.getTotalPage() + "&nbsp;");
	}
	/**
	 * ��ʾ��ǰ�ǵڼ�ҳ
	 */
	private void viewCurrentPage() throws IOException {
		out.print("��ǰҳ��:" + page.getCurrentPageNumber() + "&nbsp;");
	}
	/**
	 * ��ʾ��ǰ�ǵڼ�ҳ/һ���ж���ҳ
	 */
	private void viewTotalAndCurrent() throws IOException {
		out.print(
			page.getCurrentPageNumber()
				+ "&nbsp;/&nbsp;"
				+ page.getTotalPage()
				+ "&nbsp;");
	}
	/**
	 * ��ʾÿҳ�ж�����
	 */
	private void viewPageSize() throws IOException {
		out.print("ÿҳ:" + page.getPageSize() + "&nbsp;");
	}
	/**
	 * ��ʾ��ҳ
	 */
	private void viewFirstPage() throws IOException {
		if (useSquareBrackets) {
			out.print("[");
		}
		out.print(
			"<a href=\""
				+ currentUrl
				+ "?pageNumber=1"
				+ getParamsFromCurrentURL(request, "pageNumber")
				+ "\">");
		out.print("��һҳ</a>");
		if (useSquareBrackets) {
			out.print("]");
		}
		out.print("&nbsp;\n");
	}
	/**
	 * ��ʾ��һҳ
	 */
	private void viewPreviousPage() throws IOException {
		if (useSquareBrackets) {
			out.print("[");
		}
		if (page.hasPreviousPage()) {
			out.print(
				"<a href=\""
					+ currentUrl
					+ "?pageNumber="
					+ page.getPreviousPageNumber()
					+ getParamsFromCurrentURL(request, "pageNumber")
					+ "\">");
		}
		out.print("��һҳ");
		if (page.hasPreviousPage()) {
			out.print("</a>");
		}
		if (useSquareBrackets) {
			out.print("]");
		}
		out.print("&nbsp;\n");
	}
	/**
	 * ��ʾ��һҳ
	 */
	private void viewNextPage() throws IOException {
		if (useSquareBrackets) {
			out.print("[");
		}
		if (page.hasNextPage()) {
			out.print(
				"<a href=\""
					+ currentUrl
					+ "?pageNumber="
					+ page.getNextPageNumber()
					+ getParamsFromCurrentURL(request, "pageNumber")
					+ "\">");
		}
		out.print("��һҳ");
		if (page.hasNextPage()) {
			out.print("</a>");
		}
		if (useSquareBrackets) {
			out.print("]");
		}
		out.print("&nbsp;\n");
	}
	/**
	 * ��ʾβҳ
	 */
	private void viewLastPage() throws IOException {
		if (useSquareBrackets) {
			out.print("[");
		}
		out.print(
			"<a href=\""
				+ currentUrl
				+ "?pageNumber="
				+ page.getTotalPage()
				+ getParamsFromCurrentURL(request, "pageNumber")
				+ "\">");
		out.print("��ĩҳ");
		out.print("</a>");
		if (useSquareBrackets) {
			out.print("]");
		}
		out.print("&nbsp;\n");
	}
	/**
	 * ��ʾת���ڼ�ҳ
	 */
	private void viewGotoPage() throws IOException {
		out.println(
			"��"
				+ "<SELECT name=\"jumpPage\" onchange=\"JumpingPage('self',this,0)\">");
		for (int i = 1; i <= page.getTotalPage(); i++) {
			if (i == page.getCurrentPageNumber()) {
				out.println(
					"&nbsp;&nbsp;<OPTION selected value="
						+ i
						+ ">"
						+ i
						+ "</OPTION>");
			} else {
				out.println(
					"&nbsp;&nbsp;<OPTION value=" + i + ">" + i + "</OPTION>");
			}
		}
		out.println("</SELECT>");
		//����javascript����JumpingPage()
		out.println("<SCRIPT LANGUAGE=\"JavaScript\">");
		out.println("function JumpingPage(targ,selObj,restore){");
		out.println(
			"  eval(targ+\".location.href='"
				+ currentUrl
				+ "?pageNumber=\"+selObj.options[selObj.selectedIndex].value+\""
				+ getParamsFromCurrentURL(request, "pageNumber")
				+ "'\");");
		out.println("  if (restore) selObj.selectedIndex=0;");
		out.println("  return ;");
		out.println("}");
		out.println("</SCRIPT>");
	}

	/**
	 * ��URL�л�ȡ����
	 * @param: request �ͻ�������
	 * @param: exceptionParamNames �ų�����Ĳ���
	 * Modifier YKD
	 * Note : remove new line character at request paras
	 */
	private static String getParamsFromCurrentURL(
		HttpServletRequest request,
		String exceptionParamNames) {
			
		String params = "";
		Enumeration e = request.getParameterNames();
		outer : while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			StringTokenizer st = new StringTokenizer(exceptionParamNames, ",");
			while (st.hasMoreTokens()) {
				String exceptionName = st.nextToken();
				if (key.equals(exceptionName)) {
					continue outer;
				}
			}
			if(key.compareTo("fileContent")==0)
						continue;
			if(key.compareTo("Body")==0)
							continue;				
			if(key.compareTo("documentContent")==0)
							continue;					
			String value = request.getParameter(key);
			//check para, if para contains a newline character
			if(value.length()>0){
				params += "&" + key + "=" + chopAtWord(value);
			}
		}
		return params;
		//return "&"+request.getQueryString();	
	}
	//For get Ref Url Usage 
	//Added by ykd
	//
	private static String getParamsFromCurrentURL(
		HttpServletRequest request) {
		String params = "returnReferFlag=1";
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = request.getParameter(key);
			//check para, if para contains a newline character
			//lijc add temp
			if(key.compareTo("fileContent")==0)
				continue;
			if(key.compareTo("Body")==0)
						continue;	
			if(key.compareTo("documentContent")==0)
							continue;	
			if(value.length()>0){
				params += "&" + key + "=" + chopAtWord(value);
			}
		}
		return params;	
	}
	
	/**
	 * @param string
	 * @return
	 */
	public static final String chopAtWord(String string) {
		if (string == null) {
			return "";
		}

		char [] charArray = string.toCharArray();
		int sLength = string.length();
	
		// First check if there is a newline character before length; if so,
		// chop word there.
		for (int i=0; i<sLength-1; i++) {
			// Windows
			if (charArray[i] == '\r' && charArray[i+1] == '\n') {
			     //return string.substring(0, i+1);
				 return string.substring(0, i);
			}
			// Unix
			else if (charArray[i] == '\n') {
				return string.substring(0, i);
			}
		}
		// Also check boundary case of Unix newline
		if (charArray[sLength-1] == '\n') {
			return string.substring(0, sLength-1);
		}

        //finally then
        return string;
	}

	
	/**GET REFER URL
	 * ADD BY YKD
	 * @param request
	 * @return
	 */
	private static String getReferURL(HttpServletRequest request){
	   String referURL = "";
	   String ContextPath=request.getContextPath();
	   String ServletPath=request.getServletPath();
	   String QueryString=request.getQueryString();
	   if(QueryString == null || (QueryString.trim()).length()==0){
	   referURL=ContextPath+ServletPath;
	   }else{
	   referURL=ContextPath+ServletPath+"?"+QueryString;
	   }
	   return referURL;
	}
	
	
	public static String getCurrentURL(HttpServletRequest request) {
		return request.getRequestURL().toString()+ "?"+getParamsFromCurrentURL(request);
	}
	
	

	/**
	 * ��ȱʡ��ʽ��ʾ��ҳ����,���visibleΪtrue,����ʾ��ҳ����,
	 * ����,����ʾ��ҳ����
	 * @param: visible ��ʾ����
	 */
	public void setVisible(boolean visible) {
		if (visible) {
			viewPage(false, 0, 0);
		}
	}

	/**
	 * ��ָ����ʽ��ʾ��ҳ����,���visibleΪtrue,����ʾ��ҳ����,
	 * ����,����ʾ��ҳ����
	 * @param: visible ��ʾ����
	 * @param: style ���
	 * @param: order ��ʾ˳��
	 */
	public void setVisible(boolean visible, int style, int order) {
		if (visible) {
			viewPage(false, style, order);
		}
	}

	/**
	 * ��ָ����ʽ��ʾ��ҳ����,���visibleΪtrue,����ʾ��ҳ����,
	 * ����,����ʾ��ҳ����
	 * @param: visible ��ʾ����
	 * @param: useSquareBrackets �Ƿ����"["��"]"�Ŀ���
	 * @param: style ���
	 * @param: order ��ʾ˳��
	 */
	public void setVisible(
		boolean visible,
		boolean useSquareBrackets,
		int style,
		int order) {
		if (visible) {
			viewPage(useSquareBrackets, style, order);
		}
	}

	/**
	 * ��ָ����ʽ��ʾ��ҳ����
	 * @param: useSquareBrackets �Ƿ����"["��"]"�Ŀ���
	 * @param: style ���
	 * @param: order ��ʾ˳��
	 * orderΪ0,
	 * ��ʾ������ʽ,������˳����ʾ:
	 * ����:18 ��ҳ:2 ��ǰҳ:1 ÿҳ:10 ��ҳ ǰҳ ��ҳ βҳ ת����������
	 * orderΪ1,
	 * ��ʾ�����ʽ,������˳����ʾ:
	 * ǰҳ ��ҳ βҳ 1/2
	 * orderΪ2,
	 * ��ʾ������ʽ2,������˳����ʾ:
	 * ����:18 ÿҳ:10 ת���������� ��ҳ ǰҳ ��ҳ βҳ 1/2
	 */
	private void viewPage(boolean useSquareBrackets, int style, int order) {
		this.useSquareBrackets = useSquareBrackets;
		if (style == 0) {
			this.style = "";
		} else {
			if (style > 0 && style < 3) {
				this.style = "_STYLE" + Integer.toString(style);
			} else {
				this.style = "";
			}
		}
		try {
			switch (order) {
				case 1 :
					viewFirstPage();
					viewPreviousPage();
					viewNextPage();
					viewLastPage();
					viewTotalAndCurrent();
					break;
				case 2 :
					viewTotal();
					viewPageSize();
					viewGotoPage();
					viewFirstPage();
					viewPreviousPage();
					viewNextPage();
					viewLastPage();
					viewTotalAndCurrent();
					break;
				default :
					viewTotal();
					viewTotalPage();
					viewCurrentPage();
					viewPageSize();
					viewFirstPage();
					viewPreviousPage();
					viewNextPage();
					viewLastPage();
					viewGotoPage();
					break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}