

package com.dfkj.pm.business;

import java.sql.Connection;
import java.util.Collection;
import com.dfkj.pm.exception.*;
import com.dfkj.pm.vo.PRolePopedomVO;
import com.dfkj.pm.vo.PPopedomVO;


public interface IRole {
    public void addRole(Connection conn,PPopedomVO pPopedomVO/*��ɫ����*/,Collection PopedomCol/*Ȩ���б�*/) throws DaoException;
    public void deleteRole(Connection conn,PPopedomVO pPopedomVO/*��ɫ����*/) throws DaoException;
    public void updateRole(Connection conn,PPopedomVO pPopedomVO/*��ɫ����*/,Collection PopedomCol/*Ȩ���б�*/) throws DaoException;
    public PPopedomVO findRoleByName(Connection conn,String RoleName)throws DaoException;
    public Collection findPopedomByRoleName(Connection conn,String RoleName) throws DaoException;
    public Collection findRoleByAll(Connection conn) throws DaoException;
    public Collection findPopedomByAll(Connection conn) throws DaoException;
}