
package com.dfkj.eoa.dao;


import java.sql.Connection;
import com.dfkj.exception.DaoException;
import com.dfkj.eoa.vo.EoaUsersVO;
import java.util.Collection;

public interface IEoaUsersDAO 
{

  public void insert(Connection transConn,EoaUsersVO eoaUsersVO) throws DaoException;

  public void update(Connection transConn,EoaUsersVO eoaUsersVO) throws DaoException;

  public void delete(Connection transConn,java.lang.String  userId) throws DaoException;

  public EoaUsersVO findByPrimaryKey(Connection transConn,java.lang.String  userId) throws DaoException;

  public java.util.Collection findAll(Connection transConn) throws DaoException;

  public java.util.Collection findByCondition(Connection transConn,java.util.Properties condition) throws DaoException;
}
