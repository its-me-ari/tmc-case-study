package com.example.tmccasestudy.command.infrastructure.adapters.input.eventlistener;

import com.example.tmccasestudy.command.application.ports.output.CategoryOutputNoSqlPort;
import com.example.tmccasestudy.command.application.ports.output.CategoryOutputPort;
import com.example.tmccasestudy.command.domain.model.Category;
import com.example.tmccasestudy.command.infrastructure.adapters.config.KafkaGroups;
import com.example.tmccasestudy.command.infrastructure.adapters.config.KafkaTopics;
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