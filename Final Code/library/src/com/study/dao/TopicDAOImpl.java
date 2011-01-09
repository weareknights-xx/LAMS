package com.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.study.database.DBConnectionManage;
import com.study.vo.Member;
import com.study.vo.Message;
import com.study.vo.Topic;

public class TopicDAOImpl implements TopicDAO {

	public boolean addTopic(Topic instance) {
		boolean re = false;
		// 根据Topic表中的字段，拼接SQL语句
		String query = "insert into topic(topictitle) values(?)";
		Connection con = null;
		PreparedStatement pst = null;
		// 获取数据库连接池
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// 从数据库连接池中获取数据连接
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, instance.getTopicname());
			// 执行sql语句
			pst.executeUpdate();
			re = true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				// 关闭数据库连接，释放资源
				dbmanage.closeStatement(pst);
				dbmanage.closeConnection(con);
			} catch (Exception ex) {
			}
		}
		return re = true;
	}

	public boolean delTopic(Topic instance) {
		boolean re = false;
		// 根据Topic表中的字段，拼接SQL语句
		String query = "delete from topic where topicid = ?";
		Connection con = null;
		PreparedStatement pst = null;
		// 获取数据库连接池
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// 从数据库连接池中获取数据连接
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1,instance.getTopicid());
			// 执行sql语句
			pst.executeUpdate();
			re = true;
		} catch (Exception ex) {
		} finally {
			try {
				// 关闭数据库连接，释放资源
				dbmanage.closeStatement(pst);
				dbmanage.closeConnection(con);
			} catch (Exception ex) {
			}
		}
		return re = true;
	}

	public Vector listTopic() {
//		 根据Topic表中的字段，拼接SQL语句
		String query = "select * from [topic] ";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		Topic tmp  = null;
//		 获取数据库连接池
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// 从数据库连接池中获取数据连接
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			// 执行sql语句，并将记录集返回给ResultSet
			rs = pst.executeQuery();
			//循环ResultSet集合，并且封装Topic对象
			System.out.println(query);
			while(rs.next()){
				tmp = new Topic();
				tmp.setTopicid(rs.getInt("topicid"));
				tmp.setTopicname(rs.getString("topictitle"));
				list.add(tmp);
				tmp = null;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				// 关闭数据库连接，释放资源
				dbmanage.closeResult(rs);
				dbmanage.closeStatement(pst);
				dbmanage.closeConnection(con);
			} catch (Exception ex) {
				
			}
		}
		return list;
	}

	public boolean updateTopic(Topic instance) {
		boolean re = false;
		// 根据Topic表中的字段，拼接SQL语句
		String query = "update topic set topictitle = ? where topicid = ? ";
		Connection con = null;
		PreparedStatement pst = null;
		// 获取数据库连接池
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// 从数据库连接池中获取数据连接
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, instance.getTopicname());
			pst.setInt(2,instance.getTopicid());
			// 执行sql语句
			pst.executeUpdate();
			re = true;
		} catch (Exception ex) {
		} finally {
			try {
				// 关闭数据库连接，释放资源
				dbmanage.closeStatement(pst);
				dbmanage.closeConnection(con);
			} catch (Exception ex) {
			}
		}
		return re = true;
	}
	public static void main(String args[]){
		TopicDAOImpl t = new TopicDAOImpl();
		Topic topic = null;
		topic = t.getTopicById(1);
		System.out.println(topic.getTopicname());
	}
	public Topic getTopicById(int topicid) {
//		 根据member表中的字段，拼接SQL语句
		String query = "select * from topic where topicid = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Topic instance = new Topic();
//		 获取数据库连接池
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// 从数据库连接池中获取数据连接
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, topicid);
			// 执行sql语句，并将记录集返回给ResultSet
			rs = pst.executeQuery();
			//判断数据库中是否存在对象，如果存在的话就
			if(rs.next()){
				instance.setTopicid(rs.getInt("topicid"));
				instance.setTopicname(rs.getString("topictitle"));
			}else{
				instance = null;
			}
		} catch (Exception ex) {
		} finally {
			try {
				// 关闭数据库连接，释放资源
				dbmanage.closeResult(rs);
				dbmanage.closeStatement(pst);
				dbmanage.closeConnection(con);
			} catch (Exception ex) {
				
			}
		}
		return instance;	
	}
}
