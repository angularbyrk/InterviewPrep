package com.cenit.exc.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenit.exc.student.model.Student;
import com.cenit.exc.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;

	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	public Optional<Student> getStudentById(int id) {
		return repo.findById(id);
	}

	public Student save(Student student) {
		return repo.save(student);
	}

	public Student update(Student student) {
		return repo.save(student);
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}
}
