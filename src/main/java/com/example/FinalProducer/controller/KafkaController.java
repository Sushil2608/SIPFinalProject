package com.example.FinalProducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FinalProducer.model.User;
import com.example.FinalProducer.service.UserDataProducer;

@RestController
@RequestMapping("/api")
public class KafkaController {

	private UserDataProducer userDataProducer;
	
	@Autowired
	public KafkaController(UserDataProducer userDataProducer) {
		this.userDataProducer = userDataProducer;
	}

	@PostMapping("/users")
	public ResponseEntity<String> publish(@RequestBody User user) {
		userDataProducer.sendMessage(user);
		return ResponseEntity.ok("JSON Message Sent to the Topic");
	}
	
}
