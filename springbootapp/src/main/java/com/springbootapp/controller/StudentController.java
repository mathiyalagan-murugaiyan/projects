package com.springbootapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	        return "New" ;
	    }

	@PostMapping("/addstudent")
	public String addStudent( @ModelAttribute ("student") Student student, Model model) {

		studentrepo.save(student);
		 model.addAttribute("students", student);
       return "redirect:/students" ;
	}   
	
	@PostMapping("/students/update/{id}")
	public String updateStudent(@PathVariable Long uid, @ModelAttribute("student") Student ustudent , Model model ) {
		
		Student student1 = studentrepo.findById(uid).get();
        student1.setName(ustudent.getName());
        student1.setMobile(ustudent.getMobile());

		studentrepo.save(student1);

      return "redirect:/students";	

	}

	@GetMapping("students/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
       studentrepo.deleteById(id);
		

		return "redirect:/students" ;

	}

}
