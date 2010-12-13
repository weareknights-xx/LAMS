package com.dfkj.eoa.common;

import com.dfkj.db.DbManager;
import com.dfkj.data.Debug;

import java.sql.Connection;
import java.util.Vector;


public class Property {
    public Property() {
    }

    //取deptID的所有父部门的ID放在String[]中
    public static String getDeptParent(Connection conn, String deptID) {
        String ret = "";
        try {
            String sql = "select parent_id from eoa_dept where dept_id = " + deptID;
            Vector v = DbManager.doQuery1(conn, sql);
            if (v != null && v.size() > 0) {
                String s = ((String[]) v.elementAt(0))[0];
                if (s == null || s.equals("") || s.equals("0"))
                    ret = deptID + ",";
                else {
                    ret += getDeptParent(conn, s);
                    ret += deptID + ",";
                }
            }
        } catch (Exception e) {
            Debug.println(e.getMessage());
        }
        return ret;
    }

    //取deptID的所有子部门的ID放在String[]中
    public static String getDeptChild(Connection conn, String deptID) {
        String ret = "";
        try {
            String sql = "select dept_id from eoa_dept where parent_id = " + deptID;
            Vector v = DbManager.doQuery1(conn, sql);
            if (v != null && v.size() > 0) {
                ret += deptID + ",";
                for (int i = 0; i < v.size(); i++) {
                    String[] r = (String[]) v.elementAt(i);
                    ret += getDeptChild(conn, r[0]);
                }
            } else {
                ret += deptID + ",";
            }
        } catch (Exception e) {
            Debug.println(e.getMessage());
        }
        return ret;
    }

    public static String EmployeeName(Connection cn, String orderID) {
        String ret = "";
        try {
            String sql = "select user_id,user_description from p_user where user_id = " + orderID;
            Vector v = DbManager.doQuery1(cn, sql);
            if (v != null && v.size() > 0)
                ret = ((String[]) v.elementAt(0))[1];
        } catch (Exception e) {
            Debug.println(e.getMessage());
        }
        return ret;
    }
}
