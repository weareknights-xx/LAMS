
package com.dfkj.eoa.actions.deptwork;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.util.RequestUtils;
import com.dfkj.exception.SystemException;
import com.dfkj.web.IAction;
import com.dfkj.eoa.dao.DAOFactory;
import com.dfkj.eoa.business.*;
import com.dfkj.eoa.vo.*;
import com.dfkj.exception.*;
import com.dfkj.eoa.business.BusinessFactory;

public class DelEoaDeptAction implements IAction{
    
    /** Creates a new instance of AddEoaDeptAction */
    public DelEoaDeptAction() {
    }
    
    public void perform(HttpServletRequest request,HttpServletResponse response,ServletContext context,Connection connection)throws ServletException, SystemException {
        EoaDeptVO vo = new EoaDeptVO();
        String flag = "true";
        try{
            String deptId = request.getParameter("dept_id");
            IDepatManager deptManager = BusinessFactory.newInstance().buildDepatManagerImpl();
            flag = deptManager.delDepartment(connection, deptId);
        }catch(Exception e){
            throw new ServletException("≤ø√≈…æ≥˝ ß∞‹£°"+e.getMessage());
        }
        finally{
            request.setAttribute("FLAG",flag);
        }
    }
}
