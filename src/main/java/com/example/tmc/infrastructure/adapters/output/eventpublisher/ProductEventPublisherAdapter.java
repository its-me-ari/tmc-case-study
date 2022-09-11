package com.example.tmc.infrastructure.adapters.output.eventpublisher;

import com.example.tmc.application.ports.output.ProductEventPublisher;
import com.example.tmc.domain.model.Product;
import com.example.tmc.infrastructure.adapters.config.kafka.KafkaTopics;
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
