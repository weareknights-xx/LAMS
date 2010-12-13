

package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.vo.*;

import java.util.*;


public class ListRolePopedomAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of ListRolePopedomAction */
    public ListRolePopedomAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        IRole iRole = BusinessFactory.newInstance().buildRoleImp();
        Vector vecRolePopedom = new Vector();
        String strRoleName = request.getParameter(Constants.PMR_ROLENAME);
        vecRolePopedom = (Vector)iRole.findPopedomByRoleName(connection ,strRoleName);
        request.getSession().setAttribute(Constants.PM_LISTROLEPOPEDOM, vecRolePopedom);
    }
    
}
