package com.springbootapp.Enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="student")
@Entity
public class Student {

   

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Long mobile;
	
	public Student() {
		
	}

	public Student(Long id, String name, Long mobile) {
		super();
		this.id=id;
		this.name = name;
		this.mobile = mobile;
	}
}
