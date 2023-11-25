package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeEntity;
import com.employee.serviceimpl.EmployeeServiceIMPL;


@Controller
@RequestMapping("/")

public class EmployeeController {
	
	@Autowired
	private EmployeeServiceIMPL empservice;
	
      public String demo() {
		
		return "index";
	}
	
	
	@GetMapping("employees")
	public ResponseEntity<List<EmployeeEntity>> getEmployees(){
		
		return new ResponseEntity<List<EmployeeEntity>>(empservice.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("employee/{id}")
	public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable("id") Long id) {
		
		return new ResponseEntity<EmployeeEntity>(empservice.getEmployeeById(id).get(), HttpStatus.OK);
	}

	@PostMapping("addEmployee")
	public ResponseEntity<EmployeeEntity> addEmployee( @RequestBody EmployeeEntity empentity) {
	 
		empservice.createEmployee(empentity);
		return new ResponseEntity<EmployeeEntity>(empentity, HttpStatus.OK);
	}
	
	@PutMapping("updateEmployee/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("id") Long id , @RequestBody EmployeeEntity empentity) {
		
		 EmployeeEntity updateemp =empservice.updateEmployee(id ,empentity);
		
		return new ResponseEntity<EmployeeEntity>(updateemp,HttpStatus.OK);
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		
		empservice.deleteEmployee(id);
		
		return null;
	}
	
	

}
