package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "topic_kafka", groupId = "consumer_group")
    public void consumeMessage(Message message) {
        System.out.println("Received Message: " + message);
    }
}

