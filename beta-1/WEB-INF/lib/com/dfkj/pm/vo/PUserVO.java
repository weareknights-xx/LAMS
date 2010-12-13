
package com.dfkj.pm.vo;



public class PUserVO implements java.io.Serializable
{

  public PUserVO()
  {
  }
  
  private String onLine = "";
  private String emailAddress = "";
  
  private String userId = "";
  private String userName = "";
  private String userDescription = "";
  private String employeeId = "";
  private String password = "";
  private String userEnabled = "";
  private String admin = "";
  private String regionId = "";
  private String departmentId = "";
  

  public String getUserId() {
      return userId;
  }  
  public void setUserId(String userId) {
      this.userId = userId;
  }  
  public void setUserName(String userName)
  {
     this.userName = userName;
  }
  public String getUserName()
  {
     return userName;
  }
  public void setUserDescription(String userDescription)
  {
     this.userDescription = userDescription;
  }
  public String getUserDescription()
  {
     return userDescription;
  }
  public void setEmployeeId(String employeeId)
  {
     this.employeeId = employeeId;
  }
  public String getEmployeeId()
  {
     return employeeId;
  }
  public void setPassword(String password)
  {
     this.password = password;
  }
  public String getPassword()
  {
     return password;
  }
  public void setUserEnabled(String userEnabled)
  {
     this.userEnabled = userEnabled;
  }
  public String getUserEnabled()
  {
     return userEnabled;
  }
  public void setAdmin(String admin)
  {
     this.admin = admin;
  }
  public String getAdmin()
  {
     return admin;
  }
  public void setRegionId(String regionId)
  {
     this.regionId = regionId;
  }
  public String getRegionId()
  {
     return regionId;
  }
  public void setDepartmentId(String departmentId)
  {
     this.departmentId = departmentId;
  }
  public String getDepartmentId()
  {
     return departmentId;
  }
  
  public java.lang.String getOnLine() {
      return onLine;
  }  
  
  public void setOnLine(java.lang.String onLine) {
      this.onLine = onLine;
  }
  
  /** Getter for property emailAddress.
   * @return Value of property emailAddress.
   *
   */
  public java.lang.String getEmailAddress() {
      return emailAddress;
  }
  
  /** Setter for property emailAddress.
   * @param emailAddress New value of property emailAddress.
   *
   */
  public void setEmailAddress(java.lang.String emailAddress) {
      this.emailAddress = emailAddress;
  }
  
}
