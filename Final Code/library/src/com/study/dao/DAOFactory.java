package com.study.dao;
import com.study.dao.*;//导入dao包
import com.study.vo.*;//导入vo包
public class DAOFactory 
{
   //通过静态方法，获取MemberDAO对象
	  public static MemberDAO getMemberDAO()
{
   //MemberDAO是一个接口，引用MemberDAOImpl对象，这样的做法可以屏蔽
   //所有的操作细节
		MemberDAO memberdao = new MemberDAOImpl();
		return memberdao;
	 }
  //通过静态方法，获取LinkDAO对象
  public static MessageDAO getMessageDAO ()
{
   // MessageDAO是一个接口，引用MessageDAO Impl对象
   //这样的做法可以屏蔽所有的操作细节
		MessageDAO messagedao = new MessageDAOImpl();
		return messagedao;
	 }
  public static TopicDAO getTopicDAO(){
	  TopicDAO td = new TopicDAOImpl();
	  
	  return td;
  }
}
