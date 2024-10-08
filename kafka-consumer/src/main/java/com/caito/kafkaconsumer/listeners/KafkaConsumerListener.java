package com.caito.kafkaconsumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class KafkaConsumerListener {

    @KafkaListener(topics = "topic-spring", groupId = "group1")
    void listener(String message) {
        log.info("Listener");
        log.info("Mensaje recibido: " + message);
    }

}
