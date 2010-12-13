
package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.vo.*;

import java.util.*;

public class ModifyRoleAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of ModifyRoleAction */
    public ModifyRoleAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        IRole iRole = BusinessFactory.newInstance().buildRoleImp();
        int i=0;
        String RoleName = request.getParameter(Constants.PMR_ROLENAME);
        String RoleAlias = request.getParameter(Constants.PMR_ROLEALIAS);
        String [] strRoles = request.getParameterValues(Constants.PMR_POPEDOMS);
        
        PPopedomVO pPopedomVO = new PPopedomVO();
        pPopedomVO.setPopedomName(RoleName);
        pPopedomVO.setPopedomAlias(RoleAlias);
        pPopedomVO.setPopedomType(request.getParameter(Constants.PMR_ROLETYPE));
        pPopedomVO.setPopedomSort(request.getParameter(Constants.PMR_ROLESORT));
        pPopedomVO.setPopedomAction(request.getParameter(Constants.PMR_ROLEACTION));
        Vector vecRolePopedom = new Vector();
        if(strRoles.length<1){
            throw new SystemException(ExceptionConstants.HAVENOT_CHOOSEN_POPEDOM);
        }
        for(i=1;i<=strRoles.length;i++){
            PRolePopedomVO pRolePopedomVO = new PRolePopedomVO();
            pRolePopedomVO.setRoleName(RoleName);
            pRolePopedomVO.setPopedomName(strRoles[i-1]);
            vecRolePopedom.addElement(pRolePopedomVO);
        }
        iRole.updateRole(connection, pPopedomVO, vecRolePopedom);
        
        String strNextPage="./MainController.do?ActionName=com.dfkj.pm.actions.ListRoleAction&NextPage=/PowerManagement/roleList.jsp";
        request.setAttribute("NextPage", strNextPage);
    }
    
}
