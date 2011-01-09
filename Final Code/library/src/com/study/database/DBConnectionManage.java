package com.study.database;

import java.sql.*;
import java.util.*;

public class DBConnectionManage {
	//用于设置数据库连接的缓冲池
	private Hashtable connectionpool;
    //设在最大连接数
	private int maxconnection;
    //记录当前的连接数
	private int currentconn;
	
	public DBConnectionManage() {
		init();
	}
	public static DBConnectionManage getInstance() {
		return new DBConnectionManage();
	}
	/*
	 * 初始化缓冲池，数据库最大连接数，当前的连接数
	 */
	public void init() {
		connectionpool = new Hashtable();
		maxconnection = 20;
		currentconn = 0;
		initConnection();
	}
	/*
	 * 在缓冲池connectionpool中预先添加一定数量的数据库连接，供程序访问
	 */
	public void initConnection() {
		DBConnection addconn = new DBConnection();
		for (int i = 1; i <= maxconnection / 2; i++) {
			addconn.setKey(i);
			connectionpool.put(new Integer(i), addconn);
		}
	}
	
	/*
	 * 获取DBConnection对象
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
			//System.out.println("生成Connection，封装DBConnection");
		} catch (Exception ex) {
			System.err.println("生成Connection发生错误");
		}
		return dbconn;
	}
	
	/*
	 * 获取空闲的数据库连接
	 */
	public Connection getFreeConnection() {
		Connection conn = null;
		DBConnection model = null;
		Object key;
		boolean foundconnection = false;
		for (int i = 0; i < connectionpool.size(); i++) {
			//从数据库连接池中将key全部取出
			Enumeration e = connectionpool.keys();
			while (e.hasMoreElements()) {
				key = e.nextElement();
				System.out.println(key);
				//按照key，取出数据库的连接
				
				model = (DBConnection) connectionpool.get(key);
				//获取Connection对象
				conn = model.getConnection();
				//从缓冲池中的移出Connection对象
				connectionpool.remove(key);
				//如果缓冲池中的数据库连接对象数量过少，则自动补充连接数
				while (connectionpool.size() < maxconnection / 2) {
					connectionpool.put(new Integer(getMaxkey(connectionpool) + 1).toString(),
							getConnection());
				}
				foundconnection = true;
				System.out.println("从缓冲池中成功读取Connection");
				break;
			}
		}
		//如果缓冲池中的读取失败，则另外生成一个Connection对象
		if(!foundconnection){
			//清空数据缓冲池中的连接
			release();
			//重新生成缓冲池
			initConnection();
			model = getConnection();
			conn = model.getConnection();
		}
		return conn;
	}
	
	/*
	 * 获得缓冲池中的最大的key
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
	 * 关闭数据库的连接
	 */
	public void closeConnection(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception ex){
				System.err.println("关闭连接时发生错误："+ex.getMessage());
			}
		}
	}
	
	/*
	 * 清空数据库的缓冲池数据
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
	 * 创建Statement对象,返回sql语句的执行结果
	 */
	public int executeUpdate(Connection conn,String query) throws SQLException{
		Statement st = conn.createStatement();
		
		return st.executeUpdate(query);
	}
	
	/*
	 * 创建ResultSet对象,并且sql语句的执行结果
	 */
	public ResultSet getResultSet(Connection conn,String query) throws SQLException{
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
	
	/*
	 * 关闭Statement
	 */
	public void closeStatement(Statement st) throws SQLException{
		if(st!=null){
			st.close();
		}
	}
	
	/*
	 * 关闭ResultSet对象
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
