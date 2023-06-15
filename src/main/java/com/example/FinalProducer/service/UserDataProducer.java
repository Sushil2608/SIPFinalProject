package com.example.FinalProducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.FinalProducer.model.User;

@Service
public class UserDataProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDataProducer.class);
	
	private KafkaTemplate<String, User> kafkaTemplate;

	@Autowired
	public UserDataProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data) {
		LOGGER.info(String.format("Message sent(JSON) by Producer -> %s", data.toString()));
		Message<User> message = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, "GetTopic")
				.build();
		
		kafkaTemplate.send(message);
	}
}
