package com.employee.entity;

import java.util.Date;

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
	private Long did;
	
	private Float salary;
	
	private String roll;
	
	private Date dateOfJoin;
	
	
}
