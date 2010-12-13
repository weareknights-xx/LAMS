/*
 * DepartTreeBuilder.java
 * 
 * Created on 2004年1月29日, 下午1:52 by 何格
 * 生成部门树
 */
package org.apache.webapp.admin;

import org.apache.struts.action.ActionServlet;
import javax.servlet.http.*;
import java.util.Vector;
import java.util.Properties;
import java.net.URLEncoder;

import com.dfkj.eoa.vo.EoaTreeVO;
import com.dfkj.eoa.vo.EoaDeptVO;
import com.dfkj.eoa.business.DepatManagerImpl;
import com.dfkj.utilities.StringUtil;
/**
 *
 * @author  Administrator
 */
public class DepartTreeBuilder implements TreeBuilder{
    private Vector ListedDeptId = new Vector();//存放已经显示过了的结点的编号
    /** Creates a new instance of DepartTreeBuilder */
    public DepartTreeBuilder() {
    }
    
    public void buildTree(TreeControl treeControl, ActionServlet servlet, HttpServletRequest request)
    {
        String url = request.getContextPath() + "/MainController.do?ActionName=org.apache.webapp.admin.DepartTreeBuilder";//&NextPage=/deptwork/depart_maintenance.jsp";
        //创建根节点
        Properties param = new  Properties();
        String strAction = "";
        String strTarget = "content";
        String strFlag = "";
        strFlag = request.getParameter("Flag");
        String strMulti = request.getParameter("Multi");
        
        System.out.println("strMulti:"+strMulti);

        //System.out.println(request.getParameter("Flag"));
        //创建部门表树形集合
        TreeControlNode rootNode = null;
        if(strFlag != null){
            if( strFlag.equals("SELECT_DEP"))
                rootNode = new TreeControlNode("/","Datasource.gif","部门","javascript:opener.document.thisForm.parent_name.value='部门';window.close();","_self",true); 
            else if(strFlag.equals("SELECT_USER"))
                rootNode = new TreeControlNode("/","Datasource.gif","部门",request.getContextPath()+"/deptwork/user_list.jsp","content",true); 
            else if(strFlag.equals("LIST"))
                rootNode = new TreeControlNode("/","Datasource.gif","部门",request.getContextPath()+"/deptwork/depart_maintenance.jsp","content",true); 
            else if(strFlag.equals("HUMANINFO"))
                rootNode = new TreeControlNode("/","Datasource.gif","全部档案",request.getContextPath()+"/MainController.do?ActionName=com.dfkj.eoa.actions.humaninfo.QueryEoaHumaninfoAction&NextPage=/humaninfo/eoa_humanarchive_main.jsp&pageSize=15&pageNumber=1","content",true);
        }
        TreeControlNode childNode = null;
        TreeControlNode childNode1 = null;
        TreeControlNode childNode2 = null;
        treeControl.getRoot().addChild(rootNode);
        //创建部门编号
        String strDepartmentId = request.getParameter("DEPARTMENT_ID");
        if(strDepartmentId == null)
            strDepartmentId = "";
        ///////////////////////////////////
        String strDeptId = request.getParameter("DEPT_ID");
        if(strDeptId == null)
            strDeptId = "";
        ///////////////////////
        String strParentId = request.getParameter("PARENT_ID");
        if(strParentId == null)
            strParentId = "/";
        System.out.println(strDepartmentId +"@"+strParentId);
        param.setProperty("DEPARTMENT_ID",strDepartmentId);
        param.setProperty("PARENT_ID","/");
        DepatManagerImpl depatManager = new DepatManagerImpl();
        Vector nodeList = null;
        
        EoaDeptVO depVO = null;
        try{
            nodeList = null;
            nodeList = depatManager.getDeptTreeList(param);
            
            long childCount = 0;
            String sChildCount = "";
            boolean hasChild = false;
            //////////////////////////////////
            if (nodeList != null)
            {
                for(int i=0; i<nodeList.size(); i++)
                {
                    depVO = (EoaDeptVO)nodeList.elementAt(i);
                    ///////////////////////////////////////
                    if(strDeptId.length() > 0){
                        if(!depVO.getDeptId().equals(strDeptId))
                            continue;
                    }
                    ///////////////////////////////////////
                    childCount = 0;
                    sChildCount = null;
                    hasChild = false;
                    sChildCount = depVO.getHasChild();
                    if (sChildCount == null)
                    {
                        sChildCount = "0";                    
                    }
                    childCount = Integer.valueOf(sChildCount).longValue();
                    if  (childCount > 0)
                    {
                        hasChild = true;
                    }
                    /////////////////////////////////////////////
                    if(!ifHasDisplay(ListedDeptId,depVO.getDeptId()))
                    {
                        if(strFlag.equals("SELECT_DEP")){
                            strAction = "javascript:opener.document.thisForm.parent_id.value = '"+depVO.getDeptId()+"';"+
                                         " opener.document.thisForm.parent_name.value = '"+depVO.getDeptName()+"';"+
                                         " opener.document.thisForm.dept_code.value = '"+depVO.getDeptCode()+"';"+
                                         "self.close();";
                            strTarget = "_self";
                        }
                        else if(strFlag.equals("SELECT_USER")){
                            strAction = request.getContextPath()+"/MainController.do?ActionName=com.dfkj.eoa.actions.deptwork.QueryUserByDeptAction&NoCache=1&NextPage=/deptwork/user_list.jsp&DEPT_ID="+depVO.getDeptId()+"&Multi="+strMulti; 
                            strTarget = "content";
                        }
                        else if(strFlag.equals("LIST")){
                            strAction = request.getContextPath()+"/MainController.do?ActionName=com.dfkj.eoa.actions.deptwork.QueryUserByDeptAction&NoCache=1&NextPage=/deptwork/depart_maintenance.jsp&DEPT_ID="+depVO.getDeptId(); 
                            strTarget = "content";
                        }
                        else if(strFlag.equals("HUMANINFO")){
                            strAction = request.getContextPath()+"/MainController.do?ActionName=com.dfkj.eoa.actions.humaninfo.QueryEoaHumaninfoAction&NextPage=/humaninfo/eoa_humanarchive_main.jsp&pageSize=15&pageNumber=1&DEPT_ID="+depVO.getDeptId(); 
                            strTarget = "content";
                        }
                        //childNode = new TreeControlNode(depVO.getDeptId(),"Mailsession.gif", depVO.getDeptName(), strAction+"&DEPT_ID="+depVO.getDeptId() ,strTarget,false,hasChild);
                        childNode = new TreeControlNode(depVO.getDeptId(),"Mailsession.gif", depVO.getDeptName(), strAction ,strTarget,false,hasChild);
                        rootNode.addChild(childNode);
                        findChildNode(nodeList,childNode,depVO,request,strFlag);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("创建部门树出错！"+e.getMessage());
        }
    }
    //获得当前结点的字节点
    public void findChildNode(Vector nodeList,TreeControlNode node,EoaDeptVO vo,HttpServletRequest request,String strFlag){
        //传入结点的结点编号。
        String url = " ";
        String strSubAction = "";
        String strSubTarget = "";
        boolean hasChild = false;
        long childCount = 0;
        String sChildCount = "";
        sChildCount = vo.getHasChild();
		String strMulti = request.getParameter("Multi");
        if (sChildCount == null)
        {
             sChildCount = "0";                    
        }
        childCount = Integer.valueOf(sChildCount).longValue();
        if  (childCount > 0)
        {
             hasChild = true;
        }else
            hasChild = false;
        String strDepId = vo.getDeptId();
        String strParentId = "";
        if(nodeList != null){
            for(int i = 0; i < nodeList.size();i ++){
                EoaDeptVO tmpVO = new EoaDeptVO();
                tmpVO = (EoaDeptVO)nodeList.elementAt(i);
                strParentId = tmpVO.getParentId(); 
                if(strParentId != null && strParentId.equals(strDepId)){
                    ///////////////////////////////////////////////////////
                    if(strFlag.equals("SELECT_DEP")){
                            strSubAction = "javascript:opener.document.thisForm.parent_id.value = '"+tmpVO.getDeptId()+"';"+
                                         " opener.document.thisForm.parent_name.value = '"+tmpVO.getDeptName()+"';"+
                                         " opener.document.thisForm.dept_code.value = '"+tmpVO.getDeptCode()+"';"+
                                         "self.close();";
                            strSubTarget = "_self";
                        }
                     else if(strFlag.equals("SELECT_USER")){
                            strSubAction = request.getContextPath()+"/MainController.do?ActionName=com.dfkj.eoa.actions.deptwork.QueryUserByDeptAction&NoCache=1&NextPage=/deptwork/user_list.jsp&DEPT_ID="+tmpVO.getDeptId()+"&Multi="+strMulti;; 
                            strSubTarget = "content";
                        }
                    
                    else if(strFlag.equals("LIST")){
                            strSubAction = request.getContextPath()+"/MainController.do?ActionName=com.dfkj.eoa.actions.deptwork.QueryUserByDeptAction&NoCache=1&NextPage=/deptwork/depart_maintenance.jsp&DEPT_ID="+tmpVO.getDeptId(); 
                            strSubTarget = "content";
                        }
                    else if(strFlag.equals("HUMANINFO")){
                            strSubAction = request.getContextPath()+"/MainController.do?ActionName=com.dfkj.eoa.actions.humaninfo.QueryEoaHumaninfoAction&NextPage=/humaninfo/eoa_humanarchive_main.jsp&pageSize=15&pageNumber=1&DEPT_ID="+tmpVO.getDeptId(); 
                            strSubTarget = "content";
                        }
                    //////////////////////////////////////////////////////
                    ListedDeptId.add(tmpVO.getDeptId());
                    TreeControlNode tmpNode = new TreeControlNode(tmpVO.getDeptId(),"Mailsession.gif",tmpVO.getDeptName(),strSubAction,strSubTarget,false,false);
                    node.addChild(tmpNode);
                    findChildNode(nodeList,tmpNode,tmpVO,request,strFlag);
                }
            }
        }
    }
    
    public  boolean ifHasDisplay(Vector ListedDepId,String currentId){
        boolean ret = false;
        if(ListedDepId != null && ListedDepId.size() > 0){
            for(int index = 0; index < ListedDepId.size(); index ++){
                String tmpId = (String)ListedDeptId.elementAt(index);
                if(currentId.equals(tmpId)){
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }
}
