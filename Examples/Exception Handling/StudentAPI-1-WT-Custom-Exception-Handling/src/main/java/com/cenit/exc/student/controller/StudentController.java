package com.cenit.exc.student.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenit.exc.student.exception.BadRequestException;
import com.cenit.exc.student.exception.DataNotFoundException;
import com.cenit.exc.student.exception.ErrorDetails;
import com.cenit.exc.student.model.Student;
import com.cenit.exc.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(int id) throws Exception {
		Optional<Student> student = studentService.getStudentById(id);
		if (student.isEmpty())
			throw new DataNotFoundException("There is not student with this id - " + id);
		return ResponseEntity.status(HttpStatus.OK).body(student.get());
	}

	@PostMapping
	public ResponseEntity<Student> save(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.save(student));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student student) throws Exception {
		if (student == null || id != student.getId()) {
			throw new BadRequestException("incoming id in body doesn't match path");
		}
		return ResponseEntity.status(HttpStatus.OK).body(studentService.save(student));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		studentService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
	}

	@ExceptionHandler(value = { BadRequestException.class, DataNotFoundException.class })
	public ResponseEntity<ErrorDetails> dataNotFoundException(Exception ex) {
		ErrorDetails response = new ErrorDetails(new Date(), ex.getClass().getName(), ex.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
