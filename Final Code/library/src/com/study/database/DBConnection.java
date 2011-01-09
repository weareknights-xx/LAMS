package com.study.database;

import java.sql.*;
import com.microsoft.*;
import com.microsoft.jdbc.*;
public class DBConnection {
	private String url;
	private String user;
	private String pwd;
	private String forName;
	private Connection connection;
	private int key;
	
	/**
	 * @返回key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param 设置key
	 */
	public void setKey(int key) {
		this.key = key;
	}

	public DBConnection(String url, String user, String pwd, String forName,int key) {
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.forName = forName;
		this.key = key;
		connection = getConnectionInstance();
	}
	
	public DBConnection(){
		
	}
	/**
	 * @返回 forName
	 */
	public String getForName() {
		return forName;
	}
	/**
	 * @param 设置forName
	 */
	public void setForName(String forName) {
		this.forName = forName;
	}
	/**
	 * @return 返回pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param 设置pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return 返回url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param 设置url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return 返回usr
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param 设置usr
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return 返回 connection
	 */
	public Connection getConnection() {
		return connection;
	}
	/**
	 * @param 设置 connection
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	/**
	 * @param 依靠数据库连接字符串，用户名，密码获得一个connection对象
	 */
	public Connection getConnectionInstance(){
		try{
			Class.forName(forName).newInstance();
			connection = DriverManager.getConnection(url, user, pwd);
		}catch(Exception ex){
			
		}
		return connection;
	}
	
}
