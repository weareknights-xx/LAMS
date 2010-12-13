package com.dfkj.eoa.actions.deptwork;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfkj.exception.SystemException;
import com.dfkj.web.IAction;

import com.dfkj.web.*;
import com.dfkj.constants.*;
import com.dfkj.exception.*;
import javax.servlet.http.*;
import javax.servlet.*;

import com.dfkj.eoa.business.*;
import com.dfkj.eoa.vo.*;
import com.dfkj.pm.web.*;
import com.dfkj.eoa.constants.ActionMessage;


public class DeleteEoaDeptActAction implements IAction {

	
	public DeleteEoaDeptActAction() {
		// TODO Auto-generated constructor stub
	}
	
	public void perform(
		HttpServletRequest request,
		HttpServletResponse response,
		ServletContext context,
		Connection connection)
		throws ServletException, SystemException {
		// TODO Auto-generated method stub

		boolean actionFlag = true;

		String delId = "";
		delId = request.getParameter("deptActId");
                IEoaDeptAct iEoaDeptAct = 
                    BusinessFactory.newInstance().buildEoaDeptActImpl();
                
                try{
                    iEoaDeptAct.deleteEoaDeptAct(connection, delId);
                }catch(Exception e){
                    actionFlag = false;
                }
		//set action perform feedback infomation
		if (actionFlag) {
			request.setAttribute("feedback", ActionMessage.DELETE_DONE);
		} else {
			request.setAttribute("feedback", ActionMessage.DELETE_ERR);
		}
                        
    }

}
