package com.infor.dao;

import java.util.List;

import com.infor.dto.Employee;

public interface EmpDao {
	public int getEmpSal(int empId);
	public void printNameAndSal(int empId);
	public List<Employee> getAllEmps();
}
