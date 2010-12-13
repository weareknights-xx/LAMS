
package com.dfkj.eoa.actions.deptwork;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.util.RequestUtils;

import com.dfkj.exception.SystemException;

import com.dfkj.eoa.vo.EoaDeptActVO;
import com.dfkj.eoa.vo.EoaDeptActAppendixVO;
import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;
import com.dfkj.eoa.business.BusinessFactory;
import com.dfkj.eoa.business.IEoaDeptAct;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.dfkj.utilities.StringUtil;
import com.dfkj.data.*;
import com.dfkj.pm.web.*;
import com.dfkj.eoa.constants.ActionMessage;

public class UpdateEoaDeptActAction implements com.dfkj.web.IAction {
        
     //debug info show flag
     private static boolean debugFlag = true;
    
     public UpdateEoaDeptActAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws ServletException, SystemException {

              //����ҵ����߼�
		IEoaDeptAct iEoaDeptAct =
			BusinessFactory.newInstance().buildEoaDeptActImpl();
                
                //ȡ�õ�ǰ�û����ڵĲ���ID
                //LoginInfo loginInfo =(LoginInfo)request.getSession().getAttribute(com.dfkj.constants.Constants.LOGINFOBEAN);
		//String deptId = loginInfo.getDepartmentId();
		
		//add action
		boolean actionFlag = true;
		EoaDeptActVO vo = new EoaDeptActVO();
                EoaDeptActAppendixVO eavo;
                Vector deptActAppendix = new Vector();
                Vector v = new Vector();
                Vector vEoaDeptActAppendix = new Vector();
                Collection OldAppendixCollection = (Collection)request.getSession().getAttribute("Appendix");
                request.getSession().removeAttribute("Appendix");
	        Vector vUpdateAppendix = new Vector();
                Document document = toDom(request);
                
                //��ȡ���Ż������Ϣ
                RequestUtils.populate(vo, request);

                //��ȡ�����ӵĸ����б���Ϣ(���޸�ҳ���е�Mtable�л�ȡ)
                vEoaDeptActAppendix = getDeptActAppendixVO(vo.getDeptActId(),document);

                //��ȡԭ���������޸ĺ���б����������Ӳ���
                vUpdateAppendix = getOldDeptActAppendixId(document);
                
                if(OldAppendixCollection!=null&&!OldAppendixCollection.isEmpty())
                {
                    Iterator iAppendix = OldAppendixCollection.iterator();
                    while(iAppendix.hasNext())
                {
                eavo = (EoaDeptActAppendixVO)iAppendix.next();
                if(vUpdateAppendix!=null&&!vUpdateAppendix.isEmpty()&&vUpdateAppendix.contains(eavo.getAppendixId()))
                         continue;
                else
			deptActAppendix.add(eavo.getAppendixId());
                }

                for(int i =0;i<deptActAppendix.size();i++)
		{
			Debug.println("need delete DeptActAppendixId"+(String)deptActAppendix.elementAt(i));
		}	                
                }
		
                try {
			iEoaDeptAct.updateEoaDeptAct(connection,vo, vEoaDeptActAppendix,deptActAppendix);
		} catch (Exception e) {
					//DEBUG INFO
			if (debugFlag) {
				System.out.println(
					"   -----Update EoaDeptAct exception start-----   :");
				e.printStackTrace();
				System.out.println(
					"   -----Update IEoaDeptAct exception end -----   :");
			}

			//TODO
			actionFlag = false;
                }
            
		//set action perform feedback infomation
		if (actionFlag) {
			request.setAttribute("feedback", ActionMessage.UPDATE_DONE);
		} else {
			request.setAttribute("feedback", ActionMessage.UPDATE_ERR);
		}
                
                 v = null;
                 vEoaDeptActAppendix = null;
                 vUpdateAppendix = null;
    }
    
      private Vector getDeptActAppendixVO(String deptActId,Document document) throws ServletException{
      Debug.println("��ʼ��װ������Ϣ������");
      Vector result = new Vector();  

      Node node = null;
      Node subNode = null;
      NodeList tmpNodeList = null;
      NodeList nodeList = null; 
      node = document.getFirstChild(); //���ڵ�
      tmpNodeList = node.getChildNodes();
      node = tmpNodeList.item(0);  //Lists
      nodeList = node.getChildNodes(); //�ڵ��б�
      if(nodeList.getLength()==0) return null;
      for (int i=0; i< nodeList.getLength(); i++)
      {
           EoaDeptActAppendixVO deptActAppendixVO = new EoaDeptActAppendixVO();
           deptActAppendixVO.setDeptActId(deptActId);
           node = nodeList.item(i);
           subNode = node.getFirstChild(); 
           deptActAppendixVO.setAppendixDesc(subNode.getFirstChild().getNodeValue());
            System.out.println(subNode.getFirstChild().getNodeValue());
           subNode = subNode.getNextSibling();
           deptActAppendixVO.setAppendix(subNode.getFirstChild().getNodeValue());
             System.out.println(subNode.getFirstChild().getNodeValue());          
           result.add(deptActAppendixVO);           
      }    
      Debug.println("��װ������Ϣ��ϡ�����");
      return result;
  }
     
      
    private Vector getOldDeptActAppendixId(Document document) throws ServletException{
      Debug.println("��ʼ��װԭ������Ϣ������");
      Vector  result = new Vector();
           
      Node node = null;
      Node subNode = null;
      NodeList tmpNodeList = null;
      NodeList nodeList = null; 
      node = document.getFirstChild(); //���ڵ�
      tmpNodeList = node.getChildNodes();
      node = tmpNodeList.item(1);  //Lists
      nodeList = node.getChildNodes(); //�ڵ��б�
      if(nodeList.getLength()==0) return result;
     
      for (int i=0; i< nodeList.getLength(); i++)
      {
           node = nodeList.item(i);
           subNode = node.getFirstChild(); 
           
           result.add(subNode.getFirstChild().getNodeValue());
      }    
      Debug.println("��װԭ������Ϣ��ϡ�����");
      return result;
  }
    
  private Document toDom(HttpServletRequest request) throws  ServletException{
      Debug.println("��ʼ����DOM��������");
      DocumentBuilder docBuilder = null;
      Document document = null ; 
      ByteArrayInputStream input = null;
      String sXmlData = request.getParameter("file_tree");
      Debug.println("getStr="+sXmlData);
      sXmlData = "<?xml version=\"1.0\" encoding=\"GB2312\"?>" + sXmlData;
      //ByteArrayInputStream input
      try
      {
         input = new  ByteArrayInputStream(sXmlData.getBytes());
         docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
         document = docBuilder.parse(input);  
         //Debug.println(document.toString());
         Debug.println("DOM="+document);
      }
      catch(Exception E)
      {
          throw new ServletException("����DOM��ʱ�����쳣��" + E.getMessage());
      }
      finally
      {
          if (input != null)
          {
              try
              {
                input.close();
              }
              catch(IOException ioE)
              {
                  
              }
          }
      }
      Debug.println("DOM��������ϡ�����");
      return document;
  }   
    
    
}
