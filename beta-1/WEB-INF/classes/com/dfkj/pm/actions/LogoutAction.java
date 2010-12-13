

package com.dfkj.pm.actions;

import com.dfkj.pm.constants.Constants;
import com.dfkj.pm.db.DbManager;
import com.dfkj.pm.data.datamodel.*;
import java.util.*;
import com.dfkj.pm.web.*;

public class LogoutAction implements com.dfkj.pm.web.IAction{
    
    /** Creates a new instance of ListUserAction */
    public LogoutAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {        
        //
        LoginInfo loginInfo =(LoginInfo)request.getSession().getAttribute(com.dfkj.constants.Constants.LOGINFOBEAN);
        String userName = loginInfo.getUserName();

        String setOnLine = "UPDATE p_user SET on_line='N' WHERE user_name='" + userName +"' ";
        DbManager.doUpdate(setOnLine,connection);
    }
    
}
