
package com.dfkj.pm.business;

import com.dfkj.pm.exception.*;
import com.dfkj.pm.vo.EcLogInfoVO;
import javax.servlet.http.HttpSession;
/**
 *
 * @author  Administrator
 */
public interface ILogInfo {
    public void createLogInfo(HttpSession sess , String UserName,javax.servlet.ServletContext context) throws SystemException;
    public void removeLogInfo(HttpSession sess) throws SystemException;
    public void updateLogInfo(HttpSession sess , EcLogInfoVO ecLogInfoVO) throws SystemException;
}
