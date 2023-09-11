package com.maxil.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxil.student.model.Student;

@RestController
@RequestMapping
public class StudentController {

	@Autowired
	StudentService mongoRepositoryServiceImpl;

	@GetMapping("/insert")
	public void insertStudent() {
		Student s1 = new Student();
	    s1.setName("s1");
	    s1.setEmail("s1@gmail.com");
	    mongoRepositoryServiceImpl.add(s1);
	}
	
}
