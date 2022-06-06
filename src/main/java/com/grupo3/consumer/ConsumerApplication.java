package com.grupo3.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grupo3.consumer.core.ProcedureConsumer;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
		// ProcedureConsumer consumer = new ProcedureConsumer();
		// consumer.procedureConsumer("grupo3iLab");
	}

}
