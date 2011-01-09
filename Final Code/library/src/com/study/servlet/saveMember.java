package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.util.DataContext;
import com.study.vo.Member;
import com.study.dao.*;

public class saveMember extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public saveMember() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		if(username==null||username.length()<1){
			out.println("<script language=javascript>window.location.href='../register.jsp?err=username';</script>");
			out.flush();
			out.close();
		}
		if(password==null||password.length()<1){
			out.println("<script language=javascript>window.location.href='../register.jsp?err=password';</script>");
			out.flush();
			out.close();
		}
		if(email==null||email.length()<1){
			out.println("<script language=javascript>window.location.href='../register.jsp?err=email';</script>");
			out.flush();
			out.close();
		}
		if(name==null||name.length()<1){
			out.println("<script language=javascript>window.location.href='../register.jsp?err=name';</script>");
			out.flush();
			out.close();
		}
		username = DataContext.getDataContext(username);
		password = DataContext.getDataContext(password);
		email = DataContext.getDataContext(email);
		name = DataContext.getDataContext(name);
		Member member = new Member();
		member.setMemberauthority(2);
		member.setMemberemail(email);
		member.setMembername(name);
		member.setMemberpassword(password);
		member.setMemberphotourl("");
		member.setMembersign("");
		member.setMemberusername(username);
		MemberDAO memberdao = DAOFactory.getMemberDAO();
		try{
			re = memberdao.addMember(member);
			if(re){
				out.println("<script language=javascript>alert('十分感谢您的注册。');window.location.href='"+basePath+"main.jsp';</script>");
			}
		}catch(Exception ex){
			
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
