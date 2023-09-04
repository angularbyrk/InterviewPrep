package com.cenit.ex.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cenit.ex.model.Student;

@Service
public class StudentConsumer {
	
	@KafkaListener(topics = {"topic1"} , groupId = "spring-boot-kafka")
	public void consume(Student s) {
        System.out.println("received= " + s);
    } 

}
