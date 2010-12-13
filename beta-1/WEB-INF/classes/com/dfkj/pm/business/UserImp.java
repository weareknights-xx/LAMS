
package com.dfkj.pm.business;

import java.util.Vector;
import java.sql.*;
import com.dfkj.pm.vo.PUserVO;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.dao.*;
import com.dfkj.db.*;
import com.dfkj.pm.constants.*;

public class UserImp implements IUser {
    private IPUserDAO iUserDAO;
    /** Creates a new instance of UserImp */
    public UserImp() {
        iUserDAO=DAOFactory.newInstance().buildPUserDAO();
    }
    
    public void addUser(Connection conn, PUserVO pUserVO) throws DaoException {
        iUserDAO.insert(conn,pUserVO);
    }
    
    public boolean authenticate(Connection conn, String UserName, String Password) throws DaoException {
        String Pass=null;
        PUserVO pUserVO = new PUserVO();
        pUserVO = iUserDAO.findByPrimaryKey(conn,UserName) ;
        Pass=pUserVO.getPassword();
        
        if(Password.compareTo(Pass)==0){
            if(pUserVO.getUserEnabled().compareTo("N")==0){
                throw new DaoException(ExceptionConstants.USER_DISABLED);
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    
    public void deleteUser(Connection conn, String UserName) throws DaoException {
        PUserVO pUserVO = new PUserVO();
        pUserVO = iUserDAO.findByPrimaryKey(conn, UserName);
        try{
            conn.setAutoCommit(false);
            if(pUserVO.getAdmin().compareTo(Constants.ISADMIN)==0){
                throw new DaoException(ExceptionConstants.CANNOT_DEL_ADMIN);
            }else{
                iUserDAO.delete(conn, UserName);
            }
            DbManager.doDelete(Constants.PMUR_DELALL+"'"+UserName+"'",conn);
            conn.commit();
            conn.setAutoCommit(true);
        }catch(SQLException ex){
            try{
                conn.rollback();
            }catch(Exception ex1){
            }
            throw new DaoException(ExceptionConstants.SET_COMMIT_ERROR);
        }catch(DaoException ex2){
            try{
                conn.rollback();
            }catch(Exception ex3){
            }
            throw ex2;
        }catch(com.dfkj.exception.DataException ex4){
            try{
                conn.rollback();
            }catch(Exception ex5){
            }
            throw new DaoException(ex4.getMessage());
        }
            
    }

    
    public java.util.Collection findByAll(Connection conn) throws DaoException {
        Vector Users= new Vector();
        Users=(Vector)iUserDAO.findAll(conn);
        return Users;
    }
    
    public java.util.Collection findByEmployee(Connection conn, String EmployeeName) throws DaoException {
        Vector Users= new Vector();
        return Users;
    }
    
    public java.util.Collection findUserByDepartment(Connection conn, String DepartmentName) throws DaoException {
        Vector Users= new Vector();
        return Users;
    }
    
    public PUserVO findUserByName(Connection conn, String UserName) throws DaoException {
        PUserVO pUserVO= new PUserVO();
        pUserVO=iUserDAO.findByPrimaryKey(conn, UserName);
        return pUserVO;
    }
    
    public java.util.Collection findUserByRegion(Connection conn, String RegionName) throws DaoException{
        Vector Users= new Vector();
        Vector temp=new Vector();
        int size=0;
        String RegionLevel=null;
        String sql="SELECT region_level FROM p_region WHERE region_name="+RegionName;
        try{
            temp=DbManager.doQuery(sql, conn);
        }catch(com.dfkj.exception.DataException e){
            throw new DaoException("Error Excuting SQL:" + sql+ " With error : "+e.getMessage());
        }
        if(temp.size()==1){
            RegionLevel=temp.elementAt(0).toString();
            size=RegionLevel.length();
            sql="SELECT region_id FROM p_region WHERE SUBSTR(region_level,1,"+String.valueOf(size)+")='"+RegionLevel+"'";
            try{
                temp=DbManager.doQuery(sql,conn);
            }catch(com.dfkj.exception.DataException e){
                throw new DaoException("Error Excuting SQL:" + sql + "With Error :" + e.getMessage());
            }
            if(temp.size()>0){
                Users=(Vector)iUserDAO.findByRegion_ID(conn,temp);
            }
        }
        return Users;
    }
    
    public java.util.Collection findUserbyRD(Connection conn, String RegionName, String DepartmentName) throws DaoException {
        Vector Users= new Vector();
        return Users;
    }
    
    public void updateUser(Connection conn, PUserVO pUserVO) throws DaoException {
        if(pUserVO.getUserName().compareTo(Constants.ADMIN_USERNAME)==0){
            throw new DaoException(ExceptionConstants.CANNOT_CHANGE_ADMIN);
        }else{
            iUserDAO.update(conn, pUserVO);
        }        
    }
    
}
