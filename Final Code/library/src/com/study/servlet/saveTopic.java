package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.DAOFactory;
import com.study.dao.TopicDAO;
import com.study.util.DataContext;
import com.study.vo.Topic;

public class saveTopic extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public saveTopic() {
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

		boolean re = false;
		response.setContentType("text/html");
		response.setCharacterEncoding("GB18030");
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		PrintWriter out = response.getWriter();
		int topicid = Integer.parseInt(request.getParameter("topicid"));
		Topic topic = new Topic();
		
		topic.setTopicid(topicid);
		TopicDAO topicdao = DAOFactory.getTopicDAO();
		try{
			re = topicdao.delTopic(topic);
			if(re){
				out.println("<script language=javascript>alert('操作成功!');window.location.href='"+basePath+"listtopic.jsp';</script>");
			}
		}catch(Exception ex){
			
		}
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
		String type = request.getParameter("type");
		String topictitle = request.getParameter("topictitle");
		Topic topic = new Topic();
		if(topictitle==null||topictitle.length()<1){
			out.println("<script language=javascript>window.location.href='../register.jsp?err=topictitle';</script>");
			out.flush();
			out.close();
		}
		topictitle = DataContext.getDataContext(topictitle);
		topic.setTopicname(topictitle);
		TopicDAO topicdao = DAOFactory.getTopicDAO();
		if(type.equalsIgnoreCase("add")){
			try{
				re = topicdao.addTopic(topic);
				if(re){
					out.println("<script language=javascript>alert('操作成功!');window.location.href='"+basePath+"listtopic.jsp';</script>");
				}
			}catch(Exception ex){}
		}else if(type.equalsIgnoreCase("update")){
			try{
				int topicid = Integer.parseInt(request.getParameter("topicid"));
				topic.setTopicid(topicid);
				re = topicdao.updateTopic(topic);
				if(re){
					out.println("<script language=javascript>alert('操作成功!');window.location.href='"+basePath+"listtopic.jsp';</script>");
				}
			}catch(Exception ex){}
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
