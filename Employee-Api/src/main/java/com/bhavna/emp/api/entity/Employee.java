package com.bhavna.emp.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TASK")
public class Employee {

	@Id
	@Column(name = "EMP_ID")
	private Integer e_id;

	@Column(name = "EMP_NAME")
	private String e_name;

	@Column(name = "AGE")
	private Integer age;

	@Column(name = "SALARY")
	private Long sal;

	@Column(name = "JOB_ROLE")
	private String role;

	@Column(name = "GENDER")
	private String gender;

	public Integer getE_id() {
		return e_id;
	}

	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getSal() {
		return sal;
	}

	public void setSal(Long sal) {
		this.sal = sal;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Employee() {

	}

	public Employee(Integer e_id, String e_name, Integer age, Long sal, String role, String gender) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.age = age;
		this.sal = sal;
		this.role = role;
		this.gender = gender;
	}

}