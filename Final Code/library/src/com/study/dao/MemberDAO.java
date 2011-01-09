package com.study.dao;

import java.util.Vector;

import com.study.vo.*;

public interface MemberDAO {
	// ͨ��һ��Link�����޸���ϵ����Ϣ
	public boolean updateMember(Member instance);

	// �����ϵ��
	public boolean addMember(Member instance);

	// ɾ����ϵ��
	public boolean delMember(Member instance);

	// �����ϵ���б�
	public Vector liskMember();
	
	//��֤��Ա
	public Member validator(Member instance);
	
	//ͨ����ԱId�ţ���û�Ա��Ϣ
	public Member getMemberById(long memberid);
}
