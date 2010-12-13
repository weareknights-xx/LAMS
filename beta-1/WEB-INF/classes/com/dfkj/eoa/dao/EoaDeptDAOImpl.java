
package com.dfkj.eoa.dao;



import java.sql.*;
import com.dfkj.exception.*;
import com.dfkj.data.*;
import com.dfkj.eoa.vo.EoaDeptVO;
import java.util.*;
import com.dfkj.db.DbManager;

public class EoaDeptDAOImpl implements  IEoaDeptDAO
{

  public void insert(Connection transConn,EoaDeptVO eoaDeptVO) throws DaoException
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
       
       statement = conn.prepareStatement("INSERT INTO eoa_dept(dept_id , dept_name , dept_code , parent_id , dept_type , enabled , description , queue , remark) VALUES( ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  )");
       String deptId = DaoUtil.NullToStr(DBUtil.getSeqFromID("S_DEPT_ID",conn));
       statement.setString(1, deptId);
       statement.setString(2, DaoUtil.NullToStr(eoaDeptVO.getDeptName()));
       statement.setString(3, DaoUtil.NullToStr(eoaDeptVO.getDeptCode()+"/"+deptId));
       statement.setString(4, DaoUtil.NullToStr(eoaDeptVO.getParentId()));
       statement.setString(5, DaoUtil.NullToStr(eoaDeptVO.getDeptType()));
       statement.setString(6, DaoUtil.NullToStr(eoaDeptVO.getEnabled()));
       statement.setString(7, DaoUtil.NullToStr(eoaDeptVO.getDescription()));
       statement.setString(8, DaoUtil.NullToStr(eoaDeptVO.getQueue()));
       statement.setString(9, DaoUtil.NullToStr(eoaDeptVO.getRemark()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  DaoException("Error adding row.");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL INSERT INTO eoa_dept(dept_id , dept_name , dept_code , parent_id , dept_type , enabled , description , queue , remark) VALUES( ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  ,  ?  )" + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Insert end");
  }

  public void update(Connection transConn,EoaDeptVO eoaDeptVO) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Update begin");

