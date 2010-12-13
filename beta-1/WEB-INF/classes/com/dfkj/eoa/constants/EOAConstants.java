package com.dfkj.eoa.constants;

import java.util.Vector;
import java.sql.*;
import com.dfkj.db.DbManager;

public class EOAConstants {

	
	
	public final static String GETALLSCHEMA = "select * from eoa_schema";
	//存入Session中的Schema集合别名及用户名用户描述
	public final static String LISTSCHEMA = "schemas";
	public final static String SCHEMAUSER = "username";
	public final static String SCHEMAUSERDESCRIPTION = "userdescription";
	public final static String CURSCHEMANAME = "currentschemaname";
	public final static String CURSCHEMADESC = "currentschemadesc";

	public final static String ORDERBYREGIONCODE = " ORDER BY region_code ";
	
	
	public final static String[][] ARRAYBULLETINSERVERITY = { { "0", "低" }, {
			"1", "中等" }, {
			"2", "高" }, {
			"3", "非常高" }, {
			"4", "紧急" }, {
			"5", "其他" }
	};

	
	private static final String[] ALL = { "ALL","所有" };
	public static final String GENERAL_DONE = "执行成功";
	public static final String GENERAL_ERR = "执行失败";

	public static final String ADD_DONE = "添加成功";
	public static final String ADD_ERR = "添加失败";

	public static final String UPDATE_DONE = "更新成功";
	public static final String UPDATE_ERR = "更新失败";

	public static final String DELETE_DONE = "删除成功";
	public static final String DELETE_ERR = "删除失败";

	
	public static final String DELETE_SELECTED_DONE = "删除成功";
	public static final String DELETE_SELECTED_ERR = "删除失败";

	public static final String FIND_PK_DONE = "查询成功";
	public static final String FIND_PK_ERR = "查询失败";

	public static final String FIND_ALL_DONE = "查询全部成功";
	public static final String FIND_ALL_ERR = "查询全部失败";

	public static final String FIND_PAGE_DONE = "分页查询成功";
	public static final String FIND_PAGE_ERR = "分页查询失败";

	public static final String FIND_CONDITION_DONE = "条件查询成功";
	public static final String FIND_CONDITION_ERR = "条件查询失败";
			
	

}
