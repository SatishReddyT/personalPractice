package com.bhavna.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

	@Id 
	@Column(name="EMPID")
	private Long empId;

	@Column(name="EMPNAME")
	private String empName;

	@Column(name="HIREDATE")
	private String Hiredate;

	@Column(name="SAL")
	private long sal;

	@Column(name="DEPTID")
	private int deptId;

	@Column(name="DEPTNAME")
	private String deptName;

	@Column(name="EMPSTATUS")
	private String empStatus;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getHiredate() {
		return Hiredate;
	}

	public void setHiredate(String hiredate) {
		Hiredate = hiredate;
	}

	public long getSal() {
		return sal;
	}

	public void setSal(long sal) {
		this.sal = sal;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

}