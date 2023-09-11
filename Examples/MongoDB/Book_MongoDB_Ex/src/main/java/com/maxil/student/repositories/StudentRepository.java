package com.maxil.student.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maxil.student.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}