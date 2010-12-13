

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
import com.dfkj.eoa.business.BusinessFactory;

public class AddEoaDeptAction implements IAction{
    
    /** Creates a new instance of AddEoaDeptAction */
    public AddEoaDeptAction() {
    }
    
    public void perform(HttpServletRequest request,HttpServletResponse response,ServletContext context,Connection connection)throws ServletException, SystemException {
        EoaDeptVO vo = new EoaDeptVO();
        System.out.println("dddddddddddddddddd");
        String flag = "true";
        try{
            String deptName = request.getParameter("dept_name");
            String deptCode = request.getParameter("dept_code");
            String parentId = request.getParameter("parent_id");
            String deptType = request.getParameter("dept_type");
            String enabled = request.getParameter("enabled");
            String description = request.getParameter("description");
            String queue = request.getParameter("queue");
            String remark = request.getParameter("remark");
            //RequestUtils.populate(vo, request);
            vo.setDeptName(deptName);
            vo.setDeptCode(deptCode);
            vo.setParentId(parentId);
            vo.setDeptType(deptType);
            vo.setEnabled(enabled);
            vo.setDescription(description);
            vo.setQueue(queue);
            vo.setRemark(remark);
            System.out.println(vo.getDeptName());
            IDepatManager deptManager = BusinessFactory.newInstance().buildDepatManagerImpl();
            deptManager.addDepartment(connection, vo);
        }catch(Exception e){
            flag = "false";
            throw new ServletException("添加新部门失败！"+e.getMessage());
        }
        finally{
            request.setAttribute("FLAG",flag);
        }
    }
}
