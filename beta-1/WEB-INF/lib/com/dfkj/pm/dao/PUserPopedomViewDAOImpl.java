
package com.dfkj.pm.dao;



import java.sql.*;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.data.*;
import com.dfkj.pm.vo.PUserPopedomViewVO;
import java.util.*;

public class PUserPopedomViewDAOImpl implements  IPUserPopedomViewDAO
{
  public PUserPopedomViewVO findByPrimaryKey(Connection transConn,java.lang.String  userName,java.lang.String  popedomName) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    PUserPopedomViewVO pUserPopedomViewVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_name , popedom_name FROM  p_user_popedom_view WHERE  user_name = ?  AND  popedom_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userName));
       statement.setString(2, DaoUtil.NullToStr(popedomName));
       
       rs = statement.executeQuery();
       if (rs.next())
       {
         pUserPopedomViewVO = new PUserPopedomViewVO();
         pUserPopedomViewVO.setUserName(rs.getString("user_name"));
         pUserPopedomViewVO.setPopedomName(rs.getString("popedom_name"));
       }
       else
       {
          throw new ObjectNotFoundException("Row does not exist.");
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , popedom_name FROM  p_user_popedom_view WHERE  user_name = ?  AND  popedom_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return pUserPopedomViewVO;
  }

  public java.util.Collection findAll(Connection transConn) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PUserPopedomViewVO pUserPopedomViewVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_name , popedom_name FROM  p_user_popedom_view");
       
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserPopedomViewVO = new PUserPopedomViewVO();
         pUserPopedomViewVO.setUserName(rs.getString("user_name"));
         pUserPopedomViewVO.setPopedomName(rs.getString("popedom_name"));
         result.add(pUserPopedomViewVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , popedom_name FROM  p_user_popedom_view" + e.getMessage());
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
    PUserPopedomViewVO pUserPopedomViewVO = null;
    try
    {
       conn = transConn;
       
       
       sql = " SELECT user_name , popedom_name FROM  p_user_popedom_view";
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
          fieldValue = condition.getProperty("POPEDOM_NAME");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND popedom_name =  ?  ";
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
         pUserPopedomViewVO = new PUserPopedomViewVO();
         pUserPopedomViewVO.setUserName(rs.getString("user_name"));
         pUserPopedomViewVO.setPopedomName(rs.getString("popedom_name"));
         result.add(pUserPopedomViewVO);
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

  public java.util.Collection findByUser_Name(Connection transConn, java.lang.String userName ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PUserPopedomViewVO pUserPopedomViewVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_name , popedom_name FROM  p_user_popedom_view WHERE 1=1  AND user_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(userName));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserPopedomViewVO = new PUserPopedomViewVO();
         pUserPopedomViewVO.setUserName(rs.getString("user_name"));
         pUserPopedomViewVO.setPopedomName(rs.getString("popedom_name"));
         result.add(pUserPopedomViewVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , popedom_name FROM  p_user_popedom_view WHERE 1=1  AND user_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }

  public java.util.Collection findByPopedom_Name(Connection transConn, java.lang.String popedomName ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PUserPopedomViewVO pUserPopedomViewVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT user_name , popedom_name FROM  p_user_popedom_view WHERE 1=1  AND popedom_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(popedomName));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pUserPopedomViewVO = new PUserPopedomViewVO();
         pUserPopedomViewVO.setUserName(rs.getString("user_name"));
         pUserPopedomViewVO.setPopedomName(rs.getString("popedom_name"));
         result.add(pUserPopedomViewVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT user_name , popedom_name FROM  p_user_popedom_view WHERE 1=1  AND popedom_name = ? " + e.getMessage());
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