    Connection conn = null;
    PreparedStatement statement = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" UPDATE  eoa_dept SET dept_id = ?  , dept_name = ?  , dept_code = ?  , parent_id = ?  , dept_type = ?  , enabled = ?  , description = ?  , queue = ?  , remark = ?  WHERE  dept_id = ? ");
       
       statement.setString(1, DaoUtil.NullToStr(eoaDeptVO.getDeptId()));
       statement.setString(2, DaoUtil.NullToStr(eoaDeptVO.getDeptName()));
       statement.setString(3, DaoUtil.NullToStr(eoaDeptVO.getDeptCode()));
       statement.setString(4, DaoUtil.NullToStr(eoaDeptVO.getParentId()));
       statement.setString(5, DaoUtil.NullToStr(eoaDeptVO.getDeptType()));
       statement.setString(6, DaoUtil.NullToStr(eoaDeptVO.getEnabled()));
       statement.setString(7, DaoUtil.NullToStr(eoaDeptVO.getDescription()));
       statement.setString(8, DaoUtil.NullToStr(eoaDeptVO.getQueue()));
       statement.setString(9, DaoUtil.NullToStr(eoaDeptVO.getRemark()));
       
       //条件
       statement.setString(10, DaoUtil.NullToStr(eoaDeptVO.getDeptId()));
       
       if (statement.executeUpdate() != 1)
       {
          throw new  ObjectNotFoundException("Error updating row");
       }
       
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  UPDATE  eoa_dept SET dept_id = ?  , dept_name = ?  , dept_code = ?  , parent_id = ?  , dept_type = ?  , enabled = ?  , description = ?  , queue = ?  , remark = ?  WHERE  dept_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Update end");
  }

  public String delete(Connection transConn,java.lang.String  deptId) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Delete begin");

    Connection conn = null;
    PreparedStatement statement = null;
    String flag = "true";
    try
    {
       conn = transConn;
       Vector v = null;
       Properties p = new Properties();
       p.setProperty("PARENT_ID",deptId);
       v = (Vector)findByCondition(transConn,p);
       if(v != null && v.size() > 0){
           flag = "exist";
           //throw new  RemoveException("当前要删除的部门还包含有子部门！请先删除子部门。");
       }else{
            statement = conn.prepareStatement(" DELETE  eoa_dept WHERE  dept_id = ? ");
       
            //条件
            statement.setString(1, DaoUtil.NullToStr(deptId));
       
            if (statement.executeUpdate() != 1)
            {
                throw new  RemoveException("Error deleting row");
            }
            flag = "true";
       }
    }
    catch(SQLException e)
    {
       flag = "false";
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  DELETE  eoa_dept WHERE  dept_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeStatement(statement);
       Debug.println( this.getClass().getName() + " Delete end");
       return flag;
    }

    
  }

  public EoaDeptVO findByPrimaryKey(Connection transConn,java.lang.String  deptId) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    EoaDeptVO eoaDeptVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT dept_id , dept_name , dept_code , parent_id , dept_type , enabled , description , queue , remark FROM  eoa_dept WHERE  dept_id = ? ");
       
       //条件
       statement.setString(1, DaoUtil.NullToStr(deptId));
       
       rs = statement.executeQuery();
       if (rs.next())
       {
         eoaDeptVO = new EoaDeptVO();
         eoaDeptVO.setDeptId(rs.getString("dept_id"));
         eoaDeptVO.setDeptName(rs.getString("dept_name"));
         eoaDeptVO.setDeptCode(rs.getString("dept_code"));
         eoaDeptVO.setParentId(rs.getString("parent_id"));
         eoaDeptVO.setDeptType(rs.getString("dept_type"));
         eoaDeptVO.setEnabled(rs.getString("enabled"));
         eoaDeptVO.setDescription(rs.getString("description"));
         eoaDeptVO.setQueue(rs.getString("queue"));
         eoaDeptVO.setRemark(rs.getString("remark"));
       }
       else
       {
          throw new ObjectNotFoundException("Row does not exist.");
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT dept_id , dept_name , dept_code , parent_id , dept_type , enabled , description , queue , remark FROM  eoa_dept WHERE  dept_id = ? " + e.getMessage());
    }
    finally
    {
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(statement);
    }

    Debug.println( this.getClass().getName() + " Select end");
    return eoaDeptVO;
  }

  public java.util.Collection findAll(Connection transConn) throws DaoException
  {
    Debug.println( this.getClass().getName() + " Select begin");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    Vector result = new Vector();
    EoaDeptVO eoaDeptVO = null;
    try
    {
       conn = transConn;
       
       statement = conn.prepareStatement(" SELECT dept_id , dept_name , dept_code , parent_id , dept_type , enabled , description , queue , remark FROM  eoa_dept");
       
       
       rs = statement.executeQuery();
       while (rs.next())
       {
         eoaDeptVO = new EoaDeptVO();
         eoaDeptVO.setDeptId(rs.getString("dept_id"));
         eoaDeptVO.setDeptName(rs.getString("dept_name"));
         eoaDeptVO.setDeptCode(rs.getString("dept_code"));
         eoaDeptVO.setParentId(rs.getString("parent_id"));
         eoaDeptVO.setDeptType(rs.getString("dept_type"));
         eoaDeptVO.setEnabled(rs.getString("enabled"));
         eoaDeptVO.setDescription(rs.getString("description"));
         eoaDeptVO.setQueue(rs.getString("queue"));
         eoaDeptVO.setRemark(rs.getString("remark"));
         result.add(eoaDeptVO);
       }
    }
    catch(SQLException e)
    {
       Debug.println(e.getMessage());
       throw new  DaoException("Error executing SQL  SELECT dept_id , dept_name , dept_code , parent_id , dept_type , enabled , description , queue , remark FROM  eoa_dept" + e.getMessage());
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
    EoaDeptVO eoaDeptVO = null;
    try
    {
       conn = transConn;
       
       
       sql = " SELECT dept_id , dept_name , dept_code , parent_id , dept_type , enabled , description , queue , remark FROM  eoa_dept";
       String whereClause = " WHERE 1=1 ";
       String fieldValue = null;
       //输出查询条件
       if (condition != null)
       {
          fieldValue = condition.getProperty("DEPT_ID");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND dept_id =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("DEPT_NAME");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND dept_name =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("DEPT_CODE");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND dept_code =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("PARENT_ID");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND parent_id =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("DEPT_TYPE");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND dept_type =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("ENABLED");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND enabled =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("DESCRIPTION");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND description =  ?  ";
             fieldList.add(fieldValue);
          }
          fieldValue = condition.getProperty("QUEUE");
          if( fieldValue != null &&  fieldValue.length() > 0)
          {
             whereClause += " AND queue =  ?  ";
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
      // System.out.println(sql);
       rs = statement.executeQuery();
       while (rs.next())
       {
         eoaDeptVO = new EoaDeptVO();
         eoaDeptVO.setDeptId(rs.getString("dept_id"));
         eoaDeptVO.setDeptName(rs.getString("dept_name"));
         eoaDeptVO.setDeptCode(rs.getString("dept_code"));
         eoaDeptVO.setParentId(rs.getString("parent_id"));
         eoaDeptVO.setDeptType(rs.getString("dept_type"));
         eoaDeptVO.setEnabled(rs.getString("enabled"));
         eoaDeptVO.setDescription(rs.getString("description"));
         eoaDeptVO.setQueue(rs.getString("queue"));
         eoaDeptVO.setRemark(rs.getString("remark"));
         result.add(eoaDeptVO);
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
  ///////////////////////////////////
  public Vector listTree(Properties proper) throws DaoException{
    Vector vRet = new Vector();
    String strDeptId = proper.getProperty("DEPARTMENT_ID");
    String strDeptCode = proper.getProperty("DEPARTMENT_CODE");
    String strDeptType = proper.getProperty("DEPARTMENT_TYPE");
    String strParentId = proper.getProperty("PARENT_ID");
    
    Statement  stmt = null;
    ResultSet  rs   = null;
    String sql = "";
    String condition = "";
    EoaDeptVO eoaDeptVO = null;
    Connection conn = null;
    try{
        
        conn = DbManager.getConnection();
        stmt = conn.createStatement();
        condition = " a.dept_id is not null and a.enabled = 'Y' ";
        if(strDeptId != null && strDeptId.length() > 0)
           condition +=" and dept_id = '"+ strDeptId +"'";
        if(strDeptType != null && strDeptType.length() > 0)
           condition +=" and dept_type = '"+ strDeptType +"'";
        if(strDeptCode != null && strDeptCode.length() > 0)
           condition +=" and dept_code = '"+ strDeptCode +"'";
       
        sql = " select a.*,nvl(c.hasChild,0) as hasChild from  "+
             " (select * from eoa_dept a where " + condition + ") a , "+
             " (select parent_id,count(*) as hasChild from eoa_dept b "+
             " where "+
             " b.parent_id = "+
             " any( select a.dept_id  from eoa_dept a where " + condition + ")"+
             " group by parent_id "+
             " )c "+
             " where a.dept_id = c.parent_id(+) "+
             " order by a.dept_id ";
        //System.out.println(sql);
        rs   = stmt.executeQuery(sql);
       while (rs.next())
       {
         eoaDeptVO = new EoaDeptVO();
         eoaDeptVO.setDeptId(rs.getString("dept_id"));
         eoaDeptVO.setDeptName(rs.getString("dept_name"));
         eoaDeptVO.setDeptCode(rs.getString("dept_code"));
         eoaDeptVO.setParentId(rs.getString("parent_id"));
         eoaDeptVO.setDeptType(rs.getString("dept_type"));
         eoaDeptVO.setEnabled(rs.getString("enabled"));
         eoaDeptVO.setDescription(rs.getString("description"));
         eoaDeptVO.setQueue(rs.getString("queue"));
         eoaDeptVO.setRemark(rs.getString("remark"));
         eoaDeptVO.setHasChild(rs.getString("hasChild"));
         vRet.add(eoaDeptVO);
       }
    }catch(Exception ex){
        System.out.println("查找部门树数据出错！"+ex.getMessage());
    }finally{
        try{
            if(conn != null){
                DbManager.closeConnection(conn);
            }
        }catch(DataException e){
            throw new DaoException("查找部门树数据出错！");
        }
    }
    return vRet;
  }
}
