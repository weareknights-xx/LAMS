package com.study.dao;
import com.study.dao.*;//����dao��
import com.study.vo.*;//����vo��
public class DAOFactory 
{
   //ͨ����̬��������ȡMemberDAO����
	  public static MemberDAO getMemberDAO()
{
   //MemberDAO��һ���ӿڣ�����MemberDAOImpl����������������������
   //���еĲ���ϸ��
		MemberDAO memberdao = new MemberDAOImpl();
		return memberdao;
	 }
  //ͨ����̬��������ȡLinkDAO����
  public static MessageDAO getMessageDAO ()
{
   // MessageDAO��һ���ӿڣ�����MessageDAO Impl����
   //���������������������еĲ���ϸ��
		MessageDAO messagedao = new MessageDAOImpl();
		return messagedao;
	 }
  public static TopicDAO getTopicDAO(){
	  TopicDAO td = new TopicDAOImpl();
	  
	  return td;
  }
}
