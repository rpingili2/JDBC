package com.infor.dto;

public class Department {
	private long deptNo;
	private String deptName;
	private String location;
	
	public long getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(long deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public boolean equals(Object otherObj) {
		
		if(this == otherObj) {
			return true;
		}
		if(otherObj == null) {
			return false;
		} 
		if(this.getClass() != otherObj.getClass()) {
			return false;
		}
		
		Department otherDept = (Department) otherObj;
		if(this.deptNo != otherDept.deptNo) {
			return false;
		}
		if(this.deptName ==null || otherDept.deptName == null || !this.deptName.equals(otherDept.getDeptName())) {
			return false;
		}
		if(this.location ==null || otherDept.location == null || !this.location.equals(otherDept.getLocation())) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName
				+ ", location=" + location + "]";
	}
	
	
}
