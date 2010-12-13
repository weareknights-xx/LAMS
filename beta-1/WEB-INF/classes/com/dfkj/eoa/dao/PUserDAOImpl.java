
package com.dfkj.eoa.dao;



import java.sql.*;
import com.dfkj.exception.*;
import com.dfkj.data.*;
import com.dfkj.eoa.vo.PUserVO;
import java.util.*;

public class PUserDAOImpl implements  IPUserDAO
{

  public void insert(Connection transConn,PUserVO pUserVO) throws DaoException
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
       
       statement = conn.prepareStatement("INSERT INTO p_user(user_id , user_name , user_description , password , user_enabled , admin , department_id , region_id , employee_id , position , queue , on_line , remark , email_address) VALUES( ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  )");
       
       statement.setString(1, DaoUtil.NullToStr(DBUtil.getSeqFromID("S_USER_ID",conn)));
       statement.setString(2, DaoUtil.NullToStr(pUserVO.getUserName()));
       statement.setString(3, DaoUtil.NullToStr(pUserVO.getUserDescription()));
       statement.setString(4, DaoUtil.NullToStr(pUserVO.getPassword()));
       statement.setString(5, DaoUtil.NullToStr(pUserVO.getUserEnabled()));
       statement.setString(6, DaoUtil.NullToStr(pUserVO.getAdmin()));
       statement.setString(7, DaoUtil.NullToStr(pUserVO.getDepartmentId()));
       statement.setString(8, DaoUtil.NullToStr(pUserVO.getRegionId()));
       statement.setString(9, DaoUtil.NullToStr(pUserVO.getEmployeeId()));
       statement.setString(10, DaoUtil.NullToStr(pUserVO.getPosition()));
       statement.setString(11, DaoUtil.NullToStr(pUserVO.getQueue()));
       statement.setString(12, DaoUtil.NullToStr(pUserVO.getOnLine()));
       statement.setString(13, DaoUtil.NullToStr(pUserVO.getRemark()));
       statement.setString(14, DaoUtil.NullToStr(pUserVO.getEmailAddress()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  DaoException("Error adding row.");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL INSERT INTO p_user(user_id , user_name , user_description , password , user_enabled , admin , department_id , region_id , employee_id , position , queue , on_line , remark , email_address) VALUES( ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  )" + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Insert end");
  }

