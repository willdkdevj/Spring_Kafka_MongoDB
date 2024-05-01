package com.accenture.testkafka.application;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrapServers}")
    private String bootstrapServers;

    @Value("${spring.kafka.producer.request.topic}")
    private String requestTopic;

    @Bean
    public NewTopic generateTopic(){

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // Reter as msgs por 1 dia
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Tamanho máximo de segmento (1GB)
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "10240000"); // Tamanho máximo da mensagem (1MB)

        return TopicBuilder.name(requestTopic)
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
