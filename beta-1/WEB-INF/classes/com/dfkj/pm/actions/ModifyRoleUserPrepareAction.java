
package com.dfkj.pm.actions;

import com.dfkj.pm.vo.*;
import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.db.*;
import com.dfkj.pm.data.datamodel.DataModel;
import com.dfkj.pm.data.*;
import java.util.*;

public class ModifyRoleUserPrepareAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of ModifyRoleUserPrepareAction */
    public ModifyRoleUserPrepareAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        String RoleName = request.getParameter(Constants.PMRU_ROLENAME);
        String RoleAlias = request.getParameter(Constants.PMRU_ROLEALIAS);
        
        Vector vecUserRoles = new Vector();
        int i=0;
        IUser iUser = BusinessFactory.newInstance().buildUserImp();
        Vector vecAllUsera = (Vector)iUser.findByAll(connection);
        vecUserRoles = DbManager.doQuery("select c.user_name user_name,c.user_description user_description, c.employee_id employee_id,c.user_enabled user_enabled, c.admin admin ,c.region_id region_id,d.user_name checked from p_user c,  (select a.user_name from p_user a,p_user_role b where a.user_name=b.user_name and b.role_name='"+RoleName+"') d where c.user_name=d.user_name(+)",connection);
        DataModel dm = new DataModel(vecUserRoles);
        request.getSession().setAttribute(Constants.PMRU_ROLEALIAS,RoleAlias);
        request.getSession().setAttribute(Constants.PMRU_ROLENAME, RoleName);
        request.getSession().setAttribute(Constants.PM_LISTUSER, dm);
    }
    
}
