
package com.dfkj.eoa.dao;



import java.sql.*;
import com.dfkj.exception.*;
import com.dfkj.data.*;
import com.dfkj.eoa.vo.EoaUsersVO;
import java.util.*;

public class EoaUsersDAOImpl implements  IEoaUsersDAO
{

  public void insert(Connection transConn,EoaUsersVO eoaUsersVO) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Insert begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       //根据所选条件判断数据是否存在
       try
       {
          daoFindSame(conn);
          throw new DuplicateDataException("Primary key already exists");
       }
       catch(ObjectNotFoundException objectNotFoundE)
       {
       
       }
       
       statement = conn.prepareStatement("INSERT INTO eoa_users(user_id , user_name , description , password , dept_id , enabled , position , queue , admin , on_line , remark) VALUES( ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  )");
       
       statement.setString(1, DaoUtil.NullToStr(DBUtil.getSeqFromID("S_USER_ID",conn)));
       statement.setString(2, DaoUtil.NullToStr(eoaUsersVO.getUserName()));
       statement.setString(3, DaoUtil.NullToStr(eoaUsersVO.getDescription()));
       statement.setString(4, DaoUtil.NullToStr(eoaUsersVO.getPassword()));
       statement.setString(5, DaoUtil.NullToStr(eoaUsersVO.getDeptId()));
       statement.setString(6, DaoUtil.NullToStr(eoaUsersVO.getEnabled()));
       statement.setString(7, DaoUtil.NullToStr(eoaUsersVO.getPosition()));
       statement.setString(8, DaoUtil.NullToStr(eoaUsersVO.getQueue()));
       statement.setString(9, DaoUtil.NullToStr(eoaUsersVO.getAdmin()));
       statement.setString(10, DaoUtil.NullToStr(eoaUsersVO.getOnLine()));
       statement.setString(11, DaoUtil.NullToStr(eoaUsersVO.getRemark()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  DaoException("Error adding row.");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL INSERT INTO eoa_users(user_id , user_name , description , password , dept_id , enabled , position , queue , admin , on_line , remark) VALUES( ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  )" + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Insert end");
  }

