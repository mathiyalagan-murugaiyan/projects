package com.springbootapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("/students")
	
	public Map<?,String> getStudents() {
		
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "mathi");
		map.put(2, "marudhu");
		return  map;
	}

}
