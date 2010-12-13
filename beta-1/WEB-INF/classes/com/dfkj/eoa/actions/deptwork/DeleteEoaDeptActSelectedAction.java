
package com.dfkj.eoa.actions.deptwork;

import java.sql.Connection;
import com.dfkj.eoa.constants.EOAConstants;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfkj.exception.SystemException;
import com.dfkj.web.IAction;
import com.dfkj.eoa.business.*;
import com.dfkj.eoa.vo.*;
import com.dfkj.pm.web.*;
import com.dfkj.eoa.constants.ActionMessage;

public class DeleteEoaDeptActSelectedAction implements IAction {

        //debug info show flag
        private static boolean debugFlag = true;

	
	public DeleteEoaDeptActSelectedAction() {

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
		// TODO Auto-generated method stub

		boolean actionFlag = true;
		String[] delIds = request.getParameterValues("deptActId");

		if(delIds != null && delIds.length > 0){
                IEoaDeptAct iEoaDeptAct = 
                    BusinessFactory.newInstance().buildEoaDeptActImpl();
		       try {
		           iEoaDeptAct.deleteSelected(connection, delIds);
			} catch (Exception e) {
			   //TODO
			   actionFlag = false;
			   //DEBUG INFO
			  if(debugFlag){
			    System.out.println("   ----- delete selected exception start-----   :");
			    e.printStackTrace();
			    System.out.println("   ----- delete selected exception end -----   :");
			   }

			}
		}else{
		     actionFlag = false;
		}

                //set action perform feedback infomation
            if (actionFlag){  
                request.setAttribute("feedback",ActionMessage.DELETE_DONE);
            }else{
                request.setAttribute("feedback",ActionMessage.DELETE_ERR);
            }

	}

}
