

package com.dfkj.pm.actions;

import com.dfkj.pm.constants.Constants;
import com.dfkj.pm.db.DbManager;
import com.dfkj.pm.data.datamodel.*;
import java.util.*;

public class ListUserAction implements com.dfkj.pm.web.IAction{
    
    public ListUserAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {        
        Vector vecListUser;        
        //System.out.println(strRegionCode);
        String sql = "SELECT user_name , user_description , user_enabled , admin, dept_name region_name FROM p_user a,eoa_dept b WHERE b.dept_id(+) = a.department_id ORDER BY department_id,user_name ";
        //System.out.println(sql);
        vecListUser = DbManager.doQuery(sql, connection);
        //System.out.println("VEC"+vecListUser.size());
        DataModel datamodel = new DataModel(vecListUser);
        //System.out.println("DM"+datamodel.getRowCount());
        request.getSession().setAttribute(Constants.PM_LISTUSER, datamodel);
    }
    
}
