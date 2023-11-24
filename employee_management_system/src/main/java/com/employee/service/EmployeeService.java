package com.employee.service;

import java.util.List;

import com.employee.entity.EmployeeEntity;

public interface EmployeeService {
	
public List<EmployeeEntity> getAllEmployees();
	
	public EmployeeEntity getEmployeeById();
	
	public void createEmployee();
	
	public EmployeeEntity updateEmployee();
	
	public String deleteEmployee();
		

}
