
package com.dfkj.eoa.dao;



import java.sql.Connection;
import com.dfkj.exception.DaoException;
import com.dfkj.eoa.vo.PUserVO;
import java.util.Collection;

public interface IPUserDAO 
{

  public void insert(Connection transConn,PUserVO pUserVO) throws DaoException;

  public void update(Connection transConn,PUserVO pUserVO) throws DaoException;

  public void delete(Connection transConn,java.lang.String  userId) throws DaoException;

  public PUserVO findByPrimaryKey(Connection transConn,java.lang.String  userId) throws DaoException;

  public java.util.Collection findAll(Connection transConn) throws DaoException;

  public java.util.Collection findByCondition(Connection transConn,java.util.Properties condition) throws DaoException;
}
