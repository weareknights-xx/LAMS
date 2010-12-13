
package com.dfkj.pm.constants;

public class ECConstants {
    
    
    public final static String TARGETPAGE="0";
    public final static String TARGETCLASS="1";
    
    public final static String LISTSCHEMA = "schemas";
    public final static String SCHEMAUSER = "username";
    public final static String SCHEMAUSERDESCRIPTION = "userdescription";
    public final static String CURSCHEMANAME = "currentschemaname";
    public final static String CURSCHEMADESC = "currentschemadesc";
    
    /*登陆信息*/
    //获得用户信息的SQL语句
    public final static String GETUSERINFO = "SELECT a.user_name user_name ,a.user_description user_description ,a.admin admin ,a.region_id region_id ,b.region_name region_name,b.type region_type,b.region_code region_code FROM p_user a , ec_region b WHERE b.region_id(+) = a.region_id and user_name = ";
   /*登陆信息 结束*/
    
    /
    //
    
}