  public void update(Connection transConn,PUserVO pUserVO) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Update begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" UPDATE  p_user SET user_id = ?  , user_name = ?  , user_description = ?  , password = ?  , user_enabled = ?  , admin = ?  , department_id = ?  , region_id = ?  , employee_id = ?  , position = ?  , queue = ?  , on_line = ?  , remark = ?  , email_address = ?  WHERE  user_id = ? ");
       
       statement.setString(1, DaoUtil.NullToStr(pUserVO.getUserId()));
       statement.setString(2, DaoUtil.NullToStr(pUserVO.getUserName()));
       statement.setString(3, DaoUtil.NullToStr(pUserVO.getUserDescription()));
       statement.setString(4, DaoUtil.NullToStr(pUserVO.getPassword()));
       statement.setString(5, DaoUtil.NullToStr(pUserVO.getUserEnabled()));
       statement.setString(6, DaoUtil.NullToStr(pUserVO.getAdmin()));
       statement.setString(7, DaoUtil.NullToStr(pUserVO.getDepartmentId()));
       statement.setString(8, DaoUtil.NullToStr(pUserVO.getRegionId()));
       statement.setString(9, DaoUtil.NullToStr(pUserVO.getEmployeeId()));
       statement.setString(10, DaoUtil.NullToStr(pUserVO.getPosition()));
       statement.setString(11, DaoUtil.NullToStr(pUserVO.getQueue()));
       statement.setString(12, DaoUtil.NullToStr(pUserVO.getOnLine()));
       statement.setString(13, DaoUtil.NullToStr(pUserVO.getRemark()));
       statement.setString(14, DaoUtil.NullToStr(pUserVO.getEmailAddress()));
       
       //条件
       statement.setString(15, DaoUtil.NullToStr(pUserVO.getUserId()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  ObjectNotFoundException("Error updating row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  UPDATE  p_user SET user_id = ?  , user_name = ?  , user_description = ?  , password = ?  , user_enabled = ?  , admin = ?  , department_id = ?  , region_id = ?  , employee_id = ?  , position = ?  , queue = ?  , on_line = ?  , remark = ?  , email_address = ?  WHERE  user_id = ? " + e.getMessage());
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
       
       statement = conn.prepareStatement(" DELETE  p_user WHERE  user_id = ? ");
       
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
       throw new  DaoException("Error executing SQL  DELETE  p_user WHERE  user_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Delete end");
  }

  public PUserVO findByPrimaryKey(Connection transConn,java.lang.String  userId) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    PUserVO pUserVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_id , user_name , user_description , password , user_enabled , admin , department_id , region_id , employee_id , position , queue , on_line , remark , email_address FROM  p_user WHERE  user_id = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userId));
       
       rs = statement.executeQuery();
       if (rs.next())
       {
         pUserVO = new PUserVO();
         pUserVO.setUserId(rs.getString("user_id"));
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPosition(rs.getString("position"));
         pUserVO.setQueue(rs.getString("queue"));
         pUserVO.setOnLine(rs.getString("on_line"));
         pUserVO.setRemark(rs.getString("remark"));
         pUserVO.setEmailAddress(rs.getString("email_address"));
       }
       else
       {
          throw new ObjectNotFoundException("Row does not exist.");
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_id , user_name , user_description , password , user_enabled , admin , department_id , region_id , employee_id , position , queue , on_line , remark , email_address FROM  p_user WHERE  user_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return pUserVO;
  }

  public java.util.Collection findAll(Connection transConn) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PUserVO pUserVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_id , user_name , user_description , password , user_enabled , admin , department_id , region_id , employee_id , position , queue , on_line , remark , email_address FROM  p_user");
       
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserVO = new PUserVO();
         pUserVO.setUserId(rs.getString("user_id"));
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPosition(rs.getString("position"));
         pUserVO.setQueue(rs.getString("queue"));
         pUserVO.setOnLine(rs.getString("on_line"));
         pUserVO.setRemark(rs.getString("remark"));
         pUserVO.setEmailAddress(rs.getString("email_address"));
         result.add(pUserVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_id , user_name , user_description , password , user_enabled , admin , department_id , region_id , employee_id , position , queue , on_line , remark , email_address FROM  p_user" + e.getMessage());
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
    PUserVO pUserVO = null;
    try
    {
       conn = transConn;
       
       
       sql = " SELECT a.user_id , a.user_name , a.user_description , a.password , a.user_enabled , a.admin , a.department_id , a.region_id , a.employee_id , a.position , a.queue , a.on_line , a.remark , a.email_address, b.dept_name  FROM  p_user a,eoa_dept b ";
       String whereClause = " WHERE 1=1 AND a.department_id = b.dept_id ";
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
          fieldValue = condition.getProperty("USER_DESCRIPTION");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND user_description =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("PASSWORD");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND password =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("USER_ENABLED");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND user_enabled =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("ADMIN");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND admin =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("DEPARTMENT_ID");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND department_id =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("REGION_ID");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND region_id =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("EMPLOYEE_ID");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND employee_id =  ?  ";
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
          fieldValue = condition.getProperty("EMAIL_ADDRESS");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND email_address =  ?  ";
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
         pUserVO = new PUserVO();
         pUserVO.setUserId(rs.getString("user_id"));
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPosition(rs.getString("position"));
         pUserVO.setQueue(rs.getString("queue"));
         pUserVO.setOnLine(rs.getString("on_line"));
         pUserVO.setRemark(rs.getString("remark"));
         pUserVO.setEmailAddress(rs.getString("email_address"));
         pUserVO.setDepartmentName(rs.getString("dept_name"));
         result.add(pUserVO);
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
