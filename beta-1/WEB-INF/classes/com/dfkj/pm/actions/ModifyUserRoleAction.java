

package com.dfkj.pm.actions;

import java.util.*;
import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.vo.*;
import com.dfkj.pm.db.*;


public class ModifyUserRoleAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of ModifyUserRoleAction */
    public ModifyUserRoleAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        Vector vecUserRole = new Vector(); 
        PUserRoleVO pUserRoleVO = new PUserRoleVO();
        IUserRole iUserRole;
        int i=0;
        String UserName;
        String [] strUserRole = request.getParameterValues(Constants.PMUR_ROLES);
        iUserRole = BusinessFactory.newInstance().buildUserRoleImp();
        UserName = request.getParameter(Constants.PMUR_USERNAME);
        DbManager.doDelete(Constants.PMUR_DELALL+"'"+UserName+"'",connection);
        if (strUserRole!=null){
        if(strUserRole.length==1){
            pUserRoleVO.setRoleName(strUserRole[0]);
            pUserRoleVO.setUserName(request.getParameter(Constants.PMUR_USERNAME));
            iUserRole.addUserRole(connection , pUserRoleVO);
        }else{
            for(i=1;i<=strUserRole.length;i++){
                pUserRoleVO = new PUserRoleVO();
                pUserRoleVO.setRoleName(strUserRole[i-1]);
                pUserRoleVO.setUserName(request.getParameter(Constants.PMUR_USERNAME));
                vecUserRole.addElement(pUserRoleVO);
            }
            iUserRole.addUserRole(connection,vecUserRole);
        }
        }
        String strNextPage = "./MainController.do?ActionName=com.dfkj.pm.actions.ListUserAction&NextPage=/PowerManagement/userList.jsp";
        request.setAttribute("NextPage", strNextPage);
    }
    
}
