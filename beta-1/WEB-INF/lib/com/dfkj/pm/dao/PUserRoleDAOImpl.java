
package com.dfkj.pm.dao;



import java.sql.*;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.data.*;
import com.dfkj.pm.vo.PUserRoleVO;
import java.util.*;

public class PUserRoleDAOImpl implements  IPUserRoleDAO
{

  public void insert(Connection transConn,PUserRoleVO pUserRoleVO) throws DaoException
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
          daoFindSame(conn,DaoUtil.NullToStr(pUserRoleVO.getUserName()),DaoUtil.NullToStr(pUserRoleVO.getRoleName()));
          throw new DuplicateDataException("Primary key already exists");
       }
       catch(ObjectNotFoundException objectNotFoundE)
       {
       
       }
       
       statement = conn.prepareStatement("INSERT INTO p_user_role(user_name , role_name) VALUES( ?  ,  ?  )");
       
       statement.setString(1, DaoUtil.NullToStr(pUserRoleVO.getUserName()));
       statement.setString(2, DaoUtil.NullToStr(pUserRoleVO.getRoleName()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  DaoException("Error adding row.");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL INSERT INTO p_user_role(user_name , role_name) VALUES( ?  ,  ?  )" + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Insert end");
  }

  public void update(Connection transConn,PUserRoleVO pUserRoleVO) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Update begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" UPDATE  p_user_role SET user_name = ?  , role_name = ?  WHERE  user_name = ?  AND  role_name = ? ");
       
       statement.setString(1, DaoUtil.NullToStr(pUserRoleVO.getUserName()));
       statement.setString(2, DaoUtil.NullToStr(pUserRoleVO.getRoleName()));
       
       //条件
       statement.setString(3, DaoUtil.NullToStr(pUserRoleVO.getUserName()));
       statement.setString(4, DaoUtil.NullToStr(pUserRoleVO.getRoleName()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  ObjectNotFoundException("Error updating row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  UPDATE  p_user_role SET user_name = ?  , role_name = ?  WHERE  user_name = ?  AND  role_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Update end");
  }

  public void delete(Connection transConn,java.lang.String  userName,java.lang.String  roleName) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Delete begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" DELETE  p_user_role WHERE  user_name = ?  AND  role_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userName));
       statement.setString(2, DaoUtil.NullToStr(roleName));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  RemoveException("Error deleting row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  DELETE  p_user_role WHERE  user_name = ?  AND  role_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Delete end");
  }

  public PUserRoleVO findByPrimaryKey(Connection transConn,java.lang.String  userName,java.lang.String  roleName) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    PUserRoleVO pUserRoleVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_name , role_name FROM  p_user_role WHERE  user_name = ?  AND  role_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userName));
       statement.setString(2, DaoUtil.NullToStr(roleName));
       
       rs = statement.executeQuery();
       if (rs.next())
       {
         pUserRoleVO = new PUserRoleVO();
         pUserRoleVO.setUserName(rs.getString("user_name"));
         pUserRoleVO.setRoleName(rs.getString("role_name"));
       }
       else
       {
          throw new ObjectNotFoundException("Row does not exist.");
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , role_name FROM  p_user_role WHERE  user_name = ?  AND  role_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return pUserRoleVO;
  }

  public java.util.Collection findAll(Connection transConn) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PUserRoleVO pUserRoleVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_name , role_name FROM  p_user_role");
       
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserRoleVO = new PUserRoleVO();
         pUserRoleVO.setUserName(rs.getString("user_name"));
         pUserRoleVO.setRoleName(rs.getString("role_name"));
         result.add(pUserRoleVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , role_name FROM  p_user_role" + e.getMessage());
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
    PUserRoleVO pUserRoleVO = null;
    try
    {
       conn = transConn;
       
       
       sql = " SELECT user_name , role_name FROM  p_user_role";
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
          fieldValue = condition.getProperty("ROLE_NAME");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND role_name =  ?  ";
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
         pUserRoleVO = new PUserRoleVO();
         pUserRoleVO.setUserName(rs.getString("user_name"));
         pUserRoleVO.setRoleName(rs.getString("role_name"));
         result.add(pUserRoleVO);
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
  private void daoFindSame(Connection transConn, java.lang.String userName , java.lang.String roleName ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PUserRoleVO pUserRoleVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_name , role_name FROM  p_user_role WHERE 1=1  AND user_name = ?  AND role_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userName));
       statement.setString(2, DaoUtil.NullToStr(roleName));
       
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
       throw new  DaoException("Error executing SQL  SELECT user_name , role_name FROM  p_user_role WHERE 1=1  AND user_name = ?  AND role_name = ? " + e.getMessage());
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
    PUserRoleVO pUserRoleVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_name , role_name FROM  p_user_role WHERE 1=1  AND user_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userName));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserRoleVO = new PUserRoleVO();
         pUserRoleVO.setUserName(rs.getString("user_name"));
         pUserRoleVO.setRoleName(rs.getString("role_name"));
         result.add(pUserRoleVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , role_name FROM  p_user_role WHERE 1=1  AND user_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }

  public java.util.Collection findByRole_Name(Connection transConn, java.lang.String roleName ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PUserRoleVO pUserRoleVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_name , role_name FROM  p_user_role WHERE 1=1  AND role_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(roleName));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserRoleVO = new PUserRoleVO();
         pUserRoleVO.setUserName(rs.getString("user_name"));
         pUserRoleVO.setRoleName(rs.getString("role_name"));
         result.add(pUserRoleVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , role_name FROM  p_user_role WHERE 1=1  AND role_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }
}
