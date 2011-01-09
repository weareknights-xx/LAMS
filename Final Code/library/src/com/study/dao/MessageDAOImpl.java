package com.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.study.database.DBConnectionManage;
import com.study.vo.Message;
import com.study.vo.Topic;
import com.study.vo.Member;

public class MessageDAOImpl implements MessageDAO {

	public boolean addMessage(Message instance) {
		boolean re = false;
		// ����member���е��ֶΣ�ƴ��SQL���
		String query = "insert into message(messagetitle,messagecontent,messagedate,messagetype,messagememberid,messageparentid,messagetopicid) "
				+ "values(?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		// ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, instance.getMessagetitle());
			pst.setString(2, instance.getMessagecontent());
			pst.setDate(3, instance.getMessagedate());
			pst.setInt(4, instance.getMessagetype());
			pst.setLong(5, instance.getMessagememberid());
			pst.setLong(6, instance.getMessageparentid());
			pst.setInt(7, instance.getMessagetopicid());
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

	public boolean delMessage(Message instance) {
		boolean re = false;
		// ����member���е��ֶΣ�ƴ��SQL���
		String query = "delete from message where messageid = ?";
		Connection con = null;
		PreparedStatement pst = null;
		// ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, instance.getMessageid());
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

	public Vector liskMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector listMessageByMember(Member instance) {
//		 ����member���е��ֶΣ�ƴ��SQL���
		String query = "select * from message where messagememberid = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		Message tmp  = null;
//		 ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, instance.getMemberid());
			// ִ��sql��䣬������¼�����ظ�ResultSet
			rs = pst.executeQuery();
			//ѭ��ResultSet���ϣ����ҷ�װMessage����
			while(rs.next()){
				tmp = new Message();
				tmp.setMessageid(rs.getLong("messageid"));
				tmp.setMessagedate(rs.getDate("Messagedate"));
				tmp.setMessagecontent(rs.getString("messagecontent"));
				tmp.setMessagememberid(rs.getInt("messagememberid"));
				tmp.setMessageparentid(rs.getLong("messageparentid"));
				tmp.setMessagetitle(rs.getString("messagetitle"));
				tmp.setMessagetopicid(rs.getInt("messagetopicid"));
				tmp.setMessagetype(rs.getInt("messagetype"));
				list.add(tmp);
				tmp = null;
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
		return list;
	}

	public Vector listMessageByMessage(Message instance) {
//		 ����member���е��ֶΣ�ƴ��SQL���
		String query = "select * from message m,member mb where m.messagememberid = mb.memberid and m.messageparentid = ? order by m.messagetype";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		Message tmp  = null;
		Member membertmp = null;
		MemberDAO memberdao = DAOFactory.getMemberDAO();
//		 ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, instance.getMessageid());
			// ִ��sql��䣬������¼�����ظ�ResultSet
			rs = pst.executeQuery();
			//ѭ��ResultSet���ϣ����ҷ�װMessage����
			while(rs.next()){
				tmp = new Message();
				tmp.setMessageid(rs.getLong("messageid"));
				tmp.setMessagetitle(rs.getString("messagetitle"));
				tmp.setMessagecontent(rs.getString("messagecontent"));
				tmp.setMessagedate(rs.getDate("Messagedate"));
				tmp.setMessagetype(rs.getInt("messagetype"));
				membertmp = memberdao.getMemberById(rs.getLong("messagememberid"));
				if(membertmp!=null){
					tmp.setMember(membertmp);
				}
				tmp.setMessageparentid(rs.getLong("messageparentid"));
				tmp.setMessagetopicid(rs.getInt("messagetopicid"));
				
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

	public Vector listMessageByTopic(Topic instance) {
//		 ����message���е��ֶΣ�ƴ��SQL���
		String query = "select * from message m,member mb where m.messagememberid = mb.memberid and m.messagetopicid = ? and m.messagetype = 0 ";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		Message tmp  = null;
		Member membertmp = null;
//		 ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		MemberDAO memberdao = DAOFactory.getMemberDAO();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, instance.getTopicid());
			// ִ��sql��䣬������¼�����ظ�ResultSet
			rs = pst.executeQuery();
			//ѭ��ResultSet���ϣ����ҷ�װMessage����
			while(rs.next()){
				tmp = new Message();
				tmp.setMessageid(rs.getLong("messageid"));
				tmp.setMessagetitle(rs.getString("messagetitle"));
				tmp.setMessagecontent(rs.getString("messagecontent"));
				tmp.setMessagedate(rs.getDate("Messagedate"));
				tmp.setMessagetype(rs.getInt("messagetype"));
				membertmp = memberdao.getMemberById(rs.getLong("messagememberid"));
				if(membertmp!=null){
					tmp.setMember(membertmp);
				}
				tmp.setMessageparentid(rs.getLong("messageparentid"));
				tmp.setMessagetopicid(rs.getInt("messagetopicid"));
				
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
	
	

	public Message getMessageById(long messageid) {
//		 ����message���е��ֶΣ�ƴ��SQL���
		String query = "select * from message where messageid = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Message instance = null;
		Member membertmp = null;
//		 ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		MemberDAO memberdao = DAOFactory.getMemberDAO();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, messageid);
			// ִ��sql��䣬������¼�����ظ�ResultSet
			rs = pst.executeQuery();
			//ѭ��ResultSet���ϣ����ҷ�װMessage����
			while(rs.next()){
				instance = new Message();
				instance.setMessageid(rs.getLong("messageid"));
				instance.setMessagetitle(rs.getString("messagetitle"));
				instance.setMessagecontent(rs.getString("messagecontent"));
				instance.setMessagedate(rs.getDate("Messagedate"));
				instance.setMessagetype(rs.getInt("messagetype"));
				membertmp = memberdao.getMemberById(rs.getLong("messagememberid"));
				if(membertmp!=null){
					instance.setMember(membertmp);
				}
				instance.setMessageparentid(rs.getLong("messageparentid"));
				instance.setMessagetopicid(rs.getInt("messagetopicid"));
				
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
	public static void main(String args[]){
		MessageDAOImpl md = new MessageDAOImpl();
		Message m = new Message();
		m.setMessageid(1);
		Vector v = md.listMessageByMessage(m);
		System.out.println(v.size());
	}
}

