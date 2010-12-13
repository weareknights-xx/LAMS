
package com.dfkj.eoa.actions.deptwork;

import java.sql.Connection;
import com.dfkj.eoa.constants.EOAConstants;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfkj.exception.SystemException;
import com.dfkj.web.IAction;
import com.dfkj.eoa.business.*;
import com.dfkj.eoa.vo.*;
import com.dfkj.pm.web.*;


public class SelectDepartments  implements IAction{
    
    /** Creates a new instance of SelectDepartments */
    public SelectDepartments() {
    }
    
    public void perform(HttpServletRequest request, HttpServletResponse response, ServletContext context, Connection connection) throws ServletException, SystemException {
	String[] selectedDeptIds = request.getParameterValues("deptIds");
        request.getSession().setAttribute("arraySelectedDeptIds",selectedDeptIds);
    }
    
}
