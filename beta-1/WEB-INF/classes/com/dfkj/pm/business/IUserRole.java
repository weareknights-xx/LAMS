
package com.dfkj.pm.business;

import java.sql.Connection;
import java.util.Collection;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.vo.PUserRoleVO;


public interface IUserRole {
    public void addUserRole(Connection conn, PUserRoleVO pUserRole)throws DaoException;
    public void addUserRole(Connection conn, java.util.Collection UserRoleCol)throws DaoException;
    public void deleteUserRole(Connection conn, PUserRoleVO pUserRole)throws DaoException;
    public void deleteUserRole(Connection conn, java.util.Collection UserRoleCol)throws DaoException;
    public Collection findUserRoleByUser(Connection conn,String UserName)throws DaoException;
    public Collection findUserRoleByRole(Connection conn,String RoleName)throws DaoException;
}
