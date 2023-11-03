package com.springbootapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.Enitity.Student;
import com.springbootapp.repository.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	StudentRepo studentrepo;

	Student student;

	@GetMapping("/students")
	public List<Student> getStudents(Model model ,Student student) {

		List<Student> list = new ArrayList<Student>();

		list = studentrepo.findAll();
		model.addAttribute(list);
		model.addAttribute("id", student.getId());
		model.addAttribute("name", student.getName());
		model.addAttribute("mobile", student.getMobile());

		return list;

	}

	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {

		Student s = studentrepo.save(student);

		return s;

	}

	@PutMapping("/students{id}")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		
		
		studentrepo.save(student);

		return ResponseEntity.ok("data save successfully");

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {

		studentrepo.deleteById(id);

		return ResponseEntity.ok("deleted successfully");

	}

}
