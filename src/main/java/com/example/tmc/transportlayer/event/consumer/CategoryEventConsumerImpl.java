package com.example.tmc.transportlayer.event.consumer;

import com.example.tmc.entities.Category;
import com.example.tmc.interactors.CategoryCommandService;
import com.example.tmc.config.kafka.KafkaGroups;
import com.example.tmc.config.kafka.KafkaTopics;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CategoryEventConsumerImpl {

    private final KafkaTemplate<String, Category> kafkaTemplate;

    private final CategoryCommandService categoryCommandService;

    @KafkaListener(
            topics = KafkaTopics.CATEGORY,
            groupId = KafkaGroups.TIRTA_MEDICAL_CENTRE
    )
    public void pull(Category category) {
        log.info("Pull {}", category);
        categoryCommandService.createDocument(category);
    }
}
