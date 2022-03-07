package com.bhavna.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bhavna.model.University;

@Repository
public class UniversityDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<University> getUniversities() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<University> cq = cb.createQuery(University.class);
		Root<University> root = cq.from(University.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	public void saveUniversity(University university) {
		Session sessionOne = sessionFactory.openSession();
		sessionOne.beginTransaction();
		sessionOne.save(university);
		sessionOne.getTransaction().commit();
		sessionOne.close();
	}

	public University getUniversityById(int u_id) {
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		University university = currentSession.get(University.class, u_id);
		currentSession.getTransaction().commit();
		currentSession.close();

		return university;

	}
	
	public void updateUniversityById(int u_id,University university) {
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		currentSession.update(university);
		currentSession.getTransaction().commit();
		currentSession.close();

		

	}

}
