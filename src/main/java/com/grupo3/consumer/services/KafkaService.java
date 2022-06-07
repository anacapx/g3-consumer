package com.grupo3.consumer.services;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private IOrderService orderService;

    public void readMessage(String groupId) throws InterruptedException, ExecutionException {
        var consumer = new KafkaConsumer<String, String>(properties(groupId));
        consumer.subscribe(Collections.singletonList("TOPIC_TEST"));

        while (true) {
            var records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> rec : records) {
                System.out.println("------------------------------------------");
                System.out.println("Partition: " + rec.partition());
                System.out.println("offset: " + rec.offset());
                System.out.println("key/value");
                System.out.println("key: " + rec.key());
                System.out.println("value: " + rec.value());

                Integer orderId = Integer.parseInt(rec.key());
                // Precisamos definir qual vai ser o key e o value
                // vou fazer pensando que vamos receber o order_id como key e o email do usuario como value
                if (rec.value() != null) {
                    String msgId = ServiceSES.sendMessage("Pedido " + rec.key() + " realizado.", rec.value());
                    if (msgId != null) {
                        orderService.updateStatusOrder(orderId);
                    }
                }
                System.out.println("Mensagem processada.");
                System.out.println("------------------------------------------");

            }

        }
    }

    private static Properties properties(String groupId) {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, UUID.randomUUID().toString());
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
        return properties;
    }

}
