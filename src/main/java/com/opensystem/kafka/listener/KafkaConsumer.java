package com.opensystem.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.opensystem.kafka.model.User;

@Service
public class KafkaConsumer {
	
	private static final String TOPIC_STRING = "Kafka_Demo";
	private static final String TOPIC_USER = "Kafka_Demo_User";
	
	
	@KafkaListener(topics = TOPIC_STRING, groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
	public void consumeString(String message) {
		System.out.println("Consumed message: " + message);
	}
	
	@KafkaListener(topics = TOPIC_USER, groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory")
	public void consumeUser(User user) {
		System.out.println("Consumed message: " + user);
	}
}
