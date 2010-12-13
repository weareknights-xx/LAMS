
package com.dfkj.pm.actions;

import java.util.Vector;
import javax.servlet.http.HttpSession;

import com.dfkj.pm.web.LoginInfo;

import com.dfkj.pm.dao.IPUserDAO;
import com.dfkj.pm.dao.DAOFactory;
import com.dfkj.pm.vo.PUserVO;
import com.dfkj.pm.db.DbManager;
import com.dfkj.pm.data.datamodel.DataModel;
import com.dfkj.pm.constants.Constants;
import com.dfkj.exception.SystemException;
import java.io.*;
import java.util.Properties;

public class LoginAction implements com.dfkj.pm.web.IAction {
    
    /** Creates a new instance of LoginAction */
    public LoginAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.exception.SystemException {         
       String userName=request.getParameter("userName"); 
       String password=request.getParameter("password");  
       String setOnLine = "UPDATE p_user SET on_line='Y' WHERE user_name='" + userName +"' ";
       LoginInfo userInfo =new LoginInfo();         
       HttpSession sess=request.getSession();
       IPUserDAO iPUserDAO=DAOFactory.newInstance().buildPUserDAO();       
       PUserVO pUserVO=null;   
       try{
         pUserVO=iPUserDAO.findByPrimaryKey(connection,userName);                    
       }catch(Exception E){
       }    
       if (pUserVO==null||!password.equals(pUserVO.getPassword())||pUserVO.getUserEnabled().equals("N")){
           
            System.out.println("test user exiested.....");
            String loginResult=""; 
            if (pUserVO==null){
              loginResult="用户名不存在！";
            }else{ 
              if (!password.equals(pUserVO.getPassword())){
                loginResult="密码错误！";
              }else if (pUserVO.getUserEnabled().equals("N")){
                loginResult = "该用户已经被禁用，请与系统管理员联系！";  
              }
            };                        
            request.setAttribute("loginResult",loginResult);
            request.setAttribute("NextPage","/login.jsp");
       }else{         
          //设置本用户的在线状态
          DbManager.doUpdate(setOnLine,connection);
           System.out.println("test user sss exiested.....");
         //p_user表中的regionId为企业Id  
         com.dfkj.eoa.dao.IEoaDeptDAO iEoaDeptDAO  =com.dfkj.eoa.dao.DAOFactory.newInstance().buildEoaDeptDAO();
         com.dfkj.eoa.vo.EoaDeptVO eoaDeptVO=iEoaDeptDAO.findByPrimaryKey(connection, pUserVO.getDepartmentId());
         Vector powerView=new Vector();
         Vector userPower=new Vector();
         String sql = "select a.user_name,c.popedom_name,c.popedom_action from p_user_role a,p_role_popedom b,p_popedom c where a.role_name= b.role_name and b.popedom_name=c.popedom_name and a.user_name="+"'"+userName+"'";         
         powerView = DbManager.doQuery(sql, connection);
         DataModel datamodel = new DataModel(powerView);
         for(int i=0;i<datamodel.getRowCount();i++){
           userPower.add((String)datamodel.getValueAt(i,"popedom_action"));  
         }                          
         userInfo.setUserId(pUserVO.getUserId());               
         userInfo.setUserName(pUserVO.getUserName());
         userInfo.setUserDescription(pUserVO.getUserDescription());
         userInfo.setOnLine(pUserVO.getOnLine());
         userInfo.setDepartmentId(eoaDeptVO.getDeptId());
         userInfo.setDepartmentName(eoaDeptVO.getDeptName());
         userInfo.setDepartmentCode(eoaDeptVO.getDeptCode());
         userInfo.setUserPower(userPower);
         userInfo.setEmailAddress(pUserVO.getEmailAddress());
         userInfo.setEmailUser(pUserVO.getUserName());
         userInfo.setEamilPassword(pUserVO.getPassword());
         
         sess.setAttribute(Constants.LOGINFOBEAN,userInfo);
         request.setAttribute("loginResult","succeed");
         request.setAttribute("NextPage","/main.jsp");
       }                 
    }
    
}
