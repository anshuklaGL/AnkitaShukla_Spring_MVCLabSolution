package com.greatlearning.student.service;

import java.util.List;

import com.greatlearning.student.model.Student;

public interface StudentService {
	public List<Student> getAllStudents();
	public Student getstudent(int studentId);
	public void save(Student student);
	public void deleteStudent(int studentId);
}
