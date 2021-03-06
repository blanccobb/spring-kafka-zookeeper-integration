package com.example.cobb.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Greeter {
    private static final Logger logger = LoggerFactory.getLogger(Greeter.class);
    
    @KafkaListener(topics = "greeting")
    public void consume(final @Payload String message,
                        final @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        logger.info(String.format("**************** Greeter sending the message now -> %s, topic: %s", message, topic));
    }
}
