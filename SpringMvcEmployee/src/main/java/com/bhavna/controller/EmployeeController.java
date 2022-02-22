package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.Employee;
import com.bhavna.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// home
	@RequestMapping(value = "/")
	public String home() {

		return "SpringMvcEmployee";
	}

	// Get All Users
	@RequestMapping(value = "/allActiveEmp", method = RequestMethod.GET)
	public List displayAllActiveEmployees() {
		System.out.println("Employee Page Requested : All Active Employees");
		List employeeList = employeeService.getAllActiveEmp();
		return employeeList;
	}

	@RequestMapping(value = "/getEmployee/{empId}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable Long empId) {
		Employee emp = employeeService.getEmployeeById(empId);
		return emp;
	}
}
