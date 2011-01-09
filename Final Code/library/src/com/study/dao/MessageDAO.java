package com.study.dao;

import java.util.Vector;

import com.study.vo.Member;
import com.study.vo.Message;
import com.study.vo.Topic;

public interface MessageDAO {
	// �����Ϣ
	public boolean addMessage(Message instance);

	// ɾ����Ϣ
	public boolean delMessage(Message instance);
	
	// ͨ����Ա���󣬻����Ϣ�б�
	public Vector listMessageByMember(Member instance);
	
    // ͨ��������������󣬻����Ϣ�б�
	public Vector listMessageByMessage(Message instance);
	
    // ͨ�������Ϣ���󣬻����Ϣ�б�
	public Vector listMessageByTopic(Topic instance);
	
	// ͨ����ϢId�ţ�������Ϣ����
	public Message getMessageById(long messageid);
}
