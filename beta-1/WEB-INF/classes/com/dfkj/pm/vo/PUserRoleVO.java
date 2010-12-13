
package com.dfkj.pm.vo;



public class PUserRoleVO implements java.io.Serializable
{

  public PUserRoleVO()
  {
  }

  private String userName = "";
  private String roleName = "";

  public void setUserName(String userName)
  {
     this.userName = userName;
  }
  public String getUserName()
  {
     return userName;
  }
  public void setRoleName(String roleName)
  {
     this.roleName = roleName;
  }
  public String getRoleName()
  {
     return roleName;
  }

}
