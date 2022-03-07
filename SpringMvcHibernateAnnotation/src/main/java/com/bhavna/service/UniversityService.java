package com.bhavna.service;

import java.util.List;

import com.bhavna.model.University;

public interface UniversityService {

	public List<University> getUniversities();

	public String saveUniversity(University university);

	public University getUniversity(int u_id);
	
	public String updateUniversityById(int u_id,University university);

}
