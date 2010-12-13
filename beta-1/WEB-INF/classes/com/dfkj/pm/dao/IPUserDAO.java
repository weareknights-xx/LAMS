
package com.dfkj.pm.dao;



import java.sql.Connection;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.vo.PUserVO;
import java.util.Collection;

public interface IPUserDAO 
{

  public void insert(Connection transConn,PUserVO pUserVO) throws DaoException;

  public void update(Connection transConn,PUserVO pUserVO) throws DaoException;

  public void delete(Connection transConn,java.lang.String  userName) throws DaoException;

  public PUserVO findByPrimaryKey(Connection transConn,java.lang.String  userName) throws DaoException;

  public java.util.Collection findAll(Connection transConn) throws DaoException;

  public java.util.Collection findByCondition(Connection transConn,java.util.Properties condition) throws DaoException;

  public java.util.Collection findByUser_Name(Connection transConn, java.lang.String userName ) throws DaoException;

  public java.util.Collection findByEmployee_ID(Connection transConn, java.lang.String employeeId ) throws DaoException;

  public java.util.Collection findByUser_Enabled(Connection transConn, java.lang.String userEnabled ) throws DaoException;

  public java.util.Collection findByRegion_ID(Connection transConn, java.lang.String regionId ) throws DaoException;
  
  public java.util.Collection findByRegion_ID(Connection transConn, java.util.Vector regionId) throws DaoException;

  public java.util.Collection findByDepartment_ID(Connection transConn, java.lang.String departmentId ) throws DaoException;
  
  public java.util.Collection findByAdmin(Connection transConn, java.lang.String admin )throws DaoException;
}
