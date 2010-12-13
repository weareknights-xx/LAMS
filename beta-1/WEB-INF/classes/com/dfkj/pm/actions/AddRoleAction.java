
package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.vo.*;
import com.dfkj.pm.exception.SystemException;

import java.util.*;

public class AddRoleAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of AddRoleAction */
    public AddRoleAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        PPopedomVO pPopedomVO = new PPopedomVO();
        
        Vector vecRolePopedom = new Vector();
        String [] strPopedom = request.getParameterValues(Constants.PMR_POPEDOMS);
        IRole iRole = BusinessFactory.newInstance().buildRoleImp();
        int i=0;
        String RoleName = request.getParameter(Constants.PMR_ROLENAME);
        pPopedomVO.setPopedomName(RoleName);
        pPopedomVO.setPopedomAlias(request.getParameter(Constants.PMR_ROLEALIAS));
        pPopedomVO.setPopedomType(request.getParameter(Constants.PMR_ROLETYPE));
        pPopedomVO.setPopedomSort(request.getParameter(Constants.PMR_ROLESORT));
        pPopedomVO.setPopedomAction(request.getParameter(Constants.PMR_ROLEACTION));
        for(i=1;i<=strPopedom.length;i++){
            PRolePopedomVO pRolePopedomVO = new PRolePopedomVO();
            pRolePopedomVO.setRoleName(RoleName);
            pRolePopedomVO.setPopedomName(strPopedom[i-1]);
            vecRolePopedom.addElement(pRolePopedomVO);
        }
        
        iRole.addRole(connection , pPopedomVO , vecRolePopedom);                  

        String strNextPage="./MainController.do?ActionName=com.dfkj.pm.actions.ListRoleAction&NextPage=/PowerManagement/roleList.jsp";
        request.setAttribute("NextPage", strNextPage);
    }
    
}
