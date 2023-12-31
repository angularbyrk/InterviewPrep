package com.cenit.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenit.ex.model.Student;

@RestController
@RequestMapping("/produce")
public class StudentProducer {
	
	@Autowired
	KafkaTemplate<String,Student> kafkaTemplate;
	
	@GetMapping("/{id}/{name}")
	public ResponseEntity<String> sendMsg(@PathVariable int id,@PathVariable String name){
		Student s = new Student(id,name);
		this.kafkaTemplate.send("topic1",s);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}

}
