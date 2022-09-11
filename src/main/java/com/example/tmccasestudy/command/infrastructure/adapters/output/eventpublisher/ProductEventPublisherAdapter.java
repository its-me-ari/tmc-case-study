package com.example.tmccasestudy.command.infrastructure.adapters.output.eventpublisher;

import com.example.tmccasestudy.command.application.ports.output.ProductEventPublisher;
import com.example.tmccasestudy.command.domain.model.Product;
import com.example.tmccasestudy.command.infrastructure.adapters.config.KafkaTopics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class ProductEventPublisherAdapter implements ProductEventPublisher {
    private final KafkaTemplate<String, Product> kafkaTemplate;

    @Override
    public void publishProductCreateEvent(Product product) {
        kafkaTemplate.send(KafkaTopics.PRODUCT, product);
    }
}
