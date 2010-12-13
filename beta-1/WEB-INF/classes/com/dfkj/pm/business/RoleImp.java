
package com.dfkj.pm.business;

import java.util.Vector;
import java.util.Collection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import com.dfkj.pm.constants.*;
import com.dfkj.pm.vo.PPopedomVO;
import com.dfkj.pm.vo.PRolePopedomVO;
import com.dfkj.pm.vo.PUserRoleVO;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.dao.IPRolePopedomDAO;
import com.dfkj.pm.dao.IPPopedomDAO;
import com.dfkj.pm.dao.DAOFactory;
import com.dfkj.db.*;



public class RoleImp implements IRole{
    private IPRolePopedomDAO iRoleDAO;
    private IPPopedomDAO iRoleDAO2;
    /** Creates a new instance of RoleImp */
    public RoleImp() {
        iRoleDAO = DAOFactory.newInstance().buildPRolePopedomDAO();
        iRoleDAO2 = DAOFactory.newInstance().buildPPopedomDAO();
    }
    
    public void addRole(Connection conn,PPopedomVO pPopedomVO,Collection PopedomCol) throws DaoException{
        try{
            conn.setAutoCommit(false);
            String strRoleName = null;
            Vector vecPopedom = new Vector();
            strRoleName = pPopedomVO.getPopedomName();
            vecPopedom = (Vector)PopedomCol;
            PRolePopedomVO pRolePopedomVO = new PRolePopedomVO();
            iRoleDAO2.insert(conn, pPopedomVO);
            int i=0;
            for(i=0;i<=vecPopedom.size()-1;i++){
                pRolePopedomVO.setRoleName(strRoleName);
                System.out.println(((PRolePopedomVO)vecPopedom.get(i)).getPopedomName());
                pRolePopedomVO.setPopedomName(((PRolePopedomVO)vecPopedom.get(i)).getPopedomName());
                iRoleDAO.insert(conn,pRolePopedomVO);
            }
            IUserRole iUserRole = BusinessFactory.newInstance().buildUserRoleImp();
            PUserRoleVO pUserRoleVO = new PUserRoleVO();
            pUserRoleVO.setUserName(Constants.ADMIN_USERNAME);
            pUserRoleVO.setRoleName(strRoleName);
            iUserRole.addUserRole(conn, pUserRoleVO);
            conn.commit();
            conn.setAutoCommit(true);
        }catch(SQLException e){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex1){
            }
            
            throw new DaoException(ExceptionConstants.SET_COMMIT_ERROR);
        }catch(DaoException ex2){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex3){
            }
            
