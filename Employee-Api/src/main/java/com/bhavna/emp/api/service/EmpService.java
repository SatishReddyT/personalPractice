package com.bhavna.emp.api.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bhavna.emp.api.entity.Employee;

public interface EmpService {

	String addEmployee(Employee employee);

	String deleteById(Integer e_id);

	Employee getById(Integer e_id);

	String updateById(Integer e_id, Employee employee);

	List<Employee> getAllEmp();

	Page<Employee> pagination(Pageable pageable);

}
