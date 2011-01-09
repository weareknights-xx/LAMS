package com.study.dao;

import java.util.Vector;

import com.study.vo.*;

public interface MemberDAO {
	// 通过一个Link对象，修改联系人信息
	public boolean updateMember(Member instance);

	// 添加联系人
	public boolean addMember(Member instance);

	// 删除联系人
	public boolean delMember(Member instance);

	// 获得联系人列表
	public Vector liskMember();
	
	//验证会员
	public Member validator(Member instance);
	
	//通过会员Id号，获得会员信息
	public Member getMemberById(long memberid);
}
