package com.bhavna.emp.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.emp.api.entity.Employee;
import com.bhavna.emp.api.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	EmpService service;

	@GetMapping(path = "/get/api/Employee/{e_id}")
	public Employee getById(@PathVariable("e_id") Integer e_id) {
		return service.getById(e_id);
	}

	@PostMapping(path = "/post/api/Employee")
	public String addEmployee(@RequestBody Employee employee) throws IOException {
		return service.addEmployee(employee);
	}

	@DeleteMapping(path = "/delete/api/Employee/{e_id}")
	public String deleteById(@PathVariable("e_id") Integer e_id) {
		return service.deleteById(e_id);
	}

	@PutMapping(path = "/put/api/Employee/{e_id}")
	public String updateEmpId(@PathVariable("e_id") Integer e_id, @RequestBody Employee employee) {
		return service.updateById(e_id, employee);
	}

	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return service.getAllEmp();
	}

	@GetMapping("/employees")
	Page<Employee> employeesPaging(Pageable pageable) {
		return service.pagination(pageable);
	}

}
//* POST /api/Employee : To Save an Employee Details
//* GET /api/Employee/{id} : To retrie the Specific Employee Details with the id
//* PUT /api/Employee : To Update the Employee Details
//* DELETE /api/Employee/{id} : Will Delete the specific Employee with the id
//* GET /api/Employees?page=1&size=10 : Use Spring JPA Pagination concept hereThe Specified URl will fetch First 10 records, and if page=2&size=10 it will fectch Records 11-20 in the DBs