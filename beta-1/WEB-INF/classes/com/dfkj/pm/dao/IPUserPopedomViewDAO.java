
package com.dfkj.pm.dao;


import java.sql.Connection;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.vo.PUserPopedomViewVO;
import java.util.Collection;

public interface IPUserPopedomViewDAO 
{

  public PUserPopedomViewVO findByPrimaryKey(Connection transConn,java.lang.String  userName,java.lang.String  popedomName) throws DaoException;

  public java.util.Collection findAll(Connection transConn) throws DaoException;

  public java.util.Collection findByCondition(Connection transConn,java.util.Properties condition) throws DaoException;

  public java.util.Collection findByUser_Name(Connection transConn, java.lang.String userName ) throws DaoException;

  public java.util.Collection findByPopedom_Name(Connection transConn, java.lang.String popedomName ) throws DaoException;
}
