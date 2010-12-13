
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


public class QueryUserByDeptAction implements IAction{
    
    /** Creates a new instance of QueryUserByDeptAction */
    public QueryUserByDeptAction() {
    }
    public void perform(HttpServletRequest request,HttpServletResponse response,ServletContext context,Connection connection)throws ServletException, SystemException {
        EoaDeptVO vo = new EoaDeptVO();
        String strDeptId = request.getParameter("DEPT_ID");
        vo.setDeptId(strDeptId);
        Vector v = new Vector();
        IDepatManager deptManager = BusinessFactory.newInstance().buildDepatManagerImpl();
        try{
            v = deptManager.getUserListByDept(connection, vo);
        }catch(Exception e){
            throw new ServletException(e.getMessage());
        }finally{
            request.setAttribute("UserList",v);
        }
    }
}
