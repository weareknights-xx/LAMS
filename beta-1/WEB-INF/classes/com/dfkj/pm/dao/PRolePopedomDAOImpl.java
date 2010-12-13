
package com.dfkj.pm.dao;



import java.sql.*;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.data.*;
import com.dfkj.pm.vo.PRolePopedomVO;
import java.util.*;

public class PRolePopedomDAOImpl implements  IPRolePopedomDAO
{

  public void insert(Connection transConn,PRolePopedomVO pRolePopedomVO) throws DaoException
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
          daoFindSame(conn,DaoUtil.NullToStr(pRolePopedomVO.getRoleName()),DaoUtil.NullToStr(pRolePopedomVO.getPopedomName()));
          throw new DuplicateDataException("Primary key already exists");
       }
       catch(ObjectNotFoundException objectNotFoundE)
       {
       
       }
       
       statement = conn.prepareStatement("INSERT INTO p_role_popedom(role_name , popedom_name) VALUES( ?  ,  ?  )");
       
       statement.setString(1, DaoUtil.NullToStr(pRolePopedomVO.getRoleName()));
       statement.setString(2, DaoUtil.NullToStr(pRolePopedomVO.getPopedomName()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  DaoException("Error adding row.");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL INSERT INTO p_role_popedom(role_name , popedom_name) VALUES( ?  ,  ?  )" + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Insert end");
  }

  public void update(Connection transConn,PRolePopedomVO pRolePopedomVO) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Update begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" UPDATE  p_role_popedom SET role_name = ?  , popedom_name = ?  WHERE  role_name = ?  AND  popedom_name = ? ");
       
       statement.setString(1, DaoUtil.NullToStr(pRolePopedomVO.getRoleName()));
       statement.setString(2, DaoUtil.NullToStr(pRolePopedomVO.getPopedomName()));
       
       //条件
       statement.setString(3, DaoUtil.NullToStr(pRolePopedomVO.getRoleName()));
       statement.setString(4, DaoUtil.NullToStr(pRolePopedomVO.getPopedomName()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  ObjectNotFoundException("Error updating row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  UPDATE  p_role_popedom SET role_name = ?  , popedom_name = ?  WHERE  role_name = ?  AND  popedom_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Update end");
  }

  public void delete(Connection transConn,java.lang.String  roleName,java.lang.String  popedomName) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Delete begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" DELETE  p_role_popedom WHERE  role_name = ?  AND  popedom_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(roleName));
       statement.setString(2, DaoUtil.NullToStr(popedomName));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  RemoveException("Error deleting row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  DELETE  p_role_popedom WHERE  role_name = ?  AND  popedom_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Delete end");
  }

  public PRolePopedomVO findByPrimaryKey(Connection transConn,java.lang.String  roleName,java.lang.String  popedomName) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    PRolePopedomVO pRolePopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT role_name , popedom_name FROM  p_role_popedom WHERE  role_name = ?  AND  popedom_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(roleName));
       statement.setString(2, DaoUtil.NullToStr(popedomName));
       
       rs = statement.executeQuery();
       if (rs.next())
       {
         pRolePopedomVO = new PRolePopedomVO();
         pRolePopedomVO.setRoleName(rs.getString("role_name"));
         pRolePopedomVO.setPopedomName(rs.getString("popedom_name"));
       }
       else
       {
          throw new ObjectNotFoundException("Row does not exist.");
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT role_name , popedom_name FROM  p_role_popedom WHERE  role_name = ?  AND  popedom_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return pRolePopedomVO;
  }

  public java.util.Collection findAll(Connection transConn) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PRolePopedomVO pRolePopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT role_name , popedom_name FROM  p_role_popedom");
       
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pRolePopedomVO = new PRolePopedomVO();
         pRolePopedomVO.setRoleName(rs.getString("role_name"));
         pRolePopedomVO.setPopedomName(rs.getString("popedom_name"));
         result.add(pRolePopedomVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT role_name , popedom_name FROM  p_role_popedom" + e.getMessage());
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
    PRolePopedomVO pRolePopedomVO = null;
    try
    {
       conn = transConn;
       
       
       sql = " SELECT role_name , popedom_name FROM  p_role_popedom";
       String whereClause = " WHERE 1=1 ";
       String fieldValue = null;
       //输出查询条件
       if (condition != null)
       {
          fieldValue = condition.getProperty("ROLE_NAME");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND role_name =  ?  ";
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
         pRolePopedomVO = new PRolePopedomVO();
         pRolePopedomVO.setRoleName(rs.getString("role_name"));
         pRolePopedomVO.setPopedomName(rs.getString("popedom_name"));
         result.add(pRolePopedomVO);
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
  private void daoFindSame(Connection transConn, java.lang.String roleName , java.lang.String popedomName ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PRolePopedomVO pRolePopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT role_name , popedom_name FROM  p_role_popedom WHERE 1=1  AND role_name = ?  AND popedom_name = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(roleName));
       statement.setString(2, DaoUtil.NullToStr(popedomName));
       
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
       throw new  DaoException("Error executing SQL  SELECT role_name , popedom_name FROM  p_role_popedom WHERE 1=1  AND role_name = ?  AND popedom_name = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
  }

  public java.util.Collection findByRole_Name(Connection transConn, java.lang.String roleName ) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    PRolePopedomVO pRolePopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT role_name , popedom_name FROM  p_role_popedom WHERE 1=1  AND role_name = ?  ORDER BY 1,2 ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(roleName));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pRolePopedomVO = new PRolePopedomVO();
         pRolePopedomVO.setRoleName(rs.getString("role_name"));
         pRolePopedomVO.setPopedomName(rs.getString("popedom_name"));
         result.add(pRolePopedomVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT role_name , popedom_name FROM  p_role_popedom WHERE 1=1  AND role_name = ?  ORDER BY 1,2 " + e.getMessage());
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
    PRolePopedomVO pRolePopedomVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT role_name , popedom_name FROM  p_role_popedom WHERE 1=1  AND popedom_name = ?  ORDER BY 2,1 ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(popedomName));
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         pRolePopedomVO = new PRolePopedomVO();
         pRolePopedomVO.setRoleName(rs.getString("role_name"));
         pRolePopedomVO.setPopedomName(rs.getString("popedom_name"));
         result.add(pRolePopedomVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT role_name , popedom_name FROM  p_role_popedom WHERE 1=1  AND popedom_name = ?  ORDER BY 2,1 " + e.getMessage());
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
