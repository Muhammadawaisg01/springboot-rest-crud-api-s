

package com.first.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.first.model.Student;
import com.first.service.StudentService;


@RestController
public class MyController {

	
	@Autowired
	private StudentService stdService; 
	
	
	@GetMapping("/home")
	public String home() {
		return "Hello this is home";
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		return stdService.getAllStudents();
		
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable String studentId) {

		return stdService.getStudent(Integer.parseInt(studentId));
	}
	
	//, consumes = "application/json
	@PostMapping(path="/students")
	public Student addStudent(@RequestBody Student student) {
		
		System.out.println(student); 
		return this.stdService.addStudent(student);
	}
	
	@PutMapping("/student/{studentId}")
	public Student updateStudent(@PathVariable String studentId , @RequestBody Student student) {

		return this.stdService.updateStudent(Integer.parseInt(studentId), student);
	
	}
	
	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable String studentId ) {
		
		return this.stdService.deleteStudent(Integer.parseInt(studentId));
		
	}
	
}
