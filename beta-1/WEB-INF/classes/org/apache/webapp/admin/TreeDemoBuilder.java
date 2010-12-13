/*
 * TreeDemoBuilder.java
 *
 * Created on 2003年6月17日, 下午2:16
 */

package org.apache.webapp.admin;

import org.apache.struts.action.ActionServlet;
import javax.servlet.http.*;

/**
 * 用于创建树的节点，是否执行取决于web.xml文件的配置
 *
 */

/**
 *
 * @author  Administrator
 */
public class TreeDemoBuilder implements TreeBuilder {
    
    /** Creates a new instance of TreeDemoBuilder */
    
    /* TreeControlNode构造函数签名
     public TreeControlNode(String name,
                           String icon, String label,
                           String action, String target,
                           boolean expanded)
     */
    public void buildTree(TreeControl treeControl, ActionServlet servlet, HttpServletRequest request) 
    {      
        //初始化根结点
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
