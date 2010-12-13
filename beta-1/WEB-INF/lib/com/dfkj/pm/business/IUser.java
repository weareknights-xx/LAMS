

package com.dfkj.pm.business;

import java.sql.Connection;
import java.util.Collection;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.vo.PUserVO;

public interface IUser {
    public void addUser(Connection conn,PUserVO pUserVO) throws DaoException;
    public void deleteUser(Connection conn,String UserName) throws DaoException;
    public void updateUser(Connection conn,PUserVO pUserVO) throws DaoException;
    public PUserVO findUserByName(Connection conn,String UserName) throws DaoException;
    public Collection findUserByRegion(Connection conn,String RegionName)throws DaoException;
    public Collection findUserByDepartment(Connection conn,String DepartmentName)throws DaoException;
    public Collection findUserbyRD(Connection conn, String RegionName,String DepartmentName)throws DaoException;
    public Collection findByAll(Connection conn)throws DaoException;
    public Collection findByEmployee(Connection conn,String EmployeeName)throws DaoException;
    public boolean authenticate(Connection conn,String UserName,String Password)throws DaoException;
}
