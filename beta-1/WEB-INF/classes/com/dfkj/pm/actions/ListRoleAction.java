

package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.vo.*;

import java.util.*;


public class ListRoleAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of ListRoleAction */
    public ListRoleAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        Vector vecListRole = new Vector();
        IRole iRole = BusinessFactory.newInstance().buildRoleImp();
        vecListRole = (Vector)iRole.findRoleByAll(connection);
        System.out.println("Roles = "+vecListRole.size());
        request.getSession().setAttribute(Constants.PM_LISTROLE ,  vecListRole);
    }
    
}
