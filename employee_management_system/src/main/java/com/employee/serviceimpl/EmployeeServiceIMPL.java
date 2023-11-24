package com.employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceIMPL implements EmployeeService{
	
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		
		return emprepo.findAll();
		
	}

	@Override
	public Optional<EmployeeEntity> getEmployeeById(long id) {
		
		return emprepo.findById(id);
	}
	

	@Override
	public String createEmployee(EmployeeEntity empentity) {
		
		emprepo.save(empentity);
		return empentity.getName();
	}

	@Override
	public EmployeeEntity updateEmployee(Long id , EmployeeEntity empentity) {
		
		boolean existsById = emprepo.existsById(id);
		
		EmployeeEntity updateemp = null;
		
		if(existsById) {
			
		EmployeeEntity existemp	= emprepo.findById(id).get();
		
		existemp.setName(empentity.getName());
		existemp.setAge(empentity.getAge());
		existemp.setEmail(empentity.getEmail());
		
	    updateemp = emprepo.save(existemp);
		
		}
		else {
			
	
		}
    
		return updateemp;	
	}

	@Override
	public String deleteEmployee( Long id) {
	
		emprepo.deleteById(id);
		return null;
		
	}




	

}
