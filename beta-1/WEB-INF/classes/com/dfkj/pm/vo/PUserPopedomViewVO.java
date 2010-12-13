
package com.dfkj.pm.vo;



public class PUserPopedomViewVO implements java.io.Serializable
{

  public PUserPopedomViewVO()
  {
  }

  private String userName = "";
  private String popedomName = "";

  public void setUserName(String userName)
  {
     this.userName = userName;
  }
  public String getUserName()
  {
     return userName;
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
