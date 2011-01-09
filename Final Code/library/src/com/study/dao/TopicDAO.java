package com.study.dao;
import java.util.Vector;

import com.study.vo.Member;
import com.study.vo.Message;
import com.study.vo.Topic;
public interface TopicDAO {
	// 添加板块信息
	public boolean addTopic(Topic instance);

	// 删除板块信息
	public boolean delTopic(Topic instance);
	
    // 修该板块信息
	public boolean updateTopic(Topic instance);
	
	// 查询板块信息
	public Vector listTopic();
	
	// 通过Id号获取板块信息
	public Topic getTopicById(int topicid);
}
