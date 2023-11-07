package com.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.Enitity.Student;
import com.springbootapp.repository.StudentRepo;

@Controller
public class StudentController {

	@Autowired
	StudentRepo studentrepo;

	Student student;

	 @GetMapping("/students")
	    public String getStudents(Model model) {
	        List<Student> students = studentrepo.findAll();
	        model.addAttribute("students", students);
	        return "New";
	    }

//	@PostMapping("/addstudent")
//	public Student addStudent(@RequestBody) {
//
//		Student student = new Student(id,name,mobile);
//		return null;
//
//	}

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
