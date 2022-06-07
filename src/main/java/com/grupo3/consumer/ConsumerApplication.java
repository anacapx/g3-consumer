package com.grupo3.consumer;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.grupo3.consumer.services.KafkaService;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
		KafkaService kafkaService = context.getBean(KafkaService.class);
		kafkaService.readMessage("grupo3iLab");
	}

}
