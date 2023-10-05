package com.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootapp.Enitity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
