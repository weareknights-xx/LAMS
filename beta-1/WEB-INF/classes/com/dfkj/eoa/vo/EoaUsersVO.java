
package com.dfkj.eoa.vo;


public class EoaUsersVO implements java.io.Serializable
{

  public EoaUsersVO()
  {
  }

  private String userId = "";
  private String userName = "";
  private String description = "";
  private String password = "";
  private String deptId = "";
  private String enabled = "";
  private String position = "";
  private String queue = "";
  private String admin = "";
  private String onLine = "";
  private String remark = "";

  public void setUserId(String userId)
  {
     this.userId = userId;
  }
  public String getUserId()
  {
     return userId;
  }
  public void setUserName(String userName)
  {
     this.userName = userName;
  }
  public String getUserName()
  {
     return userName;
  }
  public void setDescription(String description)
  {
     this.description = description;
  }
  public String getDescription()
  {
     return description;
  }
  public void setPassword(String password)
  {
     this.password = password;
  }
  public String getPassword()
  {
     return password;
  }
  public void setDeptId(String deptId)
  {
     this.deptId = deptId;
  }
  public String getDeptId()
  {
     return deptId;
  }
  public void setEnabled(String enabled)
  {
     this.enabled = enabled;
  }
  public String getEnabled()
  {
     return enabled;
  }
  public void setPosition(String position)
  {
     this.position = position;
  }
  public String getPosition()
  {
     return position;
  }
  public void setQueue(String queue)
  {
     this.queue = queue;
  }
  public String getQueue()
  {
     return queue;
  }
  public void setAdmin(String admin)
  {
     this.admin = admin;
  }
  public String getAdmin()
  {
     return admin;
  }
  public void setOnLine(String onLine)
  {
     this.onLine = onLine;
  }
  public String getOnLine()
  {
     return onLine;
  }
  public void setRemark(String remark)
  {
     this.remark = remark;
  }
  public String getRemark()
  {
     return remark;
  }

}
