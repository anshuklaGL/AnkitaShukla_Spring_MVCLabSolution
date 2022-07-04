package com.greatlearning.student.service;

import java.util.List;
import java.util.StringJoiner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.student.model.Student;

@Repository // equivalent of @Component
public class StudentServiceImpl implements StudentService {

	private SessionFactory factory;

	private Session session;

	@Autowired
	public StudentServiceImpl(SessionFactory factory) {
		//super();
		this.factory = factory;
		try {
			this.session = factory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = factory.openSession();
		}
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = session.createQuery("from Student").list();

		return students;
	}

	@Override
	public Student getstudent(int studentId) {
		// TODO Auto-generated method stub
		Student student = session.get(Student.class, studentId);
		return student;
	}

	
	@Transactional
	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
//		Student student = new Student("Suresh", "B.Tech", "India");
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
	}

	@Transactional
	@Override
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, studentId);
		session.delete(student);
		tx.commit();
	}

}
