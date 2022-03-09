package com.bhavna.emp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhavna.emp.api.entity.Employee;

@Repository
public interface EmpRepository  extends JpaRepository<Employee, Integer>{

}
