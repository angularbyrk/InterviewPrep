package com.cenit.ex.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
	
	@KafkaListener(topics = {"topic1"} , groupId = "spring-boot-kafka" )
	public void consume(String quote) {
        System.out.println("received= " + quote);
    } 

}
