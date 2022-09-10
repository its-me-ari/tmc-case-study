package com.example.tmccasestudy.command.infrastructure.adapters.output.eventpublisher;

import com.example.tmccasestudy.command.application.ports.output.CategoryEventPublisher;
import com.example.tmccasestudy.command.domain.model.Category;
import com.example.tmccasestudy.command.infrastructure.adapters.config.KafkaTopics;
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
