package com.maxil.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxil.student.model.Student;
import com.maxil.student.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student add(Student student) {
		return studentRepository.save(student);
	}

	public Student update(Student studentToUpdate) {
		return studentRepository.save(studentToUpdate);
	}

	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	public Student getById(String id) {
		return studentRepository.findById(id).orElse(null);
	}

	public boolean delete(String id) {
		studentRepository.deleteById(id);
		return true;
	}
}
