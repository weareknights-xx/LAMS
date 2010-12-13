

package com.dfkj.pm.actions;

import java.util.*;
import java.io.*;
import com.dfkj.pm.vo.*;
import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.web.LoginInfo;
import com.dfkj.pm.constants.Constants;



public class AddUserAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of AddUserAction */
    public AddUserAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.pm.exception.SystemException {
        LoginInfo loginInfo =(LoginInfo)request.getSession().getAttribute(Constants.LOGINFOBEAN);
        PUserVO pUserVO = new PUserVO();
        IUser iUser;
        pUserVO.setUserName(request.getParameter(Constants.PMD_USERNAME));
        pUserVO.setUserDescription(request.getParameter(Constants.PMD_USERDESCRIPTION));
        pUserVO.setPassword(request.getParameter(Constants.PMD_PASSWORD));        
        pUserVO.setUserEnabled(request.getParameter(Constants.PMD_USERENABLED));
        pUserVO.setAdmin(request.getParameter(Constants.PMD_ADMIN));    
        pUserVO.setDepartmentId(request.getParameter("parent_id"));        
        pUserVO.setEmailAddress(request.getParameter(Constants.PMD_USERNAME)+"@"+loginInfo.getDomain());
        iUser = BusinessFactory.newInstance().buildUserImp();
        iUser.addUser(connection , pUserVO);         
        String strNextPage="./MainController.do?ActionName=com.dfkj.pm.actions.ListUserAction&NextPage=/PowerManagement/userList.jsp";
        request.setAttribute("NextPage", strNextPage);
    }
    
}
