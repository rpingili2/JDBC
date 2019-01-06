package com.infor.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.infor.dao.EmpDao;
import com.infor.util.DBConnection;

public class EmpDaoImpl implements EmpDao {

	/**
	 * create or replace procedure getEmpSal(id IN number,salary OUT number) AS
  		BEGIN
  		select sal into salary from emp where empno = id;
  		END;
  		/
	 */
	@Override
	public int getEmpSal(int empId) {
		Connection conn = DBConnection.getDBConnection();
		int salary = -1000;
		try {
			CallableStatement cs = conn.prepareCall("{call getEmpSal(?,?)}");
			cs.setInt(1, empId);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.execute();
			salary = cs.getInt(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salary;
	}
}
