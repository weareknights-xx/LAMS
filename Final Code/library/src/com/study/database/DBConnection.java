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
	 * @����key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param ����key
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
	 * @���� forName
	 */
	public String getForName() {
		return forName;
	}
	/**
	 * @param ����forName
	 */
	public void setForName(String forName) {
		this.forName = forName;
	}
	/**
	 * @return ����pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param ����pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return ����url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param ����url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return ����usr
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param ����usr
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return ���� connection
	 */
	public Connection getConnection() {
		return connection;
	}
	/**
	 * @param ���� connection
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	/**
	 * @param �������ݿ������ַ������û�����������һ��connection����
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
