package com.bhavna.emp.api.service;

import java.io.IOException;
import java.util.Optional;

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
	public String addEmployee(Employee employee) throws IOException {
		Optional<Employee> var = repo.findById(employee.getE_id());
		if (var.isPresent()) {
			throw new IOException("EMPLOYEE RECORD ALREADY EXIST");
		} else {
			repo.save(employee);

		}
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

	@Override()
	public String updateById(Employee employee) throws IOException {
		if (repo.existsById(employee.getE_id()))
			repo.save(employee);
		else
			throw new IOException("entered employee record is not present in order to update");
		return employee.getE_name()+" record updated";
	}

	@Override
	public Page<Employee> pagination(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
