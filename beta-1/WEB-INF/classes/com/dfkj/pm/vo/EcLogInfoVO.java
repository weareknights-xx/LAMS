

package com.dfkj.pm.vo;

import java.util.*;


public class EcLogInfoVO extends com.dfkj.data.ValueObject {
    
    private String userName="";
    private String userDescription="";
    private String admin="";
    private long regionID=0;
    private String regionName="";
    private String regionType="";
    private String regionCode="";
    private Vector vecPowers = new Vector();
    private String realPath="";
    
    public EcLogInfoVO() {
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String UserName){
        this.userName = UserName;
    }
    
    public String getUserDescription(){
        return userDescription;
    }
    
    public void setUserDescription(String UserDescription){
        this.userDescription = UserDescription;
    }
    
    public String getAdmin(){
        return admin;
    }
    
    public void setAdmin(String Admin){
        this.admin = Admin;
    }
    
    public long getRegionID(){
        return regionID;
    }
    
    public void setRegionID(long RegionID){
        this.regionID = RegionID;
    }
    
    public String getRegionName(){
        return regionName;
    }
    
    public void setRegionName(String RegionName){
        this.regionName = RegionName;
    }
    
    public String getRegionType(){
        return regionType;
    }
    
    public void setRegionType(String RegionType){
        this.regionType = RegionType;
    }
    
    public String getRegionCode(){
        return regionCode;
    }
    
    public void setRegionCode(String RegionCode){
        this.regionCode = RegionCode;
    }
    
    public Vector getPower(){
        return vecPowers;
    }
    
    public void setPower(Vector vecPower){
        this.vecPowers = vecPower; 
    }
    
    public void setRealPath(String path){
        this.realPath = path;
    }
    
    public String getRealPath(){
        return realPath;
    }
}
