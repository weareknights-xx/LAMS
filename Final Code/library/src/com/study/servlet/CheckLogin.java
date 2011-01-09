package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.dao.*;
import com.study.vo.*;
import com.study.util.*;

public class CheckLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckLogin() {
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

		response.setContentType("text/html");
		response.setCharacterEncoding("GB18030");
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		PrintWriter out = response.getWriter();
		Member member = new Member();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null||username.length()<1){
			out.println("<script language=javascript>window.location.href='../login.jsp?err=username';</script>");
			out.flush();
			out.close();
		}
		if(password==null||password.length()<1){
			out.println("<script language=javascript>window.location.href='../login.jsp?err=password';</script>");
			out.flush();
			out.close();
		}
		username = DataContext.getDataContext(username);
		password = DataContext.getDataContext(password);
		member.setMemberusername(username);
		member.setMemberpassword(password);
		MemberDAO dao = DAOFactory.getMemberDAO();
		member = dao.validator(member);
		HttpSession session = request.getSession();
		if(member!=null){
			
			session.setAttribute("bbsmember", member);
			out.println("<script language=javascript>window.location.href='../main.jsp';</script>");
		}else{
			out.println("<script language=javascript>window.location.href='../login.jsp?err=invalidate';</script>");
			out.flush();
			out.close();
		}
		out.flush();
		out.close();
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
