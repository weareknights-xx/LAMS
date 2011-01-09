package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.*;
import com.study.vo.*;
import com.study.util.*;

public class saveMessage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public saveMessage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean re = false;
		response.setContentType("text/html");
		response.setCharacterEncoding("GB18030");
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		PrintWriter out = response.getWriter();
		String messagetitle = request.getParameter("messagetitle");
		String messagecontent = request.getParameter("messagecontent");
		
		long memberid = 0;
		messagetitle = DataContext.getDataContext(messagetitle);
		messagecontent = DataContext.getDataContext(messagecontent);
		try{
			memberid = Long.parseLong(request.getParameter("memberid"));
		}catch(Exception ex){
			out.println("<script language=javascript>window.location.href='../issue.jsp?err=memberid';</script>");
			out.flush();
			out.close();
		}
		String type = request.getParameter("type");
		
		
		if(type.equalsIgnoreCase("issue")){
			int topicid = 0;
			try{
				topicid = Integer.parseInt(request.getParameter("topicid"));
			}catch(Exception ex){
				out.println("<script language=javascript>alert('参数传递失败！');window.location.href='../issue.jsp?err=memberid';</script>");
				out.flush();
				out.close();
			}
			if(messagetitle==null||messagetitle.length()<1){
				out.println("<script language=javascript>window.location.href='../issue.jsp?err=username';</script>");
				out.flush();
				out.close();
			}
			if(messagecontent==null||messagecontent.length()<1){
				out.println("<script language=javascript>window.location.href='../issue.jsp?err=password';</script>");
				out.flush();
				out.close();
			}
			Message message = new Message();
			message.setMessagetitle(messagetitle);
			message.setMessagecontent(messagecontent);
			message.setMessageid(memberid);
			//message.setMessagedate(DataContext.getCurrentDate());
			message.setMessagetype(0);
			message.setMessageparentid(0);
			message.setMessagetopicid(topicid);
			MessageDAO messagedao = DAOFactory.getMessageDAO();
			try{
				re = messagedao.addMessage(message);
				if(re){
					out.println("<script language=javascript>alert('操作成功！');window.location.href='list.jsp?topicid="+topicid+"';</script>");
				}
			}catch(Exception ex){
				
			}
			out.flush();
			out.close();
		}else if(type.equalsIgnoreCase("reply")){
			long messageid = 0;
			try{
				messageid = Long.parseLong(request.getParameter("messageid"));
			}catch(Exception ex){
				out.println("<script language=javascript>alert('参数传递失败！');window.location.href='../reply.jsp?err=messageid';</script>");
				out.flush();
				out.close();
			}
			if(messagetitle==null||messagetitle.length()<1){
				out.println("<script language=javascript>window.location.href='../issue.jsp?err=messagetitle';</script>");
				out.flush();
				out.close();
			}
			if(messagecontent==null||messagecontent.length()<1){
				out.println("<script language=javascript>window.location.href='../issue.jsp?err=messagecontent';</script>");
				out.flush();
				out.close();
			}
			messagetitle = DataContext.getDataContext(messagetitle);
			messagecontent = DataContext.getDataContext(messagecontent);
			Message message = new Message();
			message.setMessagetitle(messagetitle);
			message.setMessagecontent(messagecontent);
			message.setMessageid(memberid);
			//message.setMessagedate(DataContext.getCurrentDate());
			message.setMessagetype(1);
			message.setMessageparentid(messageid);
			MessageDAO messagedao = DAOFactory.getMessageDAO();
			Message parentmessage = messagedao.getMessageById(messageid);
			message.setMessagetopicid(parentmessage.getMessagetopicid());
			try{
				re = messagedao.addMessage(message);
				if(re){
					out.println("<script language=javascript>alert('操作成功！');window.location.href='listMessage.jsp?topicid="+messageid+"';</script>");
				}
			}catch(Exception ex){
				
			}
			out.flush();
			out.close();			
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
