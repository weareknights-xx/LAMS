
package com.dfkj.pm.dao;



import java.sql.Connection;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.vo.PUserRoleVO;
import java.util.Collection;

public interface IPUserRoleDAO 
{

  public void insert(Connection transConn,PUserRoleVO pUserRoleVO) throws DaoException;

  public void update(Connection transConn,PUserRoleVO pUserRoleVO) throws DaoException;

  public void delete(Connection transConn,java.lang.String  userName,java.lang.String  roleName) throws DaoException;

  public PUserRoleVO findByPrimaryKey(Connection transConn,java.lang.String  userName,java.lang.String  roleName) throws DaoException;

  public java.util.Collection findAll(Connection transConn) throws DaoException;

  public java.util.Collection findByCondition(Connection transConn,java.util.Properties condition) throws DaoException;

  public java.util.Collection findByUser_Name(Connection transConn, java.lang.String userName ) throws DaoException;

  public java.util.Collection findByRole_Name(Connection transConn, java.lang.String roleName ) throws DaoException;
}
