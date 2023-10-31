package com.springbootapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.Enitity.Student;
import com.springbootapp.repository.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	StudentRepo studentrepo;

	Student student;

	@PostMapping("/student")
	public List<Student> getStudents() {

		List<Student> list = new ArrayList<Student>();

		list = studentrepo.findAll();
		list.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).forEach(System.out::println);

		return list;

	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {

		Student s = studentrepo.save(student);

		return s;

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {

		studentrepo.deleteById(id);

		return ResponseEntity.ok("deleted successfully");

	}

}
