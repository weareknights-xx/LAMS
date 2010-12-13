

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
import com.dfkj.eoa.dao.IEoaDeptDAO;
import com.dfkj.eoa.dao.IEoaHumanarchiveDAO;
import com.dfkj.eoa.business.*;
import com.dfkj.eoa.vo.*;
import com.dfkj.exception.*;
import com.dfkj.eoa.business.BusinessFactory;
/**
 *
 * @author  Administrator
 */
public class EditEoaDeptAction implements IAction{
    
    /** Creates a new instance of EditEoaDeptAction */
    public EditEoaDeptAction() {
    }
    public void perform(HttpServletRequest request,HttpServletResponse response,ServletContext context,Connection connection)throws ServletException, SystemException {
        EoaDeptVO vo = new EoaDeptVO();
        String flag = "editTrue";
        try{
            String deptId = request.getParameter("dept_id");
            String actionFlag = request.getParameter("actionFlag");
            IDepatManager deptManager = BusinessFactory.newInstance().buildDepatManagerImpl();
            if(actionFlag.equals("list")){
                vo = deptManager.getDeptById(connection, deptId); 
            }else{
                flag = editEoaDeptVO(request,response,connection);
            }
        }catch(Exception e){
            flag = "editFalse";
            throw new ServletException("²¿ÃÅÐÞ¸ÄÊ§°Ü£¡"+e.getMessage());
        }
        finally{
            request.setAttribute("EOADEPTVO",vo);
            request.setAttribute("FLAG",flag);
        }
    }
    public String editEoaDeptVO(HttpServletRequest request,HttpServletResponse response,Connection connection)throws ServletException, SystemException {
            String deptId = request.getParameter("dept_id");
            String deptName = request.getParameter("dept_name");
            String deptCode = request.getParameter("dept_code");
            String parentId = request.getParameter("parent_id");
            String deptType = request.getParameter("dept_type");
            String enabled = request.getParameter("enabled");
            String description = request.getParameter("description");
            String queue = request.getParameter("queue");
            String remark = request.getParameter("remark");
            String retFlag = "editTrue";
            EoaDeptVO vo = new EoaDeptVO();
            vo.setDeptId(deptId);
            vo.setDeptName(deptName);
            vo.setDeptCode(deptCode);
            vo.setParentId(parentId);
            vo.setDeptType(deptType);
            vo.setEnabled(enabled);
            vo.setDescription(description);
            vo.setQueue(queue);
            vo.setRemark(remark);
            IEoaDeptDAO dao = DAOFactory.newInstance().buildEoaDeptDAO();
            IEoaHumanarchiveDAO humanDAO = DAOFactory.newInstance().buildEoaHumanarchiveDAO();
            try{
                connection.setAutoCommit(false);
                dao.update(connection,vo);
                
                humanDAO.updateDept(connection,vo.getDeptName(),vo.getDeptId());
                
                connection.commit();
            }catch(Exception e){
                retFlag = "editFalse";
                System.out.println(e.getMessage());
                throw new ServletException(e.getMessage(),e);
            }
            finally{
               // System.out.println("xxxxxxxx"+retFlag);
                return retFlag;
            }
    }
}
