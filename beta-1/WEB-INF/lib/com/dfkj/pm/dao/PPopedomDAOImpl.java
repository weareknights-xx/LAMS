
package com.dfkj.pm.dao;



import java.sql.*;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.data.*;
import com.dfkj.pm.vo.PPopedomVO;
import java.util.*;

public class PPopedomDAOImpl implements  IPPopedomDAO
{

  public void insert(Connection transConn,PPopedomVO pPopedomVO) throws DaoException
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
          daoFindSame(conn,DaoUtil.NullToStr(pPopedomVO.getPopedomName()));
          throw new DuplicateDataException("该角色已存在!");
       }
       catch(ObjectNotFoundException objectNotFoundE)
       {
       
       }
       
       statement = conn.prepareStatement("INSERT INTO p_popedom(popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action) VALUES( ?  ,  ?  ,  ?  ,  ?  ,  ?  )");
       
       statement.setString(1, DaoUtil.NullToStr(pPopedomVO.getPopedomName()));
       statement.setString(2, DaoUtil.NullToStr(pPopedomVO.getPopedomAlias()));
       statement.setString(3, DaoUtil.NullToStr(pPopedomVO.getPopedomType()));
       statement.setString(4, DaoUtil.NullToStr(pPopedomVO.getPopedomSort()));
       statement.setString(5, DaoUtil.NullToStr(pPopedomVO.getPopedomAction()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  DaoException("Error adding row.");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL INSERT INTO p_popedom(popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action) VALUES( ?  ,  ?  ,  ?  ,  ?  ,  ?  )" + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Insert end");
  }

  public void update(Connection transConn,PPopedomVO pPopedomVO) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Update begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" UPDATE  p_popedom SET popedom_name = ?  , popedom_alias = ?  , popedom_type = ?  , popedom_sort = ?  , popedom_action = ?  WHERE  popedom_name = ? ");
       
       statement.setString(1, DaoUtil.NullToStr(pPopedomVO.getPopedomName()));
       statement.setString(2, DaoUtil.NullToStr(pPopedomVO.getPopedomAlias()));
       statement.setString(3, DaoUtil.NullToStr(pPopedomVO.getPopedomType()));
       statement.setString(4, DaoUtil.NullToStr(pPopedomVO.getPopedomSort()));
       statement.setString(5, DaoUtil.NullToStr(pPopedomVO.getPopedomAction()));
       
       //条件
       statement.setString(6, DaoUtil.NullToStr(pPopedomVO.getPopedomName()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  ObjectNotFoundException("Error updating row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  UPDATE  p_popedom SET popedom_name = ?  , popedom_alias = ?  , popedom_type = ?  , popedom_sort = ?  , popedom_action = ?  WHERE  popedom_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Update end");
  }

  public void delete(Connection transConn,java.lang.String  popedomName) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Delete begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" DELETE  p_popedom WHERE  popedom_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(popedomName));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  RemoveException("Error deleting row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  DELETE  p_popedom WHERE  popedom_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Delete end");
  }

  public PPopedomVO findByPrimaryKey(Connection transConn, java.lang.String popedomName) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    PPopedomVO pPopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE  popedom_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(popedomName));
       
       rs = statement.executeQuery();
       if (rs.next())
       {
         pPopedomVO = new PPopedomVO();
         pPopedomVO.setPopedomName(rs.getString("popedom_name"));
         pPopedomVO.setPopedomAlias(rs.getString("popedom_alias"));
         pPopedomVO.setPopedomType(rs.getString("popedom_type"));
         pPopedomVO.setPopedomSort(rs.getString("popedom_sort"));
         pPopedomVO.setPopedomAction(rs.getString("popedom_action"));
       }
       else
       {
          throw new ObjectNotFoundException("Row does not exist.");
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE  popedom_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return pPopedomVO;
  }

  public java.util.Collection findAll(Connection transConn) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PPopedomVO pPopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom");
       
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pPopedomVO = new PPopedomVO();
         pPopedomVO.setPopedomName(rs.getString("popedom_name"));
         pPopedomVO.setPopedomAlias(rs.getString("popedom_alias"));
         pPopedomVO.setPopedomType(rs.getString("popedom_type"));
         pPopedomVO.setPopedomSort(rs.getString("popedom_sort"));
         pPopedomVO.setPopedomAction(rs.getString("popedom_action"));
         result.add(pPopedomVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom" + e.getMessage());
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
    PPopedomVO pPopedomVO = null;
    try
    {
       conn = transConn;
       
       
       sql = " SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom";
       String whereClause = " WHERE 1=1 ";
       String fieldValue = null;
       //输出查询条件
       if (condition != null)
       {
          fieldValue = condition.getProperty("POPEDOM_NAME");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND popedom_name =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("POPEDOM_ALIAS");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND popedom_alias =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("POPEDOM_TYPE");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND popedom_type =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("POPEDOM_SORT");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND popedom_sort =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("POPEDOM_ACTION");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND popedom_action =  ?  ";
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
         pPopedomVO = new PPopedomVO();
         pPopedomVO.setPopedomName(rs.getString("popedom_name"));
         pPopedomVO.setPopedomAlias(rs.getString("popedom_alias"));
         pPopedomVO.setPopedomType(rs.getString("popedom_type"));
         pPopedomVO.setPopedomSort(rs.getString("popedom_sort"));
         pPopedomVO.setPopedomAction(rs.getString("popedom_action"));
         result.add(pPopedomVO);
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
   private void daoFindSame(Connection transConn, java.lang.String popedomName ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PPopedomVO pPopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE 1=1  AND popedom_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(popedomName));
       
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
       throw new  DaoException("Error executing SQL  SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE 1=1  AND popedom_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
  }

  public java.util.Collection findByPopedom_Name(Connection transConn, java.lang.String popedomName ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PPopedomVO pPopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE 1=1  AND popedom_name = ?  ORDER BY 1,2 ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(popedomName));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pPopedomVO = new PPopedomVO();
         pPopedomVO.setPopedomName(rs.getString("popedom_name"));
         pPopedomVO.setPopedomAlias(rs.getString("popedom_alias"));
         pPopedomVO.setPopedomType(rs.getString("popedom_type"));
         pPopedomVO.setPopedomSort(rs.getString("popedom_sort"));
         pPopedomVO.setPopedomAction(rs.getString("popedom_action"));
         result.add(pPopedomVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE 1=1  AND popedom_name = ?  ORDER BY 1,2 " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }

  public java.util.Collection findByPopedom_Alias(Connection transConn, java.lang.String popedomAlias ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PPopedomVO pPopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE 1=1  AND popedom_alias = ?  ORDER BY 2 ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(popedomAlias));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pPopedomVO = new PPopedomVO();
         pPopedomVO.setPopedomName(rs.getString("popedom_name"));
         pPopedomVO.setPopedomAlias(rs.getString("popedom_alias"));
         pPopedomVO.setPopedomType(rs.getString("popedom_type"));
         pPopedomVO.setPopedomSort(rs.getString("popedom_sort"));
         pPopedomVO.setPopedomAction(rs.getString("popedom_action"));
         result.add(pPopedomVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE 1=1  AND popedom_alias = ?  ORDER BY 2 " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }

  public java.util.Collection findByPopedom_Type(Connection transConn, java.lang.String popedomType ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PPopedomVO pPopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE 1=1  AND popedom_type = ?  ORDER BY popedom_sort ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(popedomType));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pPopedomVO = new PPopedomVO();
         pPopedomVO.setPopedomName(rs.getString("popedom_name"));
         pPopedomVO.setPopedomAlias(rs.getString("popedom_alias"));
         pPopedomVO.setPopedomType(rs.getString("popedom_type"));
         pPopedomVO.setPopedomSort(rs.getString("popedom_sort"));
         pPopedomVO.setPopedomAction(rs.getString("popedom_action"));
         result.add(pPopedomVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE 1=1  AND popedom_type = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return result ;
  }

  public java.util.Collection findByPopedom_Action(Connection transConn, java.lang.String popedomAction ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PPopedomVO pPopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE 1=1  AND popedom_action = ?  ORDER BY 5 ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(popedomAction));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pPopedomVO = new PPopedomVO();
         pPopedomVO.setPopedomName(rs.getString("popedom_name"));
         pPopedomVO.setPopedomAlias(rs.getString("popedom_alias"));
         pPopedomVO.setPopedomType(rs.getString("popedom_type"));
         pPopedomVO.setPopedomSort(rs.getString("popedom_sort"));
         pPopedomVO.setPopedomAction(rs.getString("popedom_action"));
         result.add(pPopedomVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT popedom_name , popedom_alias , popedom_type , popedom_sort , popedom_action FROM  p_popedom WHERE 1=1  AND popedom_action = ?  ORDER BY 5 " + e.getMessage());
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
