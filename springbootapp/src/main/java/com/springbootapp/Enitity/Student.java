package com.springbootapp.Enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="student")
@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private int mobile;

}
