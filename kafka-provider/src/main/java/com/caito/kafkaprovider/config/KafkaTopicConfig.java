package com.caito.kafkaprovider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    NewTopic generateTopic() {
        Map<String, String> configs = new HashMap<>();
        configs.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configs.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); //retiene 1 dia
        configs.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); //1GB tamaño de segmento
        configs.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "10485760"); //10MB tamaño maximo de mensaje
        return TopicBuilder
                .name("topic-spring")
                .partitions(1)
                .replicas(1)
                .configs(configs)
                .build();
    }
}
