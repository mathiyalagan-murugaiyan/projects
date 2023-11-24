package com.employee.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.entity.EmployeeEntity;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
public String demo() {
		
		return "index";
	}
	
	
	@GetMapping("employees")
	public List<EmployeeEntity> getEmployees(){
		return null;
	}
	
	@GetMapping("employee")
	public EmployeeEntity getEmployee() {
		
		return null;
	}
	
	@PostMapping("addEmployee")
	public void addEmployee() {
		
	}
	
	@PutMapping("updateEmployee")
	public String updateEmployee() {
		
		return null;
	}
	
	@DeleteMapping("deleteEmployee")
	public String deleteEmployee() {
		
		return null;
	}
	
	

}
