

package com.dfkj.pm.actions;

import java.util.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.constants.*;
public class ListAllUserAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of ListUserAction */
    public ListAllUserAction() {
    }
    //返回所有用户信息
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {        
        Vector vecListUser = new Vector();
        IUser iUser = BusinessFactory.newInstance().buildUserImp();        
        vecListUser = (Vector)iUser.findByAll(connection);        
        request.getSession().setAttribute(Constants.PM_LISTUSER , vecListUser);
    }
    
}
