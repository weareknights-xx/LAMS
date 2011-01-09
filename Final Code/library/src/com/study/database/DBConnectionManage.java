package com.study.database;

import java.sql.*;
import java.util.*;

public class DBConnectionManage {
	//�����������ݿ����ӵĻ����
	private Hashtable connectionpool;
    //�������������
	private int maxconnection;
    //��¼��ǰ��������
	private int currentconn;
	
	public DBConnectionManage() {
		init();
	}
	public static DBConnectionManage getInstance() {
		return new DBConnectionManage();
	}
	/*
	 * ��ʼ������أ����ݿ��������������ǰ��������
	 */
	public void init() {
		connectionpool = new Hashtable();
		maxconnection = 20;
		currentconn = 0;
		initConnection();
	}
	/*
	 * �ڻ����connectionpool��Ԥ�����һ�����������ݿ����ӣ����������
	 */
	public void initConnection() {
		DBConnection addconn = new DBConnection();
		for (int i = 1; i <= maxconnection / 2; i++) {
			addconn.setKey(i);
			connectionpool.put(new Integer(i), addconn);
		}
	}
	
	/*
	 * ��ȡDBConnection����
	 */
	synchronized public DBConnection getConnection() {
		DBConnection dbconn = null;
		try {
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BBS";
			String user = "sa";
			String pwd = "eclipse";
			String forName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			dbconn = new DBConnection(url, user, pwd, forName, 0);
			currentconn++;
			//System.out.println("����Connection����װDBConnection");
		} catch (Exception ex) {
			System.err.println("����Connection��������");
		}
		return dbconn;
	}
	
	/*
	 * ��ȡ���е����ݿ�����
	 */
	public Connection getFreeConnection() {
		Connection conn = null;
		DBConnection model = null;
		Object key;
		boolean foundconnection = false;
		for (int i = 0; i < connectionpool.size(); i++) {
			//�����ݿ����ӳ��н�keyȫ��ȡ��
			Enumeration e = connectionpool.keys();
			while (e.hasMoreElements()) {
				key = e.nextElement();
				System.out.println(key);
				//����key��ȡ�����ݿ������
				
				model = (DBConnection) connectionpool.get(key);
				//��ȡConnection����
				conn = model.getConnection();
				//�ӻ�����е��Ƴ�Connection����
				connectionpool.remove(key);
				//���������е����ݿ����Ӷ����������٣����Զ�����������
				while (connectionpool.size() < maxconnection / 2) {
					connectionpool.put(new Integer(getMaxkey(connectionpool) + 1).toString(),
							getConnection());
				}
				foundconnection = true;
				System.out.println("�ӻ�����гɹ���ȡConnection");
				break;
			}
		}
		//���������еĶ�ȡʧ�ܣ�����������һ��Connection����
		if(!foundconnection){
			//������ݻ�����е�����
			release();
			//�������ɻ����
			initConnection();
			model = getConnection();
			conn = model.getConnection();
		}
		return conn;
	}
	
	/*
	 * ��û�����е�����key
	 */
	private int getMaxkey(Hashtable cp) {
		int maxkey = 0;
		int tmpkey = 0;
		Enumeration e = connectionpool.keys();
		while (e.hasMoreElements()) {
			try {
				tmpkey = Integer.parseInt(e.nextElement().toString());
			} catch (Exception ex) {
				tmpkey = 0;
			}
			if (maxkey < tmpkey) {
				maxkey = tmpkey;
			}
		}
		return maxkey;
	}
	
	/*
	 * �ر����ݿ������
	 */
	public void closeConnection(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception ex){
				System.err.println("�ر�����ʱ��������"+ex.getMessage());
			}
		}
	}
	
	/*
	 * ������ݿ�Ļ��������
	 */
	public void release(){
		Enumeration e = connectionpool.elements();
		DBConnection model = null;
		Connection modelconn = null;
		while(e.hasMoreElements()){
			model = (DBConnection)e.nextElement();
			modelconn = model.getConnection();
			closeConnection(modelconn);
		}
	}
	
	/*
	 * ����Statement����,����sql����ִ�н��
	 */
	public int executeUpdate(Connection conn,String query) throws SQLException{
		Statement st = conn.createStatement();
		
		return st.executeUpdate(query);
	}
	
	/*
	 * ����ResultSet����,����sql����ִ�н��
	 */
	public ResultSet getResultSet(Connection conn,String query) throws SQLException{
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
	
	/*
	 * �ر�Statement
	 */
	public void closeStatement(Statement st) throws SQLException{
		if(st!=null){
			st.close();
		}
	}
	
	/*
	 * �ر�ResultSet����
	 */
	public void closeResult(ResultSet rs) throws SQLException{
		if(rs!=null){
			rs.close();
		}
	}
	
	public static void main(String args[]){
		DBConnectionManage dbmanage = DBConnectionManage.getInstance();
		Connection conn = dbmanage.getFreeConnection();
		ResultSet rs = null;
		String query = "select * from [student] ";
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()){
				System.out.println("true");
			}else{
				System.out.println("false");
			}
		}catch(Exception ex){
			System.err.print(ex.getLocalizedMessage());
		}finally{
			try{
				rs.close();
				stmt.close();
				dbmanage.closeConnection(conn);
			}catch(Exception ex){
				System.err.print(ex.getLocalizedMessage());
			}
		}
	}
}
