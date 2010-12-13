

package com.dfkj.pm.actions;

import com.dfkj.pm.vo.*;
import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.db.*;
import com.dfkj.pm.data.datamodel.DataModel;
import com.dfkj.pm.data.*;
import java.util.*;
public class ModifyUserRolePrepareAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of ModifyUserRolePrepareAction */
    public ModifyUserRolePrepareAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        String UserName = request.getParameter(Constants.PMUR_USERNAME);
        String UserDescription = request.getParameter(Constants.PMUR_USERDESCRIPTION);
        
        Vector vecUserRoles = new Vector();
        int i=0;
        IRole iRole = BusinessFactory.newInstance().buildRoleImp();
        Vector vecAllRoles = (Vector)iRole.findRoleByAll(connection);
        vecUserRoles = DbManager.doQuery("select c.popedom_name popedom_name, c.popedom_alias popedom_alias , c.popedom_type popedom_type,c.popedom_sort popedom_sort,c.popedom_action popedom_action,d.popedom_name checked from p_popedom c,(select a.popedom_name from p_popedom a,p_user_role b where a.popedom_name = b.role_name and b.user_name ="+"'"+UserName+"') d where c.popedom_name = d.popedom_name(+) and (c.popedom_type='R' or c.popedom_type='P')",connection);
        DataModel dm = new DataModel(vecUserRoles);
        request.getSession().setAttribute(Constants.PMUR_USERDESCRIPTION,UserDescription);
        request.getSession().setAttribute(Constants.PMUR_USERNAME, UserName);
        request.getSession().setAttribute(Constants.PM_LISTROLE, dm);                
    }
    
}
