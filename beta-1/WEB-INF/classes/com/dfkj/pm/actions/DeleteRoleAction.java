
package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.vo.*;


public class DeleteRoleAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of DeleteRoleAction */
    public DeleteRoleAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        IRole iRole = BusinessFactory.newInstance().buildRoleImp();
        PPopedomVO pPopedomVO = new PPopedomVO();
        String RoleName = request.getParameter(Constants.PMR_ROLENAME);
        System.out.println(RoleName);
        pPopedomVO.setPopedomName(RoleName);
        iRole.deleteRole(connection , pPopedomVO);
        
        String strNextPage="./MainController.do?ActionName=com.dfkj.pm.actions.ListRoleAction&NextPage=/PowerManagement/roleList.jsp";
        request.setAttribute("NextPage", strNextPage);
    }
    
}
