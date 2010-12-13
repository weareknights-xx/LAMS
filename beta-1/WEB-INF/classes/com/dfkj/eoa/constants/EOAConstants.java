package com.dfkj.eoa.constants;

import java.util.Vector;
import java.sql.*;
import com.dfkj.db.DbManager;

public class EOAConstants {

	
	
	public final static String GETALLSCHEMA = "select * from eoa_schema";
	//����Session�е�Schema���ϱ������û����û�����
	public final static String LISTSCHEMA = "schemas";
	public final static String SCHEMAUSER = "username";
	public final static String SCHEMAUSERDESCRIPTION = "userdescription";
	public final static String CURSCHEMANAME = "currentschemaname";
	public final static String CURSCHEMADESC = "currentschemadesc";

	public final static String ORDERBYREGIONCODE = " ORDER BY region_code ";
	
	
	public final static String[][] ARRAYBULLETINSERVERITY = { { "0", "��" }, {
			"1", "�е�" }, {
			"2", "��" }, {
			"3", "�ǳ���" }, {
			"4", "����" }, {
			"5", "����" }
	};

	
	private static final String[] ALL = { "ALL","����" };
	public static final String GENERAL_DONE = "ִ�гɹ�";
	public static final String GENERAL_ERR = "ִ��ʧ��";

	public static final String ADD_DONE = "��ӳɹ�";
	public static final String ADD_ERR = "���ʧ��";

	public static final String UPDATE_DONE = "���³ɹ�";
	public static final String UPDATE_ERR = "����ʧ��";

	public static final String DELETE_DONE = "ɾ���ɹ�";
	public static final String DELETE_ERR = "ɾ��ʧ��";

	
	public static final String DELETE_SELECTED_DONE = "ɾ���ɹ�";
	public static final String DELETE_SELECTED_ERR = "ɾ��ʧ��";

	public static final String FIND_PK_DONE = "��ѯ�ɹ�";
	public static final String FIND_PK_ERR = "��ѯʧ��";

	public static final String FIND_ALL_DONE = "��ѯȫ���ɹ�";
	public static final String FIND_ALL_ERR = "��ѯȫ��ʧ��";

	public static final String FIND_PAGE_DONE = "��ҳ��ѯ�ɹ�";
	public static final String FIND_PAGE_ERR = "��ҳ��ѯʧ��";

	public static final String FIND_CONDITION_DONE = "������ѯ�ɹ�";
	public static final String FIND_CONDITION_ERR = "������ѯʧ��";
			
	

}
