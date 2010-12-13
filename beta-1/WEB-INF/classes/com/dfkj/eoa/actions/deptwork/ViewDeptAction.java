

package com.dfkj.eoa.actions.deptwork;

import java.sql.Connection;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.util.RequestUtils;
import com.dfkj.exception.SystemException;
import com.dfkj.web.IAction;
import com.dfkj.eoa.dao.*;
import com.dfkj.eoa.vo.*;


public class ViewDeptAction implements IAction {
    
    /** Creates a new instance of ViewDeptAction */
    public ViewDeptAction() {
    }
    
    public void perform(HttpServletRequest request, HttpServletResponse response, ServletContext context, Connection connection) throws ServletException, SystemException {
        IEoaDeptDAO iEoaDeptDAO;
        iEoaDeptDAO = DAOFactory.newInstance().buildEoaDeptDAO();
        java.util.Collection collection = null;
        try {
            collection = iEoaDeptDAO.findAll(connection);
        }catch (Exception e){
            throw new ServletException(e.getMessage());
        }finally {
            request.setAttribute("deptCollection",collection);
        }
        
         request.setAttribute("NextPage","/deptwork/eoa_deptlist.jsp");
    }

}
