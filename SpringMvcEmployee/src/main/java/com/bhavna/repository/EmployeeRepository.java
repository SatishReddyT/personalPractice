package com.bhavna.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bhavna.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query(value = "SELECT * FROM employees e WHERE e.empStatus = 'Active'", nativeQuery = true)
	Collection<Employee> getAllActiveEmployees();
}