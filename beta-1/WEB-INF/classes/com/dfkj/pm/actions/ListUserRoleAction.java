

package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.vo.*;

import java.util.*;


public class ListUserRoleAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of ListUserRoleAction */
    public ListUserRoleAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        Vector vecListUserRole = new Vector();
        IUserRole iUserRole = BusinessFactory.newInstance().buildUserRoleImp();
        String UserName = request.getParameter(Constants.PMUR_USERNAME);
        vecListUserRole = (Vector)iUserRole.findUserRoleByUser(connection , UserName);
        request.getSession().setAttribute(Constants.PM_LISTUSERROLE ,  vecListUserRole);
    }
    
}
