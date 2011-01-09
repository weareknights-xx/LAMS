package com.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.study.database.DBConnectionManage;
import com.study.vo.Member;
import com.study.vo.Message;

public class MemberDAOImpl implements MemberDAO {

	public boolean addMember(Member instance) {
		boolean re = false;
		// ����member���е��ֶΣ�ƴ��SQL���
		String query = "insert into member(memberusername,memberpassword,memberemail,memberauthority,membersign,memberphotourl,membername) "
				+ "values(?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		// ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, instance.getMemberusername());
			pst.setString(2, instance.getMemberpassword());
			pst.setString(3, instance.getMemberemail());
			pst.setInt(4, instance.getMemberauthority());
			pst.setString(5, instance.getMembersign());
			pst.setString(6, instance.getMemberphotourl());
			pst.setString(7, instance.getMembername());
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


//		ɾ����Ա��Ϣ
		public boolean delMember(Member instance) {
				boolean re = false;
				// ����Member���е��ֶΣ�ƴ��SQL���
		String query = "delete from member where memberid  =?";
				Connection con = null;
				PreparedStatement pst = null;
				// ��ȡ���ݿ����ӳ�
				DBConnectionManage dbmanage = DBConnectionManage.getInstance();
				try {
					// �����ݿ����ӳ��л�ȡ��������
					con = dbmanage.getFreeConnection();
					pst = con.prepareStatement(query);
					pst.setLong(1, instance.getMemberid());
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

	public Vector liskMember() {
//		 ����member���е��ֶΣ�ƴ��SQL���
		String query = "select * from member ";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		Member member  = null;
//		 ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			System.out.println(query);
			pst = con.prepareStatement(query);
			// ִ��sql��䣬������¼�����ظ�ResultSet
			rs = pst.executeQuery();
			//ѭ��ResultSet���ϣ����ҷ�װMessage����
			while(rs.next()){
				member = new Member();
				member.setMemberid(rs.getLong("memberid"));
				member.setMemberusername(rs.getString("memberusername"));
				member.setMemberpassword(rs.getString("memberpassword")); 
				member.setMembername(rs.getString("membername"));
				member.setMemberauthority(rs.getInt("memberauthority"));
				member.setMemberemail(rs.getString("memberemail"));
				member.setMemberphotourl(rs.getString("memberphotourl"));
				list.add(member);
				member = null;
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

//	�޸û�Ա��Ϣ
	public boolean updateMember(Member instance) {
			boolean re = false;
			// ����Member���е��ֶΣ�ƴ��SQL���
			String query = "update member set memberusername = ?,";
			Connection con = null;
			PreparedStatement pst = null;
			// ��ȡ���ݿ����ӳ�
			DBConnectionManage dbmanage = DBConnectionManage.getInstance();
			try {
				// �����ݿ����ӳ��л�ȡ��������
				con = dbmanage.getFreeConnection();
				pst = con.prepareStatement(query);
				pst.setString(1, instance.getMemberusername());
				pst.setString(2, instance.getMemberpassword());
	            pst.setString(3, instance.getMembername());
				pst.setString(4, instance.getMemberemail());
				pst.setInt(5, instance.getMemberauthority());
				pst.setString(6, instance.getMembersign());
				pst.setString(7, instance.getMemberphotourl());

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


	public Member validator(Member instance) {
//		 ����member���е��ֶΣ�ƴ��SQL���
		String query = "select * from member where memberusername = ? and memberpassword = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		
//		 ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, instance.getMemberusername());
			pst.setString(2, instance.getMemberpassword());
			// ִ��sql��䣬������¼�����ظ�ResultSet
			rs = pst.executeQuery();
			//�ж����ݿ����Ƿ���ڶ���������ڵĻ���
			if(rs.next()){
				instance.setMemberauthority(rs.getInt("memberauthority"));
				instance.setMemberusername(rs.getString("memberusername"));
				instance.setMemberpassword(rs.getString("memberpassword"));
				instance.setMemberemail(rs.getString("memberemail"));
				instance.setMemberid(rs.getLong("memberid"));
				instance.setMemberphotourl(rs.getString("memberphotourl"));
				instance.setMemberscore(rs.getInt("memberscore"));
				instance.setMembersign(rs.getString("membersign"));
			}else{
				instance = null;
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
		return instance;
	}


	public Member getMemberById(long memberid) {
//		 ����member���е��ֶΣ�ƴ��SQL���
		String query = "select * from member where memberid = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		Member instance = new Member();
//		 ��ȡ���ݿ����ӳ�
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// �����ݿ����ӳ��л�ȡ��������
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, memberid);
			// ִ��sql��䣬������¼�����ظ�ResultSet
			rs = pst.executeQuery();
			//�ж����ݿ����Ƿ���ڶ���������ڵĻ���
			if(rs.next()){
				instance.setMemberauthority(rs.getInt("memberauthority"));
				instance.setMemberusername(rs.getString("memberusername"));
				instance.setMemberpassword(rs.getString("memberpassword"));
				instance.setMemberemail(rs.getString("memberemail"));
				instance.setMemberid(rs.getLong("memberid"));
				instance.setMemberphotourl(rs.getString("memberphotourl"));
				instance.setMemberscore(rs.getInt("memberscore"));
				instance.setMembersign(rs.getString("membersign"));
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

	public static void main(String args[]){
		MemberDAOImpl memberdao = new MemberDAOImpl();
		System.out.println(memberdao.liskMember().size());
	}

}
