
package com.dfkj.pm.dao;



import java.sql.Connection;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.vo.PRolePopedomVO;
import java.util.Collection;

public interface IPRolePopedomDAO 
{

  public void insert(Connection transConn,PRolePopedomVO pRolePopedomVO) throws DaoException;

  public void update(Connection transConn,PRolePopedomVO pRolePopedomVO) throws DaoException;

  public void delete(Connection transConn,java.lang.String  roleName,java.lang.String  popedomName) throws DaoException;

  public PRolePopedomVO findByPrimaryKey(Connection transConn,java.lang.String  roleName,java.lang.String  popedomName) throws DaoException;

  public java.util.Collection findAll(Connection transConn) throws DaoException;

  public java.util.Collection findByCondition(Connection transConn,java.util.Properties condition) throws DaoException;

  public java.util.Collection findByRole_Name(Connection transConn, java.lang.String roleName ) throws DaoException;

  public java.util.Collection findByPopedom_Name(Connection transConn, java.lang.String popedomName ) throws DaoException;
}
