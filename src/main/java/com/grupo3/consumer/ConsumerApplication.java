package com.grupo3.consumer;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grupo3.consumer.services.KafkaService;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		KafkaService service = new KafkaService();
		service.readMessage("grupo3iLab");
		// SpringApplication.run(ConsumerApplication.class, args);
		// System.out.println("Kafka host -> " + System.getenv("KAFKA_HOST"));
		// System.out.println("Kafka topic -> " + System.getenv("KAFKA_TOPIC"));
		// ProcedureConsumer consumer = new ProcedureConsumer();
		// consumer.procedureConsumer("grupo3iLab");
	}

}
