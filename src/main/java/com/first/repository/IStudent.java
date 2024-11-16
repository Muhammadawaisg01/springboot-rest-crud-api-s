


package com.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.model.Student;


public interface IStudent extends JpaRepository<Student, Integer> { 

}
