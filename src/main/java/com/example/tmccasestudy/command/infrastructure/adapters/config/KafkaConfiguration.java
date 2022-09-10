package com.example.tmccasestudy.command.infrastructure.adapters.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic categoryTopic(){
        return TopicBuilder.name(KafkaTopics.CATEGORY).build();
    }
}
