
package com.dfkj.eoa.vo;



public class EoaDeptVO implements java.io.Serializable
{

  public EoaDeptVO()
  {
  }

  private String deptId = "";
  private String deptName = "";
  private String deptCode = "";
  private String parentId = "";
  private String deptType = "";
  private String enabled = "";
  private String description = "";
  private String queue = "";
  private String remark = "";
  private String hasChild = "";
  public void setDeptId(String deptId)
  {
     this.deptId = deptId;
  }
  public String getDeptId()
  {
     return deptId;
  }
  public void setDeptName(String deptName)
  {
     this.deptName = deptName;
  }
  public String getDeptName()
  {
     return deptName;
  }
  public void setDeptCode(String deptCode)
  {
     this.deptCode = deptCode;
  }
  public String getDeptCode()
  {
     return deptCode;
  }
  public void setParentId(String parentId)
  {
     this.parentId = parentId;
  }
  public String getParentId()
  {
     return parentId;
  }
  public void setDeptType(String deptType)
  {
     this.deptType = deptType;
  }
  public String getDeptType()
  {
     return deptType;
  }
  public void setEnabled(String enabled)
  {
     this.enabled = enabled;
  }
  public String getEnabled()
  {
     return enabled;
  }
  public void setDescription(String description)
  {
     this.description = description;
  }
  public String getDescription()
  {
     return description;
  }
  public void setQueue(String queue)
  {
     this.queue = queue;
  }
  public String getQueue()
  {
     return queue;
  }
  public void setRemark(String remark)
  {
     this.remark = remark;
  }
  public String getRemark()
  {
     return remark;
  }
  public void setHasChild(String hasChild)
  {
     this.hasChild = hasChild;
  }
  public String getHasChild()
  {
     return hasChild;
  }
}
