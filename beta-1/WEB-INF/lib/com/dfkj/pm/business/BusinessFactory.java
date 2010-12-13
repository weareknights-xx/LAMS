

package com.dfkj.pm.business;


public class BusinessFactory {
    
    /** Creates a new instance of BusinessFactory */
    public BusinessFactory() {
    }
    
    public static BusinessFactory newInstance(){
        return new BusinessFactory();
    }
    
    public IUser buildUserImp(){
        return new UserImp();
    }
    
    public IRole buildRoleImp(){
        return new RoleImp();
    }
    
    public IUserRole buildUserRoleImp(){
        return new UserRoleImp();
    }
    
    public ILogInfo buildLogInfoImp(){
        return new LogInfoImp();
    }
}
