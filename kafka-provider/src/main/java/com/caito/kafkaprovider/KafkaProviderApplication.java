package com.caito.kafkaprovider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProviderApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            System.out.println("Kafka Provider is running...");
            kafkaTemplate.send("topic-spring", "Hello, World!");
        };
    }
}
