

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
import com.dfkj.eoa.dao.DAOFactory;
import com.dfkj.eoa.business.*;
import com.dfkj.eoa.vo.*;
import com.dfkj.eoa.business.BusinessFactory;


public class QueryDeptDetailByIdAction implements IAction{
    
    /** Creates a new instance of QueryDeptDetailByIdAction */
    public QueryDeptDetailByIdAction() {
    }
    
     public void perform(HttpServletRequest request,HttpServletResponse response,ServletContext context,Connection connection)throws ServletException, SystemException {
        EoaDeptVO vo = new EoaDeptVO();
        String strDeptId = request.getParameter("DEPT_ID");
        vo.setDeptId(strDeptId);
        IDepatManager deptManager = BusinessFactory.newInstance().buildDepatManagerImpl();
        try{
            vo = deptManager.getDeptById(connection, strDeptId);
        }catch(Exception e){
            throw new ServletException(e.getMessage());
        }finally{
            request.setAttribute("DEPTVO",vo);
        }
    }   
}
