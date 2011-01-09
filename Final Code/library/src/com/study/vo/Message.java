package com.study.vo;

import java.sql.Date;

public class Message {
	private long messageid;
	private String messagetitle;
	private String messagecontent;
	private Date messagedate;
	private int messagetype;
	private long messagememberid;
	private long messageparentid;
	private int messagetopicid;
	private Member member;
	
	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}
	/**
	 * @param member the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}
	public Message(){
		
	}
	/**
	 * @return the messagecontent
	 */
	public String getMessagecontent() {
		return messagecontent;
	}
	/**
	 * @param messagecontent the messagecontent to set
	 */
	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}
	/**
	 * @return the messagedate
	 */
	public Date getMessagedate() {
		return messagedate;
	}
	/**
	 * @param messagedate the messagedate to set
	 */
	public void setMessagedate(Date messagedate) {
		this.messagedate = messagedate;
	}
	/**
	 * @return the messageid
	 */
	public long getMessageid() {
		return messageid;
	}
	/**
	 * @param messageid the messageid to set
	 */
	public void setMessageid(long messageid) {
		this.messageid = messageid;
	}
	/**
	 * @return the messagememberid
	 */
	public long getMessagememberid() {
		return messagememberid;
	}
	/**
	 * @param messagememberid the messagememberid to set
	 */
	public void setMessagememberid(long messagememberid) {
		this.messagememberid = messagememberid;
	}
	/**
	 * @return the messageparentid
	 */
	public long getMessageparentid() {
		return messageparentid;
	}
	/**
	 * @param messageparentid the messageparentid to set
	 */
	public void setMessageparentid(long messageparentid) {
		this.messageparentid = messageparentid;
	}
	/**
	 * @return the messagetitle
	 */
	public String getMessagetitle() {
		return messagetitle;
	}
	/**
	 * @param messagetitle the messagetitle to set
	 */
	public void setMessagetitle(String messagetitle) {
		this.messagetitle = messagetitle;
	}
	/**
	 * @return the messagetopicid
	 */
	public int getMessagetopicid() {
		return messagetopicid;
	}
	/**
	 * @param messagetopicid the messagetopicid to set
	 */
	public void setMessagetopicid(int messagetopicid) {
		this.messagetopicid = messagetopicid;
	}
	/**
	 * @return the messagetype
	 */
	public int getMessagetype() {
		return messagetype;
	}
	/**
	 * @param messagetype the messagetype to set
	 */
	public void setMessagetype(int messagetype) {
		this.messagetype = messagetype;
	}
}
