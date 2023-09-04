package com.cenit.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class PublishController {

	@Autowired
	KafkaTemplate<String, String> template;

	@GetMapping("/publish/{msg}")
	public void publishMessage(@PathVariable String msg) {
		template.send("topic1", msg);
	}

}
