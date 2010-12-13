

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
    
        //��JSPҳ��ȡ������ֵ    
		String deptActId = request.getParameter("deptActId");
              
          //�������ֵ��Ϊ�գ�������ӦBusiness��ӿڵ���Ӧ����,��ö�Ӧ��¼��VO����
           if (!deptActId.trim().equalsIgnoreCase("")) {
           //����ҵ����߼�
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