

package com.dfkj.pm.actions;

import com.dfkj.pm.db.DbManager;
import com.dfkj.pm.data.datamodel.*;
import java.util.*;

public class EnterpriseListAction implements com.dfkj.pm.web.IAction{
    
    /** Creates a new instance of EmployeeListAction */
    public EnterpriseListAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.exception.SystemException {
        Vector employeeList;        
        String sql = "select * from eep_enterprise";
        //System.out.println(sql);
        employeeList = DbManager.doQuery(sql, connection);
        DataModel datamodel = new DataModel(employeeList);
        //System.out.println("DM"+datamodel.getRowCount());
        request.setAttribute("enterpriseList", datamodel);        
    }
    
}
