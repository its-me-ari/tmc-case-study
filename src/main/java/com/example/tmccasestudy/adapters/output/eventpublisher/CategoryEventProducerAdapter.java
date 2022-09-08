package com.example.tmccasestudy.adapters.output.eventpublisher;

import com.example.tmccasestudy.adapters.config.KafkaConstants;
import com.example.tmccasestudy.domain.Category;
import com.example.tmccasestudy.ports.output.CategoryEventProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryEventProducerAdapter implements CategoryEventProducer {

    private KafkaTemplate<String, Category> kafkaTemplate;

    public CategoryEventProducerAdapter(KafkaTemplate<String, Category> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Category category) {
        System.out.println("Try to send "+ category);
        kafkaTemplate.send(KafkaConstants.CATEGORY, category);
    }
}
