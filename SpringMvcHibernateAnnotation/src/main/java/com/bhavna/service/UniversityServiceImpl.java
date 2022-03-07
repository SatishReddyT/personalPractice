package com.bhavna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.dao.UniversityDao;
import com.bhavna.model.Student;
import com.bhavna.model.University;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	UniversityDao uniDao;

	@Override
	public String saveUniversity(University university) {
		uniDao.saveUniversity(university);
		return "University added successfully "+university.getU_name();
	}

	@Override
	public University getUniversity(int u_id) {
		return uniDao.getUniversityById(u_id);
	}

	@Override
	public List<University> getUniversities() {
		return uniDao.getUniversities();
	}

	@Override
	public String updateUniversityById(int u_id, University university) {
		uniDao.updateUniversityById(u_id, university);
		return "University details updated successfully "+university.getU_id();
	}
	

}
