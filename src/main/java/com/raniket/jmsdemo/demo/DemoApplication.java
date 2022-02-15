package com.raniket.jmsdemo.demo;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public KafkaAdmin admin() {
		Map<String, Object> config = new HashMap<>();
		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		return new KafkaAdmin(config);
	}

	@Bean
	public NewTopic testTopic() {
		return TopicBuilder.name("test-topic")
				.partitions(1)
				.replicas(1)
				.build();
	}

	@KafkaListener(groupId =  "test-group-id", topics = "test-topic")
	public void testListener(String message) {
		System.out.println("Received message: " + message);
	}

}
