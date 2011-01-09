package com.study.dao;
import java.util.Vector;

import com.study.vo.Member;
import com.study.vo.Message;
import com.study.vo.Topic;
public interface TopicDAO {
	// ��Ӱ����Ϣ
	public boolean addTopic(Topic instance);

	// ɾ�������Ϣ
	public boolean delTopic(Topic instance);
	
    // �޸ð����Ϣ
	public boolean updateTopic(Topic instance);
	
	// ��ѯ�����Ϣ
	public Vector listTopic();
	
	// ͨ��Id�Ż�ȡ�����Ϣ
	public Topic getTopicById(int topicid);
}
