package com.cenit.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class MessageProducer {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("/{content}")
	public ResponseEntity<String> sendMsg(@PathVariable String content){
		this.kafkaTemplate.send("topic1",content);
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}

}
