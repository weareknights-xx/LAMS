package com.study.dao;

import java.util.Vector;

import com.study.vo.Member;
import com.study.vo.Message;
import com.study.vo.Topic;

public interface MessageDAO {
	// 添加信息
	public boolean addMessage(Message instance);

	// 删除信息
	public boolean delMessage(Message instance);
	
	// 通过会员对象，获得信息列表
	public Vector listMessageByMember(Member instance);
	
    // 通过发布的主题对象，获得信息列表
	public Vector listMessageByMessage(Message instance);
	
    // 通过板块信息对象，获得信息列表
	public Vector listMessageByTopic(Topic instance);
	
	// 通过信息Id号，返回信息对象
	public Message getMessageById(long messageid);
}
