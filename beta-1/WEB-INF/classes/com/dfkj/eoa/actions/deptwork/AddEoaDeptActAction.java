
package com.dfkj.eoa.actions.deptwork;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.util.RequestUtils;

//import com.dfkj.utilities.Message;
import com.dfkj.exception.SystemException;
import com.dfkj.web.IAction;
import com.dfkj.eoa.dao.DAOFactory;

import com.dfkj.eoa.business.*;
import com.dfkj.eoa.vo.*;
import com.dfkj.pm.web.*;
import com.dfkj.eoa.constants.ActionMessage;
import java.util.Vector;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.dfkj.utilities.StringUtil;
import com.dfkj.data.*;


public class AddEoaDeptActAction implements IAction {

	
	public AddEoaDeptActAction() {

	}

	/* (non-Javadoc)
	 * @see com.dfkj.web.IAction#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.ServletContext, java.sql.Connection)
	 */
	public void perform(
		HttpServletRequest request,
		HttpServletResponse response,
		ServletContext context,
		Connection connection)
		throws ServletException, SystemException {
                    
		boolean actionFlag = true;
                Vector vAppendix = new Vector();
                Document  document = toDom(request);

                //ȡ�õ�ǰ�û����ڵĲ���ID
                LoginInfo loginInfo =(LoginInfo)request.getSession().getAttribute(com.dfkj.constants.Constants.LOGINFOBEAN);
		String deptId = loginInfo.getDepartmentId();
                
                //��û������Ϣ
                EoaDeptActVO eoaDeptActVO = new EoaDeptActVO();
                RequestUtils.populate(eoaDeptActVO, request);
                eoaDeptActVO.setDeptActId(DBUtil.getSeqFromID("S_DEPT_ACT_ID",connection));
		eoaDeptActVO.setDeptId(deptId); //���ñ����ŵ�ID
                
                //��û�����б���Ϣ
                vAppendix = getAppendixVO(eoaDeptActVO.getDeptActId(),document);

		IEoaDeptAct iEoaDeptAct =
			BusinessFactory.newInstance().buildEoaDeptActImpl();
                try{
                    iEoaDeptAct.addEoaDeptAct(connection, eoaDeptActVO, vAppendix) ;
                }catch(Exception e){
                            actionFlag = false;
                            System.out.println("AddEoaDeptActAction:���Ӽ�¼���ɹ�");
                }
                
		//set action perform feedback infomation
		if (actionFlag) {
			request.setAttribute("feedback", ActionMessage.ADD_DONE);
		} else {
			request.setAttribute("feedback", ActionMessage.ADD_ERR);
		}
                        
	}
        
     private Vector getAppendixVO(String deptActId,Document document) throws ServletException{
      Debug.println("��ʼ��װЭ�鸽����Ϣ������");
      Vector result = new Vector();  

      Node node = null;
      Node subNode = null;
      NodeList nodeList = null; 
      node = document.getFirstChild(); //���ڵ�
      nodeList = node.getChildNodes(); //�ڵ��б�

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
      Debug.println("��װЭ����Ϣ��ϡ�����");
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
