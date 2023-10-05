package com.example.demo.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
//@Table(value="employee")
@Data
public class Empolyee {
	@Id
	
	private Long ID;
	
	private String name;
	
	private int age;
	
	private String city;

}
