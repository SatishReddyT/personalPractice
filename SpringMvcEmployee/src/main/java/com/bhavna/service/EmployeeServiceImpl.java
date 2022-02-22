package com.bhavna.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bhavna.model.Employee;
import com.bhavna.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List getAllActiveEmp() {
		List list=(List) repository.getAllActiveEmployees();
		return list;

	}

	@Override
	public Employee getEmployeeById(Long empId) {
		Employee emp = repository.findById(empId).get();
		return emp;
	}

}
