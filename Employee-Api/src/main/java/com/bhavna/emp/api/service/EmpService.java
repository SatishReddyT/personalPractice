package com.bhavna.emp.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bhavna.emp.api.entity.Employee;

public interface EmpService {

	String addEmployee(Employee employee) throws IOException;

	String deleteById(Integer e_id);

	Employee getById(Integer e_id);

	String updateById(Employee employee) throws IOException;

	Page<Employee> pagination(Pageable pageable);

}
