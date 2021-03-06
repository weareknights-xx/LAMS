/*
 * $Header: /home/cvs/jakarta-tomcat-4.0/webapps/admin/WEB-INF/classes/org/apache/webapp/admin/TreeControlTestAction.java,v 1.3 2001/11/28 03:33:49 patrickl Exp $
 * $Revision: 1.3 $
 * $Date: 2001/11/28 03:33:49 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Tomcat", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


package org.apache.webapp.admin;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
/*
import com.dfkj.kpi.business.IIndexManage;
import com.dfkj.kpi.business.IndexManageImpl;
import com.dfkj.kpi.vo.KpiIndexTypeVO;*/
import java.util.Vector;
import java.util.Properties;
import com.dfkj.pm.web.LoginInfo;
//import com.dfkj.kpi.web.IAction;

import java.net.URLEncoder;
//import com.dfkj.kpi.util.StringUtil;


/**
 * Test <code>Action</code> that handles events from the tree control test
 * page.
 *
 * @author Craig R. McClanahan
 * @version $Revision: 1.3 $ $Date: 2001/11/28 03:33:49 $
 */

public class TreeControlTestAction extends Action {


    // --------------------------------------------------------- Public Methods


    /**
     * Process the specified HTTP request, and create the corresponding HTTP
     * response (or forward to another web component that will create it).
     * Return an <code>ActionForward</code> instance describing where and how
     * control should be forwarded, or <code>null</code> if the response has
     * already been completed.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet exception occurs
     */
    public ActionForward perform(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
        throws IOException, ServletException {        
        //getServlet().log("Entered TreeControlTestAction:perform()");

        String name = null;
        String sessionName = request.getParameter("sessionName");
        HttpSession session = request.getSession();
        TreeControl control =
            (TreeControl) session.getAttribute(sessionName);
         //System.out.println("TreeControlTestAction-------------------");
        // Handle a tree expand/contract event
        name = request.getParameter("tree");
        
        if (name != null) {
            getServlet().log("Tree expand/contract on " + name);

            TreeControlNode node = control.findNode(name);

            if (node != null){
                getServlet().log("Found Node: " + name);
                node.setExpanded(!node.isExpanded());                
               
        
            }
        }else{
            getServlet().log("tree param is null");
        }

        // Handle a select item event
        name = request.getParameter("select");
        System.out.println("cccccccccccccccccccc"+name);
        if (name != null) {
            getServlet().log("Select event on " + name);
            control.selectNode(name);
            
            /////////////////////////////////////////////////////////////////////////
            //创建根节点
            Properties param = new  Properties(); 
            LoginInfo loginInfor = (LoginInfo)request.getSession().getAttribute("logininfor");
            
            //在当前选中的节点中增加下一级子节点
            //在此为了保持数据同步，删除当前节点的子节点，重新生成。
            TreeControlNode currentNode = control.findNode(name);
            TreeControlNode parentNode = null;
            TreeControlNode childNode = null;
            TreeControlNode[] childList = null;
            ////////////////////////////////
            //Leon Chen 2003.06.20
            long childCount = 0;
            String sChildCount = "";
            boolean hasChild = false;
            //////////////////////////////////
            if (currentNode != null)
            {
                synchronized(currentNode)
                {
                    
                }
            }
            /*  
            TreeControlNode node = control.findNode(name);
            if (node != null)
            {
                String time = String.valueOf(System.currentTimeMillis());
                TreeControlNode childNode = new TreeControlNode(node.getName() + time ,"Host.gif",node.getLabel() + time,"nodeSelect.jsp?parentID=" + node.getName() + time,"content",true); 
                node.addChild(childNode);                
            }
            */
            
            //////////////////////////////////////////////////////////////////////////
        }

        // Forward back to the test page
        return (mapping.findForward("Tree Control Test"));

    }


}
