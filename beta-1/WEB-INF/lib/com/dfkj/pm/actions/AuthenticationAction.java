package com.dfkj.pm.actions;

import com.dfkj.pm.web.*;
import com.dfkj.pm.constants.*;
import com.dfkj.pm.business.*;
import com.dfkj.pm.exception.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class AuthenticationAction implements IAction {
    private String UserName;
    private String Password;
    
    public AuthenticationAction() {
    }
    
    
    public void perform(HttpServletRequest request, HttpServletResponse response, ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.exception.SystemException {
        boolean AuthenticationFlag = false;
        HttpSession sess;
        ILogInfo iLogInfo;
        this.UserName=(String)request.getParameter(Constants.USERNAME);
        this.Password=(String)request.getParameter(Constants.PASSWORD);
        System.out.println(this.UserName);
        System.out.println(this.Password);
        IUser iUser = BusinessFactory.newInstance().buildUserImp();
        sess = request.getSession();
        try{
            AuthenticationFlag = iUser.authenticate(connection, UserName , Password);
        }catch(DaoException e){
            throw new NotAuthenticatedException(ExceptionConstants.CANNOT_LOGIN);
        }
        if(AuthenticationFlag==false){
            throw new NotAuthenticatedException(ExceptionConstants.CANNOT_LOGIN);
        }else{
            try{
                iLogInfo=BusinessFactory.newInstance().buildLogInfoImp();
                iLogInfo.createLogInfo(sess ,this.UserName,context);
            }catch(Exception e){
                throw new SystemException(ExceptionConstants.CLASSCREATEERROR);
            }
        }
        
    }
    
}
