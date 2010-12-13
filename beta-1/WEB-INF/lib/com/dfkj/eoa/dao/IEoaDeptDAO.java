
package com.dfkj.eoa.dao;



import java.sql.Connection;

import com.dfkj.exception.DaoException;
import com.dfkj.eoa.vo.EoaDeptVO;
import java.util.Collection;
import java.util.Properties;
import java.util.Vector;

public interface IEoaDeptDAO 
{

  public void insert(Connection transConn,EoaDeptVO eoaDeptVO) throws DaoException;

  public void update(Connection transConn,EoaDeptVO eoaDeptVO) throws DaoException;

  public String delete(Connection transConn,java.lang.String  deptId) throws DaoException;

  public EoaDeptVO findByPrimaryKey(Connection transConn,java.lang.String  deptId) throws DaoException;

  public java.util.Collection findAll(Connection transConn) throws DaoException;

  public java.util.Collection findByCondition(Connection transConn,java.util.Properties condition) throws DaoException;
  
  public Vector listTree(Properties proper) throws DaoException;
  
}
