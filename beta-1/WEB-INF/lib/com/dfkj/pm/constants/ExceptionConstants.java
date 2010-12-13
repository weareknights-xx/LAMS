
package com.dfkj.pm.constants;


public class ExceptionConstants {
    /*pm部分所用到的出错信息*/
    public final static String CANNOT_DEL_ADMIN = "不能够删除管理员用户或者管理员角色";
    public final static String CANNOT_UPDATE_ADMINROLE = "不能够修改内置管理员角色";
    public final static String CANNOT_CHANGE_ADMIN = "不能够修改内置管理员账号";
    public final static String CANNOT_DEL_ADMINROLE = "不能够删除内置管理员角色";
    public final static String HAVENOT_CHOOSEN_POPEDOM = "您没有选择权限";
    
    //登陆失败信息
    public final static String CANNOT_LOGIN = "您输入了错误的用户账号或者密码";
    //登陆用户被禁用的信息
    public final static String USER_DISABLED = "您的账号被禁用了!";  
    
    /*使用STATEMENT过程中部分所用到的出错信息*/
    public final static String CREATE_STATEMENT_ERROR = "数据库创建SQL错误:";
    public final static String STATEMENT_EXCUTE_ERROR = "数据库执行SQL错误:";
    public final static String STATEMENT_CLOSE_ERROR = "关闭数据库SQL错误: ";
   
    /*所用的类没有找到的错误信息*/
    public final static String CLASSCREATEERROR = "创建类失败";
    
    /*数据库方面的错误信息*/
    //获取数据库连接失败
    public final static String GET_CONNECTION_ERROR = "获得数据库链接失败"; 
    //设置事务失败
    public final static String SET_COMMIT_ERROR = "设置事务失败!";
 
}
