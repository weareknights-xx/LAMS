package com.dfkj.pm.business;

import com.dfkj.pm.data.datamodel.DataModel;
import com.dfkj.pm.db.DbManager;
import com.dfkj.pm.constants.*;//�ò��ֽ���Ҫ�޸ģ�������Ŀ�ĳ����ļ�
import com.dfkj.pm.vo.EcLogInfoVO;//�ò��ֽ�����ģ�������Ŀ��LogInfoVO
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;

public class LogInfoImp implements com.dfkj.pm.business.ILogInfo {
    
    private DataModel datamodel;//���ڵõ����ص�����
    //��������ʵ��
    public LogInfoImp() {
        
    }
    
   
    public void createLogInfo(HttpSession sess , String UserName , javax.servlet.ServletContext context) throws com.dfkj.pm.exception.SystemException {
        
        Connection conn;
        try{
          conn = DbManager.getConnection();  
        }catch(Exception E){
           throw new com.dfkj.pm.exception.SystemException(E.getMessage(),E);  
        }        
        String Temp=null;
        int i=0;
        Vector vecUser = new Vector();
        Vector vecPowers = new Vector();
        DataModel dm;
        
        EcLogInfoVO ecLogInfoVO = new EcLogInfoVO();//�ò��ֽ�����Ҫ�޸�
        //�����ECConstants.GETUSERINFOΪSQL��䣬��Ҫ����Ӧ���ļ��н����޸�
        vecUser = DbManager.doQuery(ECConstants.GETUSERINFO + "'"+UserName+"'", conn);
        datamodel = new DataModel(vecUser);
        /*�ò���Ϊ���û���ϢBean��������ݣ���Բ�ͬ��Ŀ���᲻ͬ����Ҫ�޸�----��ʼ*/
        ecLogInfoVO.setUserName((String)datamodel.getValueAt(0,"user_name"));
        ecLogInfoVO.setUserDescription((String)datamodel.getValueAt(0,"user_description"));
        ecLogInfoVO.setAdmin((String)datamodel.getValueAt(0,"admin"));
        ecLogInfoVO.setRegionName((String)datamodel.getValueAt(0,"region_name"));
        Temp=(String)datamodel.getValueAt(0,"region_id");     
        
        if(Temp.compareTo("")==0){
            ecLogInfoVO.setRegionID(0);
        }else{
            ecLogInfoVO.setRegionID(Long.parseLong(Temp));
        }
        ecLogInfoVO.setRegionType((String)datamodel.getValueAt(0,"region_type"));
        ecLogInfoVO.setRegionCode((String)datamodel.getValueAt(0,"region_code"));           
        try{
            vecPowers = DbManager.doQuery(Constants.FINDUSERPOPEDOM+"'"+UserName+"'", conn);
            dm = new DataModel(vecPowers);
        }catch(Exception e){
            throw new com.dfkj.pm.exception.SystemException(ECExceptionConstants.GETUSERINFOERROR);
        }
        vecPowers = new Vector();
        for(i=0;i<dm.getRowCount();i++){
            vecPowers.addElement(dm.getValueAt(i, "popedom_name"));
        }          

        ecLogInfoVO.setPower(vecPowers);
        ecLogInfoVO.setRealPath(context.getRealPath("/"));
        /*�ò���Ϊ���û���ϢBean��������ݣ���Բ�ͬ��Ŀ���᲻ͬ����Ҫ�޸�----����*/
        sess.setAttribute(Constants.LOGINFOBEAN, ecLogInfoVO);
    }
   
    public void removeLogInfo(HttpSession sess) throws com.dfkj.pm.exception.SystemException {
        sess.removeAttribute(Constants.LOGINFOBEAN);
    }
   
    public void updateLogInfo(HttpSession sess, EcLogInfoVO ecLogInfoVO) throws com.dfkj.pm.exception.SystemException {
        sess.removeAttribute(Constants.LOGINFOBEAN);
        sess.setAttribute(Constants.LOGINFOBEAN, ecLogInfoVO);
    }
    
}
