

package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.vo.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.db.*;
import java.util.*;

public class ModifyRoleUserAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of ModifyRoleUserAction */
    public ModifyRoleUserAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        Vector vecUserRole = new Vector(); 
        PUserRoleVO pUserRoleVO = new PUserRoleVO();
        IUserRole iUserRole;
        int i=0;
        String RoleName;
        String [] strRoleUser = request.getParameterValues(Constants.PMRU_USERS);
        iUserRole = BusinessFactory.newInstance().buildUserRoleImp();
        RoleName = request.getParameter(Constants.PMRU_ROLENAME);
        DbManager.doDelete(Constants.PMRU_DELALL+"'"+RoleName+"'",connection);
        if (strRoleUser!=null){
        if(strRoleUser.length==1){
            pUserRoleVO.setRoleName(RoleName);
            pUserRoleVO.setUserName(strRoleUser[0]);
            iUserRole.addUserRole(connection , pUserRoleVO);
        }else{
            for(i=1;i<=strRoleUser.length;i++){
                pUserRoleVO = new PUserRoleVO();
                pUserRoleVO.setRoleName(RoleName);
                pUserRoleVO.setUserName(strRoleUser[i-1]);
                vecUserRole.addElement(pUserRoleVO);
            }
            iUserRole.addUserRole(connection,vecUserRole);
        }
        }
        String strNextPage = "./MainController.do?ActionName=com.dfkj.pm.actions.ListRoleAction&NextPage=/PowerManagement/roleList.jsp";
        request.setAttribute("NextPage", strNextPage);
    }
    
}
