package com.springbootapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.Enitity.Student;
import com.springbootapp.repository.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	StudentRepo studentrepo;

	@GetMapping("/student")
	public List<Student> getStudents() {
		
//		Map<Integer,String> map = new HashMap<>();
//	    map.put(1, "mathi");
//		map.put(2, "marudhu");
		
		List<Student> list = new ArrayList<Student>();
		
		list = studentrepo.findAll();
		list.stream()
		.sorted((s1,s2)-> s1.getName().compareTo(s2.getName()))
		.forEach(System.out::println);
				
		return  list;
		
	}

	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {

		Student s = studentrepo.save(student);

		return s;

	}

}
