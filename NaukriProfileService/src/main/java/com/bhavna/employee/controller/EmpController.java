package com.bhavna.employee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bhavna.employee.entity.Employee;
import com.bhavna.employee.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	EmpService service;
	
	@Value("${domain}")
	private String domain; 

	@GetMapping(path = "/get/employeeProfile/{e_name}"+"${domain}")
	public Employee getByName(@PathVariable("e_name") String e_name) {
		return service.getById(e_name);
	}

	@PostMapping(path = "/post/employeeProfile")
	public String addEmployee(@RequestBody Employee employee) throws IOException {
		return service.addEmployee(employee);
	}
}