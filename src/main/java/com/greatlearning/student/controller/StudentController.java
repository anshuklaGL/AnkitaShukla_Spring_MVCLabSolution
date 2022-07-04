package com.greatlearning.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.student.model.Student;
import com.greatlearning.student.service.StudentService;

@Controller
@RequestMapping("/student")	// http(s)://<host>/<projectname>/student
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")	// http(s)://<host>/<projectname>/student/list
	public String showStudents(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "student-list";	//	/WEB-INF/views/student-list.jsp
	}
	@RequestMapping("/addNewStudent")
	public String addNewStudenr(Model model) {
		Student student = new Student();
		model.addAttribute("studentObj", student);
		return "student-form";
	}
	@RequestMapping("/updateStudent")	// /StudentManagement/updateStudent/updateBook?id=2
	public String updateStudent(@RequestParam(name = "id") int studentId, Model model) {
		Student student = studentService.getstudent(studentId);
		model.addAttribute("studentObj", student);
		return "student-form";
	}
	@PostMapping("/save")
	public String saveStudent(@RequestParam(name = "id") int studentId, 
			@RequestParam(value = "name") String name,
			@RequestParam(value = "department") String department,
			@RequestParam(value = "country") String country
			) {
		Student student = null;
		if (studentId == 0) {
			student = new Student(name, department, country);
		} else {
			student = studentService.getstudent(studentId);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}
		studentService.save(student);
		return "redirect:list";
	}
	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam(name="id")int studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:list";	// StudentManagement/student/list
	}
	
}
