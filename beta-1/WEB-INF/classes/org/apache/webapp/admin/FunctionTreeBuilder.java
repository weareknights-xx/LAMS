/*
 * Created on 2004-2-12
 *
 */
package org.apache.webapp.admin;

import java.util.Properties;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;

import com.dfkj.eoa.business.BusinessFactory;
import com.dfkj.eoa.business.IEoaFunction;
import com.dfkj.eoa.vo.EoaFunctionVO;
import com.dfkj.eoa.vo.EoaFunctionrelationVO;

/**
 * @author Aneu
 *
 * Created on 2004-2-12
 */
public class FunctionTreeBuilder implements TreeBuilder {
	private final static String ACTION_NAME =
		"/MainController.do?ActionName=org.apache.webapp.admin.FunctionTreeBuilder";
	private final static String MAIN_ID = "RELATION_ID";
	private final static String PARENT_ID = "FUNCTION_ID";

	private final static Log log = LogFactory.getLog(FunctionTreeBuilder.class);

	private Vector IteratedId = new Vector(); //存放已经显示过了的结点的编号

	/**
	 * 
	 */
	public FunctionTreeBuilder() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.apache.webapp.admin.TreeBuilder#buildTree(org.apache.webapp.admin.TreeControl, org.apache.struts.action.ActionServlet, javax.servlet.http.HttpServletRequest)
	 */
	public void buildTree(
		TreeControl treeControl,
		ActionServlet servlet,
		HttpServletRequest request) {
		String url = request.getContextPath() + ACTION_NAME;
		//&NextPage=/deptwork/depart_maintenance.jsp";
		//创建根节点
		Properties param = new Properties();
		String strAction = "";
		String strTarget = "content";
		String strFlag = "";
		strFlag = request.getParameter("Flag");
		log.debug("strFlag: " + strFlag);

		String strMulti = request.getParameter("Multi");
		log.debug("strMulti: " + strMulti);

		String strMainId = request.getParameter(MAIN_ID);
		if (strMainId == null)
			strMainId = "";
		String strParentId = request.getParameter(PARENT_ID);
		if (strParentId == null)
			strParentId = "";
		log.debug(strMainId + "@" + strParentId);
		param.setProperty(MAIN_ID, strMainId);
		param.setProperty(PARENT_ID, strParentId);

		TreeControlNode rootNode =
			new TreeControlNode("/", "Datasource.gif", "功能", null, "self", false);
		log.debug("root created");

		treeControl.getRoot().addChild(rootNode);

		//创建功能表树形集合
		//创建功能编号
		IEoaFunction iFun = BusinessFactory.newInstance().buildEoaFunctionImpl();
		Vector nodeList = null;

		try {
			nodeList = iFun.listTree(param);

			EoaFunctionVO fVO = null;
			if (nodeList != null) {
				for (int i = 0; i < nodeList.size(); i++) {
					TreeControlNode childNode = null;
					fVO = (EoaFunctionVO) nodeList.elementAt(i);

					strAction =
						request.getContextPath()
							+ "/MainController.do?ActionName=com.dfkj.eoa.actions.document.FindEoaFunctionrelationByPageAction&pageSize=15&pageNumber=1&NoCache=1&NextPage=/document/function_relation_choice.jsp&FUNCTION_ID="
							+ fVO.getFunctionId()
							+ "&Multi="
							+ strMulti;
					strTarget = "content";

					childNode =
						new TreeControlNode(
							fVO.getFunctionId(),
							"Mailsession.gif",
							fVO.getFunctionName(),
							strAction,
							strTarget,
							false,
							false);

					rootNode.addChild(childNode);
				}
			}
		} catch (Exception e) {
			log.error("创建功能树出错！", e);
		}
	}

}
