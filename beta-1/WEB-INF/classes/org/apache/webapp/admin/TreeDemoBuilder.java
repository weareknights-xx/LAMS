/*
 * TreeDemoBuilder.java
 *
 * Created on 2003��6��17��, ����2:16
 */

package org.apache.webapp.admin;

import org.apache.struts.action.ActionServlet;
import javax.servlet.http.*;

/**
 * ���ڴ������Ľڵ㣬�Ƿ�ִ��ȡ����web.xml�ļ�������
 *
 */

/**
 *
 * @author  Administrator
 */
public class TreeDemoBuilder implements TreeBuilder {
    
    /** Creates a new instance of TreeDemoBuilder */
    
    /* TreeControlNode���캯��ǩ��
     public TreeControlNode(String name,
                           String icon, String label,
                           String action, String target,
                           boolean expanded)
     */
    public void buildTree(TreeControl treeControl, ActionServlet servlet, HttpServletRequest request) 
    {      
        //��ʼ�������
        //////////////////////////////////////////////////////////
        TreeControlNode node = new TreeControlNode("NodeName01","Host.gif","NodeLable01","nodeSelect.jsp?parentID=NodeName01","content",true);
        treeControl.getRoot().addChild(node);
        node = new TreeControlNode("NodeName02","Host.gif","NodeLabel02","nodeSelect.jsp?parentID=NodeName02","content",true);
        treeControl.getRoot().addChild(node);
        node = new TreeControlNode("NodeName03","Host.gif","NodeLabel03","nodeSelect.jsp?parentID=NodeName03","content",true);
        treeControl.getRoot().addChild(node);
        node = new TreeControlNode("NodeName04","Host.gif","NodeLabel04","nodeSelect.jsp?parentID=NodeName04","content",true);
        treeControl.getRoot().addChild(node);
        node = new TreeControlNode("NodeName05","Host.gif","NodeLabel05","nodeSelect.jsp?parentID=NodeName05","content",true);
        treeControl.getRoot().addChild(node);
        node = new TreeControlNode("NodeName06","Host.gif","NodeLabel06","nodeSelect.jsp?parentID=NodeName06","content",true);
        treeControl.getRoot().addChild(node);
        node = new TreeControlNode("NodeName07","Host.gif","NodeLabel07","nodeSelect.jsp?parentID=NodeName07","content",true);
        treeControl.getRoot().addChild(node);        
        ////////////////////////////////////////////////////////////
    }  
}
