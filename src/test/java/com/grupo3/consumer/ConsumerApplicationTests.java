package com.grupo3.consumer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grupo3.consumer.services.classes.ServiceSES;

@SpringBootTest
class ConsumerApplicationTests {
	@Test
	void contextLoads() {
	}
	@Test
	void itShouldReturnAMsgId() {
    String msgId = ServiceSES.sendMessage("Test", "Testing", "success@simulator.amazonses.com");
    assertNotNull(msgId);
  }
}
