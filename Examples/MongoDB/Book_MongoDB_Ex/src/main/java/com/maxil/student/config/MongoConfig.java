package com.maxil.student.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.maxil.student.repositories.StudentRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackageClasses = StudentRepository.class)
public class MongoConfig {

	  @Bean
	  MongoClient mongoClient() {
	    ConnectionString connectionString
	        = new ConnectionString("mongodb://localhost:27017/practice");

	    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
	        .applyConnectionString(connectionString)
	        .applyToConnectionPoolSettings(builder -> builder.maxSize(20)
	            .minSize(10)
	            .maxWaitTime(2000, TimeUnit.MILLISECONDS)
	            .build())
	        .build();
	    return MongoClients.create(mongoClientSettings);
	  }

	@Bean
	MongoTemplate mongoTemplate(MongoClient mongoClient) {
		return new MongoTemplate(mongoClient, "testdb");
	}
}
