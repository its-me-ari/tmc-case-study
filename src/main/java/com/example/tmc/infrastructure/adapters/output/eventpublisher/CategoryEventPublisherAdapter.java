package com.example.tmc.infrastructure.adapters.output.eventpublisher;

import com.example.tmc.application.ports.output.CategoryEventPublisher;
import com.example.tmc.domain.model.Category;
import com.example.tmc.infrastructure.adapters.config.kafka.KafkaTopics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryEventPublisherAdapter implements CategoryEventPublisher {

    private final KafkaTemplate<String, Category> kafkaTemplate;

    @Override
    public void publishCategoryCreateEvent(Category category) {
        kafkaTemplate.send(KafkaTopics.CATEGORY, category);
    }
}
