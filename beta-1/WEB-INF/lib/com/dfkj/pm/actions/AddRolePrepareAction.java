

package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;

import java.util.*;


public class AddRolePrepareAction implements com.dfkj.web.IAction {
    
    /** Creates a new instance of AddRolePrepareAction */
    public AddRolePrepareAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        IRole iRole = BusinessFactory.newInstance().buildRoleImp();
        Vector vecPopedoms = (Vector)iRole.findPopedomByAll(connection);
        request.getSession().setAttribute(Constants.PM_LISTPOPEDOM, vecPopedoms);
    }
    
}
