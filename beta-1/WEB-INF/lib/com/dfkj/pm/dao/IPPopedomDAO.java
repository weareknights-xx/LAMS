
package com.dfkj.pm.dao;



import java.sql.Connection;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.vo.PPopedomVO;
import java.util.Collection;

public interface IPPopedomDAO 
{

  public void insert(Connection transConn,PPopedomVO pPopedomVO) throws DaoException;

  public void update(Connection transConn,PPopedomVO pPopedomVO) throws DaoException;

  public void delete(Connection transConn,java.lang.String  popedomName) throws DaoException;

  public PPopedomVO findByPrimaryKey(Connection transConn,java.lang.String  popedomName) throws DaoException;

  public java.util.Collection findAll(Connection transConn) throws DaoException;

  public java.util.Collection findByCondition(Connection transConn,java.util.Properties condition) throws DaoException;

  public java.util.Collection findByPopedom_Name(Connection transConn, java.lang.String popedomName ) throws DaoException;

  public java.util.Collection findByPopedom_Alias(Connection transConn, java.lang.String popedomAlias ) throws DaoException;

  public java.util.Collection findByPopedom_Type(Connection transConn, java.lang.String popedomType ) throws DaoException;

  public java.util.Collection findByPopedom_Action(Connection transConn, java.lang.String popedomAction ) throws DaoException;
}
