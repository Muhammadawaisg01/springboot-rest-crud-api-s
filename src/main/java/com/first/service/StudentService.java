


package com.first.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.first.model.Student;


public interface StudentService {
	
	
	public List<Student> getAllStudents() ;
	
	public Student getStudent(int studentId) ;

	public Student addStudent(Student student);

	public Student updateStudent(int studentId, Student student);

	public ResponseEntity<String> deleteStudent(int studentId);   

}
