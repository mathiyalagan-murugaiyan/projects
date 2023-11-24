package com.employee.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name="employee_details")
public class EmployeeDetails {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_did")
	private Long did;
	
	@Column(name="emp_salary" ,nullable = false)
	private Float salary;
	
	@Column(name="emp_roll" , nullable = false)
	private String roll;
	
	@Column(name="emp_dateOfJoin" , nullable = false)
	private Date dateOfJoin;
	
	
}