  public void update(Connection transConn,EoaUsersVO eoaUsersVO) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Update begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" UPDATE  eoa_users SET user_id = ?  , user_name = ?  , description = ?  , password = ?  , dept_id = ?  , enabled = ?  , position = ?  , queue = ?  , admin = ?  , on_line = ?  , remark = ?  WHERE  user_id = ? ");
       
       statement.setString(1, DaoUtil.NullToStr(eoaUsersVO.getUserId()));
       statement.setString(2, DaoUtil.NullToStr(eoaUsersVO.getUserName()));
       statement.setString(3, DaoUtil.NullToStr(eoaUsersVO.getDescription()));
       statement.setString(4, DaoUtil.NullToStr(eoaUsersVO.getPassword()));
       statement.setString(5, DaoUtil.NullToStr(eoaUsersVO.getDeptId()));
       statement.setString(6, DaoUtil.NullToStr(eoaUsersVO.getEnabled()));
       statement.setString(7, DaoUtil.NullToStr(eoaUsersVO.getPosition()));
       statement.setString(8, DaoUtil.NullToStr(eoaUsersVO.getQueue()));
       statement.setString(9, DaoUtil.NullToStr(eoaUsersVO.getAdmin()));
       statement.setString(10, DaoUtil.NullToStr(eoaUsersVO.getOnLine()));
       statement.setString(11, DaoUtil.NullToStr(eoaUsersVO.getRemark()));
       
       //条件
       statement.setString(12, DaoUtil.NullToStr(eoaUsersVO.getUserId()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  ObjectNotFoundException("Error updating row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  UPDATE  eoa_users SET user_id = ?  , user_name = ?  , description = ?  , password = ?  , dept_id = ?  , enabled = ?  , position = ?  , queue = ?  , admin = ?  , on_line = ?  , remark = ?  WHERE  user_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Update end");
  }

  public void delete(Connection transConn,java.lang.String  userId) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Delete begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" DELETE  eoa_users WHERE  user_id = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userId));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  RemoveException("Error deleting row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  DELETE  eoa_users WHERE  user_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Delete end");
  }

  public EoaUsersVO findByPrimaryKey(Connection transConn,java.lang.String  userId) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    EoaUsersVO eoaUsersVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_id , user_name , description , password , dept_id , enabled , position , queue , admin , on_line , remark FROM  eoa_users WHERE  user_id = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userId));
       
       rs = statement.executeQuery();
       if (rs.next())
       {
         eoaUsersVO = new EoaUsersVO();
         eoaUsersVO.setUserId(rs.getString("user_id"));
         eoaUsersVO.setUserName(rs.getString("user_name"));
         eoaUsersVO.setDescription(rs.getString("description"));
         eoaUsersVO.setPassword(rs.getString("password"));
         eoaUsersVO.setDeptId(rs.getString("dept_id"));
         eoaUsersVO.setEnabled(rs.getString("enabled"));
         eoaUsersVO.setPosition(rs.getString("position"));
         eoaUsersVO.setQueue(rs.getString("queue"));
         eoaUsersVO.setAdmin(rs.getString("admin"));
         eoaUsersVO.setOnLine(rs.getString("on_line"));
         eoaUsersVO.setRemark(rs.getString("remark"));
       }
       else
       {
          throw new ObjectNotFoundException("Row does not exist.");
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_id , user_name , description , password , dept_id , enabled , position , queue , admin , on_line , remark FROM  eoa_users WHERE  user_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return eoaUsersVO;
  }

  public java.util.Collection findAll(Connection transConn) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    EoaUsersVO eoaUsersVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_id , user_name , description , password , dept_id , enabled , position , queue , admin , on_line , remark FROM  eoa_users");
       
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         eoaUsersVO = new EoaUsersVO();
         eoaUsersVO.setUserId(rs.getString("user_id"));
         eoaUsersVO.setUserName(rs.getString("user_name"));
         eoaUsersVO.setDescription(rs.getString("description"));
         eoaUsersVO.setPassword(rs.getString("password"));
         eoaUsersVO.setDeptId(rs.getString("dept_id"));
         eoaUsersVO.setEnabled(rs.getString("enabled"));
         eoaUsersVO.setPosition(rs.getString("position"));
         eoaUsersVO.setQueue(rs.getString("queue"));
         eoaUsersVO.setAdmin(rs.getString("admin"));
         eoaUsersVO.setOnLine(rs.getString("on_line"));
         eoaUsersVO.setRemark(rs.getString("remark"));
         result.add(eoaUsersVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_id , user_name , description , password , dept_id , enabled , position , queue , admin , on_line , remark FROM  eoa_users" + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }
  public java.util.Collection findByCondition(Connection transConn,java.util.Properties condition) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    Vector fieldList = new Vector();
    String sql = "";
    EoaUsersVO eoaUsersVO = null;
    try
    {
       conn = transConn;
       
       
       sql = " SELECT id , user_name , description , password , department_id , enabled , position , queue , admin , on_line , remark FROM  eoa_users";
       String whereClause = " WHERE 1=1 ";
       String fieldValue = null;
       //输出查询条件
       if (condition != null)
       {
          fieldValue = condition.getProperty("USER_ID");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND user_id =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("USER_NAME");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND user_name =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("DESCRIPTION");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND description =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("PASSWORD");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND password =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("DEPT_ID");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND department_id =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("ENABLED");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND enabled =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("POSITION");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND position =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("QUEUE");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND queue =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("ADMIN");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND admin =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("ON_LINE");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND on_line =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("REMARK");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND remark =  ?  ";
             fieldList.add(fieldValue);
          }
       }
       sql += whereClause;
       //查询条件完毕
       
       statement = conn.prepareStatement(sql);
       
       for(int i=0; i<fieldList.size(); i++)
       {
          statement.setString(i+1,(String)fieldList.elementAt(i));
       }
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         eoaUsersVO = new EoaUsersVO();
         eoaUsersVO.setUserId(rs.getString("id"));
         eoaUsersVO.setUserName(rs.getString("user_name"));
         eoaUsersVO.setDescription(rs.getString("description"));
         eoaUsersVO.setPassword(rs.getString("password"));
         eoaUsersVO.setDeptId(rs.getString("department_id"));
         eoaUsersVO.setEnabled(rs.getString("enabled"));
         eoaUsersVO.setPosition(rs.getString("position"));
         eoaUsersVO.setQueue(rs.getString("queue"));
         eoaUsersVO.setAdmin(rs.getString("admin"));
         eoaUsersVO.setOnLine(rs.getString("on_line"));
         eoaUsersVO.setRemark(rs.getString("remark"));
         result.add(eoaUsersVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL"  + sql + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }
  private void daoFindSame(Connection transConn) throws DaoException
  {
    throw new ObjectNotFoundException("没有发现相同的数据！");
  }
}
