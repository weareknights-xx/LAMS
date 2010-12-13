
package com.dfkj.pm.dao;


import java.sql.Connection;
import java.util.Collection;

public class DAOFactory 
{

   private DAOFactory()
   {
   
   }
   
   public static DAOFactory newInstance()
   {
      return new DAOFactory();
   }
   
   public IPPopedomDAO buildPPopedomDAO()
   {
      return new PPopedomDAOImpl();
   }
   
   public IPRolePopedomDAO buildPRolePopedomDAO()
   {
      return new PRolePopedomDAOImpl();
   }
   
   public IPUserDAO buildPUserDAO()
   {
      return new PUserDAOImpl();
   }
   
   public IPUserPopedomViewDAO buildPUserPopedomViewDAO()
   {
      return new PUserPopedomViewDAOImpl();
   }
   
   public IPUserRoleDAO buildPUserRoleDAO()
   {
      return new PUserRoleDAOImpl();
   }
   
   
}
