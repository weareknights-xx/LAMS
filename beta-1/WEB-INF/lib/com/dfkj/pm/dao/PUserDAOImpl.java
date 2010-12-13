
package com.dfkj.pm.dao;


import java.sql.*;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.data.*;
import com.dfkj.pm.vo.PUserVO;
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
          daoFindSame(conn,DaoUtil.NullToStr(pUserVO.getUserName()));
          throw new DuplicateDataException("该用户已存在！");
       }
       catch(ObjectNotFoundException objectNotFoundE)
       {
       
       }
       
       statement = conn.prepareStatement("INSERT INTO p_user(user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id,user_id,email_address) VALUES( ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,?)");
              
       statement.setString(1, DaoUtil.NullToStr(pUserVO.getUserName()));
       statement.setString(2, DaoUtil.NullToStr(pUserVO.getUserDescription()));
       statement.setString(3, DaoUtil.NullToStr(pUserVO.getEmployeeId()));
       statement.setString(4, DaoUtil.NullToStr(pUserVO.getPassword()));
       statement.setString(5, DaoUtil.NullToStr(pUserVO.getUserEnabled()));
       statement.setString(6, DaoUtil.NullToStr(pUserVO.getAdmin()));
       statement.setString(7, DaoUtil.NullToStr(pUserVO.getRegionId()));
       statement.setString(8, DaoUtil.NullToStr(pUserVO.getDepartmentId()));
       statement.setString(9, DaoUtil.NullToStr(DBUtil.getSeqFromID("S_USER_ID",conn)));
       statement.setString(10, DaoUtil.NullToStr(pUserVO.getEmailAddress()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  DaoException("Error adding row.");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL INSERT INTO p_user(user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id,user_id) VALUES( ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?)" + e.getMessage());
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
       
       statement = conn.prepareStatement(" UPDATE  p_user SET user_name = ?  , user_description = ?  , employee_id = ?  , password = ?  , user_enabled = ?  , admin = ?  , region_id = ?  , department_id = ?  WHERE  user_name = ? ");
       
       statement.setString(1, DaoUtil.NullToStr(pUserVO.getUserName()));
       statement.setString(2, DaoUtil.NullToStr(pUserVO.getUserDescription()));
       statement.setString(3, DaoUtil.NullToStr(pUserVO.getEmployeeId()));
       statement.setString(4, DaoUtil.NullToStr(pUserVO.getPassword()));
       statement.setString(5, DaoUtil.NullToStr(pUserVO.getUserEnabled()));
       statement.setString(6, DaoUtil.NullToStr(pUserVO.getAdmin()));
       statement.setString(7, DaoUtil.NullToStr(pUserVO.getRegionId()));
       statement.setString(8, DaoUtil.NullToStr(pUserVO.getDepartmentId()));
       
       //条件
       statement.setString(9, DaoUtil.NullToStr(pUserVO.getUserName()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  ObjectNotFoundException("Error updating row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  UPDATE  p_user SET user_name = ?  , user_description = ?  , employee_id = ?  , password = ?  , user_enabled = ?  , admin = ?  , region_id = ?  , department_id = ?  WHERE  user_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Update end");
  }

  public void delete(Connection transConn,java.lang.String  userName) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Delete begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" DELETE  p_user WHERE  user_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userName));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  RemoveException("Error deleting row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  DELETE  p_user WHERE  user_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Delete end");
  }

  public PUserVO findByPrimaryKey(Connection transConn,java.lang.String  userName) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    PUserVO pUserVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_id,on_line,email_address,user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE  user_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userName));
       
       rs = statement.executeQuery();
       if (rs.next())
       {
         pUserVO = new PUserVO();
         pUserVO.setUserId(rs.getString("user_id"));
         pUserVO.setOnLine(rs.getString("on_line"));
         pUserVO.setEmailAddress(rs.getString("email_address"));
         
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
       }
       else
       {
          throw new ObjectNotFoundException("Row does not exist.");
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE  user_name = ? " + e.getMessage());
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
       
       statement = conn.prepareStatement(" SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user");
       
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserVO = new PUserVO();
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         result.add(pUserVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user" + e.getMessage());
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
       
       
       sql = " SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user";
       String whereClause = " WHERE 1=1 ";
       String fieldValue = null;
       //输出查询条件
       if (condition != null)
       {
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
          fieldValue = condition.getProperty("EMPLOYEE_ID");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND employee_id =  ?  ";
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
          fieldValue = condition.getProperty("REGION_ID");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND region_id =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("DEPARTMENT_ID");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND department_id =  ?  ";
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
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
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
  
  private void daoFindSame(Connection transConn, java.lang.String userName ) throws DaoException
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
       
       statement = conn.prepareStatement(" SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND user_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userName));
       
       rs = statement.executeQuery();
       if  (!rs.next())
       {
          //有相同的数据，抛出异常
          throw new ObjectNotFoundException("没有发现相同的数据！");
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND user_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
  }


  public java.util.Collection findByUser_Name(Connection transConn, java.lang.String userName ) throws DaoException
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
       
       statement = conn.prepareStatement(" SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND user_name = ?  ORDER BY 1 ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userName));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserVO = new PUserVO();
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         result.add(pUserVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND user_name = ?  ORDER BY 1 " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }

  public java.util.Collection findByEmployee_ID(Connection transConn, java.lang.String employeeId ) throws DaoException
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
       
       statement = conn.prepareStatement(" SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND employee_id = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(employeeId));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserVO = new PUserVO();
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         result.add(pUserVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND employee_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }

  public java.util.Collection findByUser_Enabled(Connection transConn, java.lang.String userEnabled ) throws DaoException
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
       
       statement = conn.prepareStatement(" SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND user_enabled = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userEnabled));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserVO = new PUserVO();
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         result.add(pUserVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND user_enabled = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }
  public java.util.Collection findByAdmin(Connection transConn, java.lang.String admin ) throws DaoException
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
       
       statement = conn.prepareStatement(" SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND admin = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(admin));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserVO = new PUserVO();
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         result.add(pUserVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND admin = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }

  public java.util.Collection findByRegion_ID(Connection transConn, java.lang.String regionId ) throws DaoException
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
       
       statement = conn.prepareStatement(" SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND region_id = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(regionId));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserVO = new PUserVO();
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         result.add(pUserVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND region_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }


  public java.util.Collection findByDepartment_ID(Connection transConn, java.lang.String departmentId ) throws DaoException
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
       
       statement = conn.prepareStatement(" SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND department_id = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(departmentId));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserVO = new PUserVO();
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         result.add(pUserVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE 1=1  AND department_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }

  
  public java.util.Collection findByRegion_ID(Connection transConn, java.util.Vector regionId) throws DaoException {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    Statement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PUserVO pUserVO = null;
    String sql=null;
    int i=0;
    
    try{
        conn=transConn;
        sql="SELECT user_name , user_description , employee_id , password , user_enabled , admin , region_id , department_id FROM  p_user WHERE region_id in (";
        for(i=0;i<regionId.size();i++){
            sql=sql+regionId.elementAt(i).toString();
        }
        sql=sql+")";
        statement = conn.createStatement();
        //statement = conn.prepareStatement(" SELECT user_name , user_description , employee_id , password , user_enabled , region_id , department_id FROM  p_user WHERE 1=1  AND region_id = ? ");
        rs=statement.executeQuery(sql);
        while (rs.next()){
         pUserVO = new PUserVO();
         pUserVO.setUserName(rs.getString("user_name"));
         pUserVO.setUserDescription(rs.getString("user_description"));
         pUserVO.setEmployeeId(rs.getString("employee_id"));
         pUserVO.setPassword(rs.getString("password"));
         pUserVO.setUserEnabled(rs.getString("user_enabled"));
         pUserVO.setAdmin(rs.getString("admin"));
         pUserVO.setRegionId(rs.getString("region_id"));
         pUserVO.setDepartmentId(rs.getString("department_id"));
         result.add(pUserVO);
       }
    }catch(SQLException e){
        Debug.println(e.getMessage());
        throw new  DaoException(sql +"with error:"+ e.getMessage());
    }finally{
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }
  
}
