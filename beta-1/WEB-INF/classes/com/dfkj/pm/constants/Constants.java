
package com.dfkj.pm.constants;


public class Constants {
    /*********************************�̶�ȫ�ֳ���**********************************************/
    //�̶���Administrator�˺�����
    public static final String ADMIN_USERNAME="Administrator";
    //�̶���Administrator��ɫ����
    public static final String ADMIN_ROLENAME="Administrator";
    //��¼�����ɵ��û���ϢBean
    public static final String LOGINFOBEAN="LogInfo";
    //�����û�bean������
    public static final String LOGINFO = "com.dfkj.pm.business.LogInfoImp";
    //ȫ��Properties�ļ��Ĵ��·��
    public static final String PROPFILEPATH = "/PropFiles/"; 
    //���ṹ�ĳ�ʼSchema
    public static final String ORIGINALSCHEMA = "1";
    
    /*****************************pm�����õ��ľ�̬����******************************************/
    /********pm������Ҫ�õ���SQL���*******/
    //ɾ����ɫ���õ�SQL���
    public static final String DELETEROLE="DELETE FROM p_role_popedom WHERE role_name=";
    //�޸��û�Ȩ��ʱ��Ҫɾ�������û�Ȩ����ʹ�õ�SQL���(����ɾ���û�ʱʹ��)
    public static final String PMUR_DELALL = "DELETE FROM p_user_role WHERE user_name = ";
    //�޸�Ȩ�޶�Ӧ�û�ʱ��Ҫɾ������Ȩ���û�ʹ�õ�SQL���
    public static final String PMRU_DELALL = "DELETE FROM p_user_role WHERE role_name = ";
    //��ѯ�û���ӵ�еĽ�ɫ
    public static final String FINDUSERROLE = "SELECT a.popedom_name popedom_name , a.popedom_alias popedom_alias , a.popedom_type popedom_type ,a.popedom_sort popedom_sort,a.popedom_action popedom_action  from p_popedom a,p_user_role b where a.popedom_name = b.role_name and b.user_name ="; 
    //��ѯ��ǰ�û���ӵ�е�Ȩ�޵�SQL
    public static final String FINDUSERPOPEDOM = "SELECT user_name,popedom_name FROM p_user_popedom_view WHERE user_name = "; 
    
    
    
    
    /***pm�������ŵ�Session�е���������***/
    //��ѯ�����û��Ľ����ŵ�Session�е�attribute����
    public static final String PM_LISTUSER = "ListUser";
    //��ѯ�õ���������޸Ĳ������û���Ϣ�����Session�е�attribute����
    public static final String PM_USERDETAIL = "UserDetail";
    //��ѯ�õ���������޸Ĳ����Ľ�ɫ��Ϣ�����Session�е�attribute����
    public static final String PM_ROLEDETAIL = "RoleDetail";
    //��ѯ���и��û���ǰrole�Ľ����ŵ�Session�е�attribute����
    public static final String PM_LISTUSERROLE = "ListUserRole";
    //��ѯ����Role�Ľ����ŵ�Session�е�attribute����
    public static final String PM_LISTROLE = "ListRole";
    //��ѯ��ǰRole������������Ȩ�޵Ľ����ŵ�Session�е�attribute����
    public static final String PM_LISTROLEPOPEDOM = "ListRolePopedom";
    //��ѯ�õ����е�Ȩ�޽����ŵ�Session�е�attribute����
    public static final String PM_LISTPOPEDOM = "ListPopedom";
    
    /***pm������Ҫ��ǰ��̨�䴫�ݵĲ����б�***/
    //ȡ���û���������ĳ���
    public static final String USERNAME="username";
    public static final String PASSWORD="password";
    //�������޸ġ�ɾ���û�ʱ���õ��Ĵ����������
    public static final String PMD_USERNAME = "userName";
    public static final String PMD_USERDESCRIPTION = "userDescription";
    public static final String PMD_REGIONID = "regionID";
    public static final String PMD_PASSWORD = "password";
    public static final String PMD_USERENABLED = "userEnabled";
    public static final String PMD_ADMIN = "admin";
    //�������޸��û�ʱ����Ҫ��ȡRegion��region��Ϣ��ŵ�Session�е�����
    public static final String REGION = "region";
    //�������޸ġ�ɾ���û�Ȩ��ʱ���õ��Ĳ�������
    public static final String PMUR_USERNAME = "userName";
    public static final String PMUR_USERDESCRIPTION ="userDescription" ;
    public static final String PMUR_ROLENAME = "rolename";
    public static final String PMUR_ROLES = "roles";
    //�������޸ġ�ɾ����ɫ��Ӧ�û����õ��Ĳ�������
    public static final String PMRU_USERS = "users";
    public static final String PMRU_ROLENAME = "rolename";
    public static final String PMRU_ROLEALIAS = "rolealias";
    //�������޸ġ�ɾ��Roleʱ���õ��Ĵ����������
    public static final String PMR_ROLENAME = "rolename";
    public static final String PMR_ROLEALIAS = "rolealias";
    public static final String PMR_ROLETYPE = "roletype";
    public static final String PMR_ROLESORT = "rolesort";
    public static final String PMR_ROLEACTION = "roleaction";
    public static final String PMR_POPEDOMS = "popedoms";
    public static final String PMR_POPEDOM = "popedom";
    
    /**********pm������Ҫ����������**********/
    //Ȩ������
    public static final String TYPEROLE="R";
    public static final String TYPEADMIN="P";
    public static final String TYPEPOPEDOM="S";
    //�Ƿ�ΪAdministrator
    public static final String ISADMIN="Y";
    /***********************************pm�����õ��ľ�̬��������********************************/
    
    
    
    
    
    
}
