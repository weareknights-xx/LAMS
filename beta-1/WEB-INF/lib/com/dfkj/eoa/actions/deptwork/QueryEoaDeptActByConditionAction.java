
package com.dfkj.eoa.actions.deptwork;

import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfkj.constants.Constants;
import com.dfkj.exception.SystemException;
import com.dfkj.eoa.business.*;
import com.dfkj.eoa.vo.*;
import com.dfkj.constants.*;
import com.dfkj.eoa.page.*;
import com.dfkj.pm.web.*;


public class QueryEoaDeptActByConditionAction implements IAction {

	
	public QueryEoaDeptActByConditionAction() {

	}

	public void perform(
		HttpServletRequest request,
		HttpServletResponse response,
		ServletContext context,
		Connection connection)
		throws ServletException, SystemException {
			int pageSize = PageConfig.PAGE_SIZE_BIG; //
			try {
                             pageSize = Integer.parseInt(request.getParameter("pageSize"));
                            if (pageSize < 0) {
						 pageSize = 0;
                                	 }
			 } catch (NumberFormatException nfe) {
				}
			   catch (Exception e) {
				 	}

			 int currentPageNubmer = 1;

			 try {
				 currentPageNubmer =
					 Integer.parseInt(request.getParameter("pageNumber"));
				 if (currentPageNubmer < 0) {
					 currentPageNubmer = 1;
				 }
				 } catch (NumberFormatException nfe) {
						}			
				   catch (Exception e) {
					}
			
			java.util.Properties condition = new java.util.Properties();
		       
                        //取得当前用户所在的部门ID
                        LoginInfo loginInfo =(LoginInfo)request.getSession().getAttribute(com.dfkj.constants.Constants.LOGINFOBEAN);
        		String deptCode = loginInfo.getDepartmentCode();
				condition.setProperty("DEPTCODE",deptCode);
                                
                        //从主页面上取得条件
			String actname = request.getParameter("actName_mainpage");
			if(actname!=null)
				condition.setProperty("ACT_NAME",actname);
			String organizer = request.getParameter("organizer_mainpage");
			if(actname!=null)
				condition.setProperty("ORGANIZER",organizer);
			String topic = request.getParameter("topic_mainpage");
			if(actname!=null)
				condition.setProperty("OPTIC",topic);
                        
			IEoaDeptAct iEoaDeptAct =
				  BusinessFactory.newInstance().buildEoaDeptActImpl();
			
			try {
				com.dfkj.eoa.page.Page  page  = iEoaDeptAct.findByConditionPage(connection,pageSize,currentPageNubmer, condition);
				request.setAttribute("eoaDeptActPage", page);
			} catch (Exception e) {

			}
		}

}
