
package com.dfkj.eoa.dao;



import java.sql.Connection;
import com.dfkj.exception.DaoException;
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



   public IEoaDeptDAO buildEoaDeptDAO()
   {
      return new EoaDeptDAOImpl();
   }

   public IEoaDeptActDAO buildEoaDeptActDAO()
   {
      return new EoaDeptActDAOImpl();
   }

  

   public IEoaUsersDAO buildEoaUsersDAO()
   {
      return new EoaUsersDAOImpl();
   }

 

   public IPUserDAO buildPUserDAO()
   {
      return new PUserDAOImpl();
   }
  


}
