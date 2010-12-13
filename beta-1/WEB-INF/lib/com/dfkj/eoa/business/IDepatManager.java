
package com.dfkj.eoa.business;

import java.sql.Connection;
import java.util.Collection;
import java.util.Vector;
import java.util.Properties;
import com.dfkj.exception.*;
import javax.servlet.ServletException;
import com.dfkj.eoa.vo.EoaDeptVO;

    /** Creates a new instance of IDepatManager */
    public interface IDepatManager {
        public void addDepartment(Connection conn,EoaDeptVO vo) throws DaoException;
        
        public String delDepartment(Connection conn,String departmentId)throws DaoException;
        
        public void updateDepartment(Connection conn,EoaDeptVO vo)throws DaoException;
        
        public Vector getUserListByDept(Connection conn,EoaDeptVO vo)throws DaoException;
        
        public Vector getDeptTreeList(Properties proper)throws ServletException;
        
        public EoaDeptVO getDeptById(Connection conn,String id)throws DaoException;
    }

