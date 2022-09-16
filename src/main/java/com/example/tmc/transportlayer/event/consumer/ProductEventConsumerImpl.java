package com.example.tmc.transportlayer.event.consumer;

import com.example.tmc.entities.Product;
import com.example.tmc.interactors.ProductCommandService;
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
public class ProductEventConsumerImpl {

    private final KafkaTemplate<String, Product> kafkaTemplate;

    private final ProductCommandService productCommandService;

    @KafkaListener(
            topics = KafkaTopics.PRODUCT,
            groupId = KafkaGroups.TIRTA_MEDICAL_CENTRE
    )
    public void pull(Product product) {
        log.info("Pull {}", product);
        productCommandService.createDocument(product);
    }
}
