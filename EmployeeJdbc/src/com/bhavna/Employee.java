package com.bhavna;

public class Employee {
	int empId;
	String empName;
	long sal;
	String hireDate;
	String deptId;
	String deptName;
	String loc;

	public Employee(int empId, String empName, long sal, String hireDate, String deptId, String deptName, String loc) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.sal = sal;
		this.hireDate = hireDate;
		this.deptId = deptId;
		this.deptName = deptName;
		this.loc = loc;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getSal() {
		return sal;
	}

	public void setSal(long sal) {
		this.sal = sal;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	

}
