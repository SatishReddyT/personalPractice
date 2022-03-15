package com.bhavna.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bhavna.employee.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, String> {

	@Query(value="select * from employee_db e where e.emp_name=:name", nativeQuery=true)
	Employee getEmployeeByName(String name);
}
