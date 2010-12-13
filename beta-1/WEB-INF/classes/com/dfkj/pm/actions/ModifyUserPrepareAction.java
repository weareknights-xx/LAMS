

package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.vo.PUserVO;
import com.dfkj.pm.db.DbManager;
import com.dfkj.pm.data.datamodel.*;
import java.util.*;

public class ModifyUserPrepareAction implements com.dfkj.web.IAction {
    
    /** Creates a new instance of ModifyUserPrepareAction */
    public ModifyUserPrepareAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.exception.SystemException {
        String UserName = request.getParameter(Constants.PMD_USERNAME);
        //用户信息
        IUser iUser = BusinessFactory.newInstance().buildUserImp();
        PUserVO pUserVO = new PUserVO();
        pUserVO = iUser.findUserByName(connection , UserName);
        System.out.println(pUserVO.getUserName());
        request.getSession().setAttribute(Constants.PM_USERDETAIL, pUserVO);                
        //找出企业名称
        Vector enterpriseList;        
        String sql = "select dept_name from eoa_dept where dept_id="+pUserVO.getDepartmentId();        
        enterpriseList = DbManager.doQuery(sql, connection);
        DataModel datamodel = new DataModel(enterpriseList);        
        request.setAttribute("departmentName",datamodel.getValueAt(0,"dept_name"));        
    }
    
}
