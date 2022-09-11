package com.example.tmc.infrastructure.adapters.input.eventlistener;

import com.example.tmc.application.ports.output.CategoryOutputNoSqlPort;
import com.example.tmc.domain.model.Category;
import com.example.tmc.infrastructure.adapters.config.KafkaGroups;
import com.example.tmc.infrastructure.adapters.config.KafkaTopics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryEventListenerAdapter {

    private final KafkaTemplate<String, Category> kafkaTemplate;

    private final CategoryOutputNoSqlPort categoryOutputNoSqlPort;

    @KafkaListener(
            topics = KafkaTopics.CATEGORY,
            groupId = KafkaGroups.TIRTA_MEDICAL_CENTRE
    )
    public void consume(Category category) {
        categoryOutputNoSqlPort.saveCategory(category);
    }
}
