package com.bhavna.employee.service;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bhavna.employee.entity.Employee;
import com.bhavna.employee.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository repo;

	public Employee getById(String e_name) {
		return repo.getEmployeeByName(e_name);
	}

	public String addEmployee(Employee employee) throws IOException {
		repo.save(employee);
		return  employee.getE_name()+"  record added successfully";
	}

}