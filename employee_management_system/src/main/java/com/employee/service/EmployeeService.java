package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.entity.EmployeeEntity;

public interface EmployeeService {
	
public List<EmployeeEntity> getAllEmployees();
	
	public Optional<EmployeeEntity> getEmployeeById( long id);
	
	public String createEmployee(EmployeeEntity empentity);
	
	public EmployeeEntity updateEmployee(Long id , EmployeeEntity empentity);
	
	public String deleteEmployee(Long id);
		

}
