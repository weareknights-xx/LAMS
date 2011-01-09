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
		// 根据member表中的字段，拼接SQL语句
		String query = "insert into member(memberusername,memberpassword,memberemail,memberauthority,membersign,memberphotourl,membername) "
				+ "values(?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		// 获取数据库连接池
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// 从数据库连接池中获取数据连接
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, instance.getMemberusername());
			pst.setString(2, instance.getMemberpassword());
			pst.setString(3, instance.getMemberemail());
			pst.setInt(4, instance.getMemberauthority());
			pst.setString(5, instance.getMembersign());
			pst.setString(6, instance.getMemberphotourl());
			pst.setString(7, instance.getMembername());
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


//		删除会员信息
		public boolean delMember(Member instance) {
				boolean re = false;
				// 根据Member表中的字段，拼接SQL语句
		String query = "delete from member where memberid  =?";
				Connection con = null;
				PreparedStatement pst = null;
				// 获取数据库连接池
				DBConnectionManage dbmanage = DBConnectionManage.getInstance();
				try {
					// 从数据库连接池中获取数据连接
					con = dbmanage.getFreeConnection();
					pst = con.prepareStatement(query);
					pst.setLong(1, instance.getMemberid());
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

	public Vector liskMember() {
//		 根据member表中的字段，拼接SQL语句
		String query = "select * from member ";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		Member member  = null;
//		 获取数据库连接池
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// 从数据库连接池中获取数据连接
			con = dbmanage.getFreeConnection();
			System.out.println(query);
			pst = con.prepareStatement(query);
			// 执行sql语句，并将记录集返回给ResultSet
			rs = pst.executeQuery();
			//循环ResultSet集合，并且封装Message对象
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
				// 关闭数据库连接，释放资源
				dbmanage.closeResult(rs);
				dbmanage.closeStatement(pst);
				dbmanage.closeConnection(con);
			} catch (Exception ex) {
				
			}
		}
		return list;	
	}

//	修该会员信息
	public boolean updateMember(Member instance) {
			boolean re = false;
			// 根据Member表中的字段，拼接SQL语句
			String query = "update member set memberusername = ?,";
			Connection con = null;
			PreparedStatement pst = null;
			// 获取数据库连接池
			DBConnectionManage dbmanage = DBConnectionManage.getInstance();
			try {
				// 从数据库连接池中获取数据连接
				con = dbmanage.getFreeConnection();
				pst = con.prepareStatement(query);
				pst.setString(1, instance.getMemberusername());
				pst.setString(2, instance.getMemberpassword());
	            pst.setString(3, instance.getMembername());
				pst.setString(4, instance.getMemberemail());
				pst.setInt(5, instance.getMemberauthority());
				pst.setString(6, instance.getMembersign());
				pst.setString(7, instance.getMemberphotourl());

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


	public Member validator(Member instance) {
//		 根据member表中的字段，拼接SQL语句
		String query = "select * from member where memberusername = ? and memberpassword = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		
//		 获取数据库连接池
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// 从数据库连接池中获取数据连接
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, instance.getMemberusername());
			pst.setString(2, instance.getMemberpassword());
			// 执行sql语句，并将记录集返回给ResultSet
			rs = pst.executeQuery();
			//判断数据库中是否存在对象，如果存在的话就
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
				// 关闭数据库连接，释放资源
				dbmanage.closeResult(rs);
				dbmanage.closeStatement(pst);
				dbmanage.closeConnection(con);
			} catch (Exception ex) {
				
			}
		}
		return instance;
	}


	public Member getMemberById(long memberid) {
//		 根据member表中的字段，拼接SQL语句
		String query = "select * from member where memberid = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vector list = new Vector();
		Member instance = new Member();
//		 获取数据库连接池
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		try {
			// 从数据库连接池中获取数据连接
			con = dbmanage.getFreeConnection();
			pst = con.prepareStatement(query);
			pst.setLong(1, memberid);
			// 执行sql语句，并将记录集返回给ResultSet
			rs = pst.executeQuery();
			//判断数据库中是否存在对象，如果存在的话就
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
				// 关闭数据库连接，释放资源
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
