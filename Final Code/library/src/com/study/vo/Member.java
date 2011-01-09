package com.study.vo;

public class Member {
	private long memberid;
	private String memberusername;
	private String memberpassword;
	private int memberauthority;
	private String membername;
	private String memberemail;
	private String memberphotourl;
	private int memberscore;
	private String membersign;
	public Member(){
		memberid = 0;
		memberscore = 0;
		memberauthority = 0;
	}
	/**
	 * @return the memberauthority
	 */
	public int getMemberauthority() {
		return memberauthority;
	}
	/**
	 * @param memberauthority the memberauthority to set
	 */
	public void setMemberauthority(int memberauthority) {
		this.memberauthority = memberauthority;
	}
	/**
	 * @return the memberemail
	 */
	public String getMemberemail() {
		return memberemail;
	}
	/**
	 * @param memberemail the memberemail to set
	 */
	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}
	/**
	 * @return the memberid
	 */
	public long getMemberid() {
		return memberid;
	}
	/**
	 * @param memberid the memberid to set
	 */
	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}
	/**
	 * @return the membername
	 */
	public String getMembername() {
		return membername;
	}
	/**
	 * @param membername the membername to set
	 */
	public void setMembername(String membername) {
		this.membername = membername;
	}
	/**
	 * @return the memberpassword
	 */
	public String getMemberpassword() {
		return memberpassword;
	}
	/**
	 * @param memberpassword the memberpassword to set
	 */
	public void setMemberpassword(String memberpassword) {
		this.memberpassword = memberpassword;
	}
	/**
	 * @return the memberphotourl
	 */
	public String getMemberphotourl() {
		return memberphotourl;
	}
	/**
	 * @param memberphotourl the memberphotourl to set
	 */
	public void setMemberphotourl(String memberphotourl) {
		this.memberphotourl = memberphotourl;
	}
	/**
	 * @return the memberscore
	 */
	public int getMemberscore() {
		return memberscore;
	}
	/**
	 * @param memberscore the memberscore to set
	 */
	public void setMemberscore(int memberscore) {
		this.memberscore = memberscore;
	}
	/**
	 * @return the membersign
	 */
	public String getMembersign() {
		return membersign;
	}
	/**
	 * @param membersign the membersign to set
	 */
	public void setMembersign(String membersign) {
		this.membersign = membersign;
	}
	/**
	 * @return the memberusername
	 */
	public String getMemberusername() {
		return memberusername;
	}
	/**
	 * @param memberusername the memberusername to set
	 */
	public void setMemberusername(String memberusername) {
		this.memberusername = memberusername;
	}
}
