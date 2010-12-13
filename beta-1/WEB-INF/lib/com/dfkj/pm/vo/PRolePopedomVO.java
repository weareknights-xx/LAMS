
package com.dfkj.pm.vo;



public class PRolePopedomVO implements java.io.Serializable
{

  public PRolePopedomVO()
  {
  }

  private String roleName = "";
  private String popedomName = "";

  public void setRoleName(String roleName)
  {
     this.roleName = roleName;
  }
  public String getRoleName()
  {
     return roleName;
  }
  public void setPopedomName(String popedomName)
  {
     this.popedomName = popedomName;
  }
  public String getPopedomName()
  {
     return popedomName;
  }

}
