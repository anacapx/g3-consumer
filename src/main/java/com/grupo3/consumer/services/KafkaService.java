package com.grupo3.consumer.services;

import java.time.Duration;

import org.apache.kafka.clients.consumer.ConsumerRecords;

import com.grupo3.consumer.kafka.KafkaConsumerLocal;

public class KafkaService {
    public static ConsumerRecords<String, String> readMessage(String groupId) {
        return KafkaConsumerLocal.getConsumer(groupId).poll(Duration.ofMillis(200));
    }

}
