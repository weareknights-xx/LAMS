

package com.dfkj.eoa.actions.deptwork;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.util.RequestUtils;

import com.dfkj.exception.SystemException;

import com.dfkj.eoa.vo.EoaDeptActVO;
import com.dfkj.eoa.business.BusinessFactory;
import com.dfkj.eoa.business.IEoaDeptAct;

public class ViewEoaDeptActAction implements com.dfkj.web.IAction {
    
    
    public ViewEoaDeptActAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection)throws ServletException, SystemException {
    
        //从JSP页面取得主键值    
		String deptActId = request.getParameter("deptActId");
              
          //如果主键值不为空，调用相应Business类接口的相应方法,获得对应记录的VO对象
           if (!deptActId.trim().equalsIgnoreCase("")) {
           //调用业务层逻辑
             IEoaDeptAct iEoaDeptAct =
			BusinessFactory.newInstance().buildEoaDeptActImpl();
               java.util.HashMap hDeptAct = new java.util.HashMap();
		try {
			hDeptAct = iEoaDeptAct.findHashById(connection, deptActId);
                        request.setAttribute("hEoaDeptAct", hDeptAct);
                        //System.out.println("deptActId"+deptActId);
		} catch (Exception e) {
                }
           }

    }
    
}