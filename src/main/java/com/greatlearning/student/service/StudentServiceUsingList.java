package com.greatlearning.student.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.greatlearning.student.model.Student;

public class StudentServiceUsingList implements StudentService {

	private int lastStudentId;
	private List<Student> students = new ArrayList<>();

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(students);
	}

	@Override
	public Student getstudent(int studentId) {
		// TODO Auto-generated method stub
		return students.get(studentId-1);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		if (student.getId() == 0) {
			student.setId(++lastStudentId);
			students.add(student);
			return;
		}
		students.set(student.getId()-1, student);
	}

	@Override
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		students.set(studentId, null);
	}


}
