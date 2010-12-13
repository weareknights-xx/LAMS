

package com.dfkj.pm.actions;

import com.dfkj.pm.constants.*;
import com.dfkj.pm.vo.PPopedomVO;
import com.dfkj.pm.vo.PRolePopedomVO;
import com.dfkj.pm.business.*;
import com.dfkj.pm.db.DbManager;
import com.dfkj.pm.data.datamodel.*;

import java.util.*;


public class ModifyRolePrepareAction implements com.dfkj.web.IAction {
    
    /** Creates a new instance of ModifyRolePrepareAction */
    public ModifyRolePrepareAction() {
    }
    
    public void perform(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.ServletContext context, java.sql.Connection connection) throws javax.servlet.ServletException, com.dfkj.exception.SystemException {
        PPopedomVO pPopedomVO = new PPopedomVO();
        IRole iRole = BusinessFactory.newInstance().buildRoleImp();
        pPopedomVO = iRole.findRoleByName(connection , (String)request.getParameter(Constants.PMR_ROLENAME));
        request.getSession().setAttribute(Constants.PM_ROLEDETAIL, pPopedomVO);
        
        Vector vecPopedoms = new Vector();
        int i=0;
        String sql = "select a.popedom_name popedom_name,a.popedom_alias popedom_alias,a.popedom_type popedom_type,a.popedom_sort popedom_sort,a.popedom_action popedom_action,decode(d.popedom_name,null,'false','true') checked from p_popedom a,(select b.popedom_name from p_popedom b,p_role_popedom c where b.popedom_name=c.popedom_name and c.role_name='"+pPopedomVO.getPopedomName()+"') d where a.popedom_name = d.popedom_name(+) and a.popedom_type = 'S'"+" order by a.popedom_sort";
        vecPopedoms = DbManager.doQuery(sql, connection);
        DataModel dm = new DataModel(vecPopedoms);
        request.getSession().setAttribute(Constants.PM_LISTROLEPOPEDOM,dm);
        
    }
    
}
