

package com.dfkj.pm.business;

import java.util.*;
import java.sql.*;
import com.dfkj.pm.dao.*;
import com.dfkj.pm.vo.*;
import com.dfkj.pm.constants.*;
import com.dfkj.pm.exception.*;
public class UserRoleImp implements IUserRole {
    private IPUserRoleDAO iPUserRoleDAO;
    /** Creates a new instance of UserRoleImp */
    public UserRoleImp() {
        iPUserRoleDAO = DAOFactory.newInstance().buildPUserRoleDAO();
    }
    
    public void addUserRole(java.sql.Connection conn, com.dfkj.pm.vo.PUserRoleVO pUserRole) throws DaoException {
        
            iPUserRoleDAO.insert(conn, pUserRole);
        
    }
    
    public void addUserRole(java.sql.Connection conn, java.util.Collection UserRoleCol)throws DaoException{
        Vector vecUserRole = new Vector();
        PUserRoleVO pUserRoleVO = new PUserRoleVO();
        int i=0;
        vecUserRole = (Vector)UserRoleCol;
        try{
            conn.setAutoCommit(false);
            for(i=0;i<vecUserRole.size();i++){
                pUserRoleVO = (PUserRoleVO)vecUserRole.elementAt(i);
                addUserRole(conn,pUserRoleVO);
            }
            conn.commit();
            conn.setAutoCommit(true);
        }catch(SQLException e){
            try{
                conn.rollback();
            }catch(SQLException ex){
            }
            throw new DaoException(ExceptionConstants.SET_COMMIT_ERROR);            
        }catch(DaoException ex2){
            try{
                conn.rollback();
            }catch(SQLException ex){
            }
            throw ex2;
        }
    }
    
    public void deleteUserRole(java.sql.Connection conn, com.dfkj.pm.vo.PUserRoleVO pUserRole) throws DaoException {
        String UserName = null, RoleName = null;
        UserName = pUserRole.getUserName();
        RoleName = pUserRole.getRoleName();
        if(UserName.compareTo(Constants.ADMIN_USERNAME)==0){
            throw new DaoException(ExceptionConstants.CANNOT_DEL_ADMINROLE);
        }else{
            try{
                conn.setAutoCommit(false);
                iPUserRoleDAO.delete(conn, pUserRole.getUserName(), pUserRole.getRoleName());
                conn.commit();
            }catch(SQLException e){
                try{
                conn.rollback();
                }catch(SQLException ex){
                }
                throw new DaoException(ExceptionConstants.SET_COMMIT_ERROR);
            }catch(DaoException ex1){
                try{
                conn.rollback();
                }catch(SQLException ex){
                }
                throw ex1;
            }
        }
    }
    
    public void deleteUserRole(java.sql.Connection conn, java.util.Collection UserRoleCol) throws DaoException
    {
        Vector vecUserRole = new Vector();
        int i=0;
        vecUserRole = (Vector)UserRoleCol;
        try{
            conn.setAutoCommit(false);
            for(i=0;i<vecUserRole.size();i++){
                deleteUserRole(conn, (PUserRoleVO)vecUserRole.elementAt(i));
            }
            conn.commit();
        }catch(SQLException e){
            try{
                conn.rollback();
            }catch(SQLException ex){
            }
            throw new DaoException(ExceptionConstants.SET_COMMIT_ERROR);
        }catch(DaoException ex2){
            try{
                conn.rollback();
            }catch(SQLException ex){
            }
            throw ex2;
        }
    }
    public java.util.Collection findUserRoleByRole(java.sql.Connection conn, String RoleName) throws DaoException {
        Vector vecUserRole = new Vector();
        vecUserRole = (Vector)iPUserRoleDAO.findByRole_Name(conn,  RoleName);
        return vecUserRole;
    }
    
    public java.util.Collection findUserRoleByUser(java.sql.Connection conn, String UserName) throws DaoException {
        Vector vecUserRole = new Vector();
        vecUserRole = (Vector)iPUserRoleDAO.findByUser_Name(conn, UserName);
        return vecUserRole;
    }
    
}
