package com.infor.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.infor.dao.DeptDao;
import com.infor.dto.Department;
import com.infor.util.DBConnection;

public class DeptDaoImpl implements DeptDao {

	@Override
	public Department getDeptById(long deptId) {
		String selectDeptQuery = "select * from dept where deptno ="+deptId;
		Connection conn = DBConnection.getDBConnection();
		try {
			Statement st = conn.createStatement();
			if(st.execute(selectDeptQuery)) {
				ResultSet rs = st.getResultSet();
				rs.next();
				Department dept = new Department();
				dept.setDeptNo(rs.getLong("deptno"));
				dept.setDeptName(rs.getString(2));
				dept.setLocation(rs.getString(3));
				return dept;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
