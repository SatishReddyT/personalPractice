package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.Student;
import com.bhavna.model.University;
import com.bhavna.service.UniversityService;

@RestController
public class UniversityController {

	@Autowired
	 UniversityService service;

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String sample() {
		return "Hello world";
	}

	@GetMapping("/getAllUniversities")
	@ResponseBody
	public List<University> getAllUniversities() {
		return service.getUniversities();
	}

	@RequestMapping(value = "/getUniversityById/{u_id}", method = RequestMethod.GET)
	public University getUniversity(@PathVariable("u_id") Integer u_id) {
		return service.getUniversity(u_id);
	}


	@RequestMapping(value = "/saveUniversity", method = RequestMethod.POST)
	public String saveUniversity(@RequestBody University university) {
		return service.saveUniversity(university);
	}
	
	@RequestMapping(value = "/UpdateUniversity/{u_id}", method = RequestMethod.PUT)
	public String updateUniversity(@PathVariable( "u_id")int  u_id,@RequestBody University university) {
		return service.updateUniversityById(u_id, university);
	}
}
