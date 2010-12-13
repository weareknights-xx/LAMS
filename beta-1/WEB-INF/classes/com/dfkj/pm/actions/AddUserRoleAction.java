

package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.vo.*;
import com.dfkj.pm.business.*;
import java.util.*;


public class AddUserRoleAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of AddUserRoleAction */
    public AddUserRoleAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        Vector vecUserRole = new Vector(); 
        PUserRoleVO pUserRoleVO = new PUserRoleVO();
        IUserRole iUserRole;
        int roleNum = 0,i=0;
        String [] strUserRole = request.getParameterValues(Constants.PMUR_ROLES);
        iUserRole = BusinessFactory.newInstance().buildUserRoleImp();
        
        if(strUserRole.length==1){
            pUserRoleVO.setRoleName(strUserRole[0]);
            pUserRoleVO.setUserName(request.getParameter(Constants.PMUR_USERNAME));
            iUserRole.addUserRole(connection , pUserRoleVO);
        }else{
            for(i=1;i<=strUserRole.length;i++){
                pUserRoleVO.setRoleName(strUserRole[i-1]);
                pUserRoleVO.setUserName(request.getParameter(Constants.PMUR_USERNAME));
                vecUserRole.addElement(pUserRoleVO);
            }
            iUserRole.addUserRole(connection,vecUserRole);
        }
        
        //pUserRoleVO.
    }
    
}
