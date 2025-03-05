package com.example.kafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    private static final String TOPIC = "topic_kafka";

    @PostMapping("/publish")
    public String sendMessage(@RequestBody Message message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message sent: " + message;
    }
}

