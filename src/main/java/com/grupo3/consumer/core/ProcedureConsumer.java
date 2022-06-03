package com.grupo3.consumer.core;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo3.consumer.services.IOrderService;
import com.grupo3.consumer.services.KafkaService;
import com.grupo3.consumer.services.ServiceSES;

@Component
public class ProcedureConsumer {

	@Autowired
	private IOrderService orderService;

	public void procedureConsumer(String groupId) {
		Integer counter = 0;
		while (counter <= 1000) {
			ConsumerRecords<String, String> recs = KafkaService.readMessage(groupId);
			if (recs.isEmpty()) {
				System.out.println("sem mensagens");
			} else {
				for (ConsumerRecord<String, String> rec : recs) {
					System.out.printf("Recieved %s: %s", rec.key(), rec.value());
					Integer orderId = Integer.parseInt(rec.key());

					// Precisamos definir qual vai ser o key e o value
					// vou fazer pensando que vamos receber o orer_id como key e o email como value

					if (!orderService.orderExists(orderId) || !orderService.orderInProgress(orderId)) {
						throw new RuntimeException("Pedido indisponivel");
					}
					String msgId = ServiceSES.sendMessage("testando", rec.value());
					if (msgId != null) {
						orderService.updateStatusOrder(orderId);
					}
				}
			}
			counter++;
		}
	}
}
