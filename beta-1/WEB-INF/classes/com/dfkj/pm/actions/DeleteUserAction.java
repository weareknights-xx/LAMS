
package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.exception.*;
import java.util.*;
import java.io.*;


public class DeleteUserAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of DeleteUserAction */
    public DeleteUserAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        String UserName = null;
        IUser iUser;
        UserName = request.getParameter(Constants.PMD_USERNAME);
        iUser = BusinessFactory.newInstance().buildUserImp();
        iUser.deleteUser(connection , UserName);       
                
        String strNextPage="./MainController.do?ActionName=com.dfkj.pm.actions.ListUserAction&NextPage=/PowerManagement/userList.jsp";
        request.setAttribute("NextPage", strNextPage);
    }
    
}
