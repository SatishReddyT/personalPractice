package com.bhavna.emp.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bhavna.emp.api.entity.Employee;
import com.bhavna.emp.api.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepository repo;

	@Override
	public String addEmployee(Employee employee) {
		repo.save(employee);
		return employee.getE_id() + " record added successfully";
	}

	@Override
	public String deleteById(Integer e_id) {
		repo.deleteById(e_id);
		return e_id + " record deleted succesfully";

	}

	@Override
	public Employee getById(Integer e_id) {
		return repo.findById(e_id).get();
	}

	@Override
	public String updateById(Integer e_id, Employee employee) {
		if (repo.existsById(e_id))
			repo.save(employee);
		return e_id + " record updated";
	}

	public List<Employee> getAllEmp() {
		return repo.findAll();
	}

	@Override
	public Page<Employee> pagination(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
