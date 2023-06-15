package com.example.FinalConsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.FinalConsumer.model.User;
import com.example.FinalConsumer.repository.UserDataRepository;

@Service
public class UserDataConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDataConsumer.class);
	
	private UserDataRepository userDataRepository;
	
	public UserDataConsumer(UserDataRepository userDataRepository) {
		this.userDataRepository = userDataRepository;
	}

	//POST
	@KafkaListener(topics = "GetTopic", groupId = "myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("JSON Message Received by Consumer -> %s", user.toString()));
		userDataRepository.save(user);
	}
	
}
