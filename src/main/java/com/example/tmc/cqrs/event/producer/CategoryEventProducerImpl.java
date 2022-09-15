package com.example.tmc.cqrs.event.producer;

import com.example.tmc.cqrs.entity.Category;
import com.example.tmc.infrastructure.adapters.config.kafka.KafkaTopics;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CategoryEventProducerImpl implements CategoryEventProducer {

    private final KafkaTemplate<String, Category> kafkaTemplate;

    @Override
    public void pushCategoryCreateEvent(Category category) {
        log.info("Push category create event {}", category);
        kafkaTemplate.send(KafkaTopics.CATEGORY, category);
    }
}
