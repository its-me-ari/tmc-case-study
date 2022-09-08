package com.example.tmccasestudy.adapters.output.eventpublisher;

import com.example.tmccasestudy.adapters.config.KafkaConstants;
import com.example.tmccasestudy.ports.output.CategoryEventProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryEventProducerAdapter implements CategoryEventProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public CategoryEventProducerAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String message) {
        System.out.println("Try to send "+message);
        kafkaTemplate.send(KafkaConstants.CATEGORY, message);
    }
}
