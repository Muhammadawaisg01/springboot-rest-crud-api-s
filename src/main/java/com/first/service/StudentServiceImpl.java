

package com.first.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.first.model.Student;
import com.first.repository.IStudent;

import jakarta.transaction.Transactional;


@Service
public class StudentServiceImpl implements StudentService {
	
	
	List<Student> list;
	
	@Autowired
	IStudent repo;
	
	public StudentServiceImpl() {
		
		list = new ArrayList<>();
		list.add(new Student(20, "Ali", 30));
		list.add(new Student(21, "Ahmed", 31));
		list.add(new Student(22, "khan", 32));
		list.add(new Student(23, "Sara", 33));
	}
	
	@Override
	public List<Student> getAllStudents() {
		
		return repo.findAll();
	}
	
	
	@Override
	public Student getStudent(int id) {
		
//		Student std = null;
//		for(Student s : list) {
//			if(s.getId() == id ) {
//				std = s;
//				break;
//			}
//		}

		Optional<Student> std = repo.findById(id);
		
		return std.get();
	}
	
	
	@Transactional
	@Override
	public Student addStudent(Student student) {
		
//		list.add(student);
		
		repo.save(student);
		
		return student;
	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		
//		for(Student std :list) {
//			if(std.getId() == studentId) {
//				std.setName(student.getName());
//				std.setAge(student.getAge());
//				return student;
//			}
//		}
		
		Student std = getStudent(studentId);
		
		return repo.save(student);
	}

	@Override
	public ResponseEntity<String> deleteStudent(int studentId) {
		
//		for(Student std : list) {
//			if(std.getId() == studentId) {
//				Student std1 = std;
//				list.remove(std);
//				return std1;
//			}
//		}	
		
		try {
			Student std = getStudent(studentId);
			repo.deleteById(studentId);
			
			return new ResponseEntity<>("Student with details :"+std.toString()+"  is deleted successfully", HttpStatus.OK);   			
			
		}catch(Exception ex) {
			return new ResponseEntity<>("Student with the ID :  "+ studentId+"  not found ", HttpStatus.NOT_FOUND);   						
		}
		
	}
	
}
