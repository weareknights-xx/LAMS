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
		// ����Topic���е��ֶΣ�ƴ��SQL���
		String query = "insert into topic(topictitle) values(?)";
		Connection con = null;
		PreparedStatement pst = null;
		// ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, instance.getTopicname());
			// ִ��sql���
			pst.executeUpdate();
			re = true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				// �ر����ݿ����ӣ��ͷ���Դ
				dbmanage.closeStatement(pst);
				dbmanage.closeConnection(con);
			} catch (Exception ex) {
			}
		}
		return re = true;
	}

	public boolean delTopic(Topic instance) {
		boolean re = false;
		// ����Topic���е��ֶΣ�ƴ��SQL���
		String query = "delete from topic where topicid = ?";
		Connection con = null;
		PreparedStatement pst = null;
		// ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1,instance.getTopicid());
			// ִ��sql���
			pst.executeUpdate();
			re = true;
		} catch (Exception ex) {
		} finally {
			try {
				// �ر����ݿ����ӣ��ͷ���Դ
				dbmanage.closeStatement(pst);
				dbmanage.closeConnection(con);
			} catch (Exception ex) {
			}
		}
		return re = true;
	}

	public Vector listTopic() {
//		 ����Topic���е��ֶΣ�ƴ��SQL���
		String query = "select * from [topic] ";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		Topic tmp  = null;
//		 ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			// ִ��sql��䣬������¼�����ظ�ResultSet
			rs = pst.executeQuery();
			//ѭ��ResultSet���ϣ����ҷ�װTopic����
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
				// �ر����ݿ����ӣ��ͷ���Դ
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
		// ����Topic���е��ֶΣ�ƴ��SQL���
		String query = "update topic set topictitle = ? where topicid = ? ";
		Connection con = null;
		PreparedStatement pst = null;
		// ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, instance.getTopicname());
			pst.setInt(2,instance.getTopicid());
			// ִ��sql���
			pst.executeUpdate();
			re = true;
		} catch (Exception ex) {
		} finally {
			try {
				// �ر����ݿ����ӣ��ͷ���Դ
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
//		 ����member���е��ֶΣ�ƴ��SQL���
		String query = "select * from topic where topicid = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Topic instance = new Topic();
//		 ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, topicid);
			// ִ��sql��䣬������¼�����ظ�ResultSet
			rs = pst.executeQuery();
			//�ж����ݿ����Ƿ���ڶ���������ڵĻ���
			if(rs.next()){
				instance.setTopicid(rs.getInt("topicid"));
				instance.setTopicname(rs.getString("topictitle"));
			}else{
				instance = null;
			}
		} catch (Exception ex) {
		} finally {
			try {
				// �ر����ݿ����ӣ��ͷ���Դ
				dbmanage.closeResult(rs);
				dbmanage.closeStatement(pst);
				dbmanage.closeConnection(con);
			} catch (Exception ex) {
				
			}
		}
		return instance;	
	}
}
