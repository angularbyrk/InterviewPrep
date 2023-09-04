package com.cenit.ex;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class KafkaproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaproducerApplication.class, args);
	}

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("topic1").partitions(10).replicas(1).build();
	}

}
