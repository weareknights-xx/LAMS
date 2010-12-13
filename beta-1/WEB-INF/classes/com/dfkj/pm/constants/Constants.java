
package com.dfkj.pm.constants;


public class Constants {
    /*********************************固定全局常量**********************************************/
    //固定的Administrator账号名称
    public static final String ADMIN_USERNAME="Administrator";
    //固定的Administrator角色名称
    public static final String ADMIN_ROLENAME="Administrator";
    //登录后生成的用户信息Bean
    public static final String LOGINFOBEAN="LogInfo";
    //创建用户bean的类名
    public static final String LOGINFO = "com.dfkj.pm.business.LogInfoImp";
    //全局Properties文件的存放路径
    public static final String PROPFILEPATH = "/PropFiles/"; 
    //树结构的初始Schema
    public static final String ORIGINALSCHEMA = "1";
    
    /*****************************pm块所用到的静态常量******************************************/
    /********pm块所需要用到的SQL语句*******/
    //删除角色所用的SQL语句
    public static final String DELETEROLE="DELETE FROM p_role_popedom WHERE role_name=";
    //修改用户权限时需要删除所有用户权限所使用的SQL语句(或者删除用户时使用)
    public static final String PMUR_DELALL = "DELETE FROM p_user_role WHERE user_name = ";
    //修改权限对应用户时需要删除所有权限用户使用的SQL语句
    public static final String PMRU_DELALL = "DELETE FROM p_user_role WHERE role_name = ";
    //查询用户所拥有的角色
    public static final String FINDUSERROLE = "SELECT a.popedom_name popedom_name , a.popedom_alias popedom_alias , a.popedom_type popedom_type ,a.popedom_sort popedom_sort,a.popedom_action popedom_action  from p_popedom a,p_user_role b where a.popedom_name = b.role_name and b.user_name ="; 
    //查询当前用户所拥有的权限的SQL
    public static final String FINDUSERPOPEDOM = "SELECT user_name,popedom_name FROM p_user_popedom_view WHERE user_name = "; 
    
    
    
    
    /***pm块所需存放到Session中的属性名称***/
    //查询所有用户的结果存放到Session中的attribute名称
    public static final String PM_LISTUSER = "ListUser";
    //查询得到所需进行修改操作的用户信息存放入Session中的attribute名称
    public static final String PM_USERDETAIL = "UserDetail";
    //查询得到所需进行修改操作的角色信息存放入Session中的attribute名称
    public static final String PM_ROLEDETAIL = "RoleDetail";
    //查询所有该用户当前role的结果存放到Session中的attribute名称
    public static final String PM_LISTUSERROLE = "ListUserRole";
    //查询所有Role的结果存放到Session中的attribute名称
    public static final String PM_LISTROLE = "ListRole";
    //查询当前Role所包含的所有权限的结果存放到Session中的attribute名称
    public static final String PM_LISTROLEPOPEDOM = "ListRolePopedom";
    //查询得到所有的权限结果存放到Session中的attribute名称
    public static final String PM_LISTPOPEDOM = "ListPopedom";
    
    /***pm块所需要在前后台间传递的参数列表***/
    //取得用户名和密码的常量
    public static final String USERNAME="username";
    public static final String PASSWORD="password";
    //创建、修改、删除用户时所用到的传入参数名称
    public static final String PMD_USERNAME = "userName";
    public static final String PMD_USERDESCRIPTION = "userDescription";
    public static final String PMD_REGIONID = "regionID";
    public static final String PMD_PASSWORD = "password";
    public static final String PMD_USERENABLED = "userEnabled";
    public static final String PMD_ADMIN = "admin";
    //创建、修改用户时所需要读取Region，region信息存放到Session中的名称
    public static final String REGION = "region";
    //创建、修改、删除用户权限时所用到的参数名称
    public static final String PMUR_USERNAME = "userName";
    public static final String PMUR_USERDESCRIPTION ="userDescription" ;
    public static final String PMUR_ROLENAME = "rolename";
    public static final String PMUR_ROLES = "roles";
    //创建、修改、删除角色对应用户所用到的参数名称
    public static final String PMRU_USERS = "users";
    public static final String PMRU_ROLENAME = "rolename";
    public static final String PMRU_ROLEALIAS = "rolealias";
    //创建、修改、删除Role时所用到的传入参数名称
    public static final String PMR_ROLENAME = "rolename";
    public static final String PMR_ROLEALIAS = "rolealias";
    public static final String PMR_ROLETYPE = "roletype";
    public static final String PMR_ROLESORT = "rolesort";
    public static final String PMR_ROLEACTION = "roleaction";
    public static final String PMR_POPEDOMS = "popedoms";
    public static final String PMR_POPEDOM = "popedom";
    
    /**********pm块所需要的其他常量**********/
    //权限类型
    public static final String TYPEROLE="R";
    public static final String TYPEADMIN="P";
    public static final String TYPEPOPEDOM="S";
    //是否为Administrator
    public static final String ISADMIN="Y";
    /***********************************pm块所用到的静态常量结束********************************/
    
    
    
    
    
    
}
