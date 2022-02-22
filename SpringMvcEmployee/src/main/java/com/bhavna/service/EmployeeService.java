package com.bhavna.service;

import java.util.List;

import com.bhavna.model.Employee;

public interface EmployeeService {

	public List getAllActiveEmp();
	public Employee getEmployeeById(Long empId);
}
