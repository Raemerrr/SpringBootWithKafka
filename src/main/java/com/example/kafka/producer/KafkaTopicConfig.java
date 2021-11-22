package com.example.kafka.producer;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${kafka.greeting.topic}")
    private String greetingTopicName;

    @Value(value = "${kafka.filtered.topic}")
    private String filteredTopicName;

    @Value(value = "${kafka.partitioned.topic}")
    private String partitionedTopicName;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic createPartitionedTopic() {
        return new NewTopic(partitionedTopicName, 6, (short) 1);
    }

//    @Bean
//    public NewTopic createFilteredTopicTopic() {
//        return new NewTopic(filteredTopicName, 6, (short) 1);
//    }

    @Bean
    public NewTopic createGreetingTopic() {
        return new NewTopic(greetingTopicName, 1, (short) 1);
    }

}
