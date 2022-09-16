package com.example.tmc.transportlayer.event.producer;

import com.example.tmc.entities.Product;
import com.example.tmc.infrastructure.adapters.config.kafka.KafkaTopics;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductEventProducerImpl implements ProductEventProducer {

    private final KafkaTemplate<String, Product> kafkaTemplate;

    @Override
    public void pushProductCreateEvent(Product product) {
        log.info("Push product create event {}", product);
        kafkaTemplate.send(KafkaTopics.PRODUCT, product);
    }
}