            throw ex2;
        }
        
    }
    
    public void deleteRole(Connection conn, PPopedomVO pPopedomVO) throws DaoException{
        String strRoleName = null;
        String strRoleType = null;
        PPopedomVO pPopedomVOOriginal = new PPopedomVO();
        strRoleName = pPopedomVO.getPopedomName();
        pPopedomVOOriginal=iRoleDAO2.findByPrimaryKey(conn, strRoleName);
        strRoleType = pPopedomVOOriginal.getPopedomType();
        System.out.println(strRoleType);
        if(strRoleType.compareTo(Constants.TYPEADMIN)==0){
            throw new DaoException(ExceptionConstants.CANNOT_DEL_ADMIN);
        }
        Statement statement=null;
        try{
            statement=conn.createStatement();
        }catch(SQLException e){
            throw new DaoException(ExceptionConstants.CREATE_STATEMENT_ERROR +e.getMessage());
        }
        try{
            conn.setAutoCommit(false);
        }catch(SQLException e){
            throw new DaoException(ExceptionConstants.SET_COMMIT_ERROR);
        }
        try{
            statement.execute(Constants.DELETEROLE+"'"+strRoleName+"'");
            statement.close();
        }catch(SQLException e){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex){
            }
            
            throw new DaoException(ExceptionConstants.STATEMENT_EXCUTE_ERROR +e.getMessage());
        }
        try{
            iRoleDAO2.delete(conn, strRoleName);
        }catch(DaoException e){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex3){
            }
            
            throw e;
        }
        try{
            conn.commit();
            conn.setAutoCommit(true);
        }catch(SQLException e){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex3){
            }
            
            throw new DaoException(ExceptionConstants.SET_COMMIT_ERROR);
        }
    }
    public void updateRole(Connection conn,PPopedomVO pPopedomVO,Collection PopedomCol) throws DaoException{
        String strRoleName = null;
        int i=0;
        strRoleName = pPopedomVO.getPopedomName();
        Statement statement=null;
        PRolePopedomVO pRolePopedomVO = new PRolePopedomVO();
        Vector vecPopedom = null;
        vecPopedom=(Vector)PopedomCol;
        IPPopedomDAO iPPopedomDAO= DAOFactory.newInstance().buildPPopedomDAO();
        try{
            conn.setAutoCommit(false);
        }catch(SQLException e){
            throw new DaoException(ExceptionConstants.SET_COMMIT_ERROR);
        }
        try{
            iPPopedomDAO.update(conn , pPopedomVO);
        }catch(DaoException e){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex3){
            }
            throw e;
        }
        if(pPopedomVO.getPopedomName().compareTo(Constants.ADMIN_ROLENAME)==0){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex3){
            }
            
            throw new DaoException(ExceptionConstants.CANNOT_UPDATE_ADMINROLE);
        }
        
        try{
            statement=conn.createStatement();
        }catch(SQLException e){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex3){
            }
            
            throw new DaoException(ExceptionConstants.CREATE_STATEMENT_ERROR +e.getMessage());
        }
        try{
            System.out.println(Constants.DELETEROLE+"'"+strRoleName+"'");
            statement.execute(Constants.DELETEROLE+"'"+strRoleName+"'");
            statement.close();
        }catch(SQLException e){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex3){
            }
            
            throw new DaoException(ExceptionConstants.STATEMENT_EXCUTE_ERROR +e.getMessage());
        }
        try{
            for(i=0;i<=vecPopedom.size()-1;i++){
                pRolePopedomVO.setRoleName(strRoleName);
                pRolePopedomVO.setPopedomName(((PRolePopedomVO)vecPopedom.get(i)).getPopedomName());
                iRoleDAO.insert(conn,pRolePopedomVO);
            }
        }catch(DaoException e){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex3){
            }
            throw e;
        }
        try{
            conn.commit();
            conn.setAutoCommit(true);
        }catch(SQLException e){
            try{
                conn.rollback();
                conn.setAutoCommit(true);
            }catch(Exception ex3){
            }
            
            throw new DaoException(ExceptionConstants.SET_COMMIT_ERROR);
        }
    }
    
    public PPopedomVO findRoleByName(Connection conn,String RoleName)throws DaoException{
        PPopedomVO pPopedomVO = new PPopedomVO();
        pPopedomVO = iRoleDAO2.findByPrimaryKey(conn,RoleName);
        return pPopedomVO;
    }
    
    public Collection findPopedomByRoleName(Connection conn,String RoleName) throws DaoException{
        Vector vecPopedomVO = new Vector();
        vecPopedomVO = (Vector)iRoleDAO.findByRole_Name(conn, RoleName);
        System.out.print(vecPopedomVO.size());
        return vecPopedomVO;
    }
    
    public Collection findRoleByAll(Connection conn) throws DaoException{
        Vector vecRoleVO = new Vector();
        Vector vecRoleVO2 = new Vector();
        int i=0;
        vecRoleVO = (Vector)iRoleDAO2.findByPopedom_Type(conn, Constants.TYPEROLE);
        vecRoleVO2 = (Vector)iRoleDAO2.findByPopedom_Type(conn, Constants.TYPEADMIN);
        for(i=0;i<vecRoleVO2.size();i++){
            vecRoleVO.addElement(vecRoleVO2.get(i));
        }
        return vecRoleVO;
    }
    
    public Collection findPopedomByAll(Connection conn) throws DaoException {
        Vector vecPopedoms = new Vector();
        vecPopedoms = (Vector)iRoleDAO2.findByPopedom_Type(conn,"S");
        return vecPopedoms;
    }
    
}
