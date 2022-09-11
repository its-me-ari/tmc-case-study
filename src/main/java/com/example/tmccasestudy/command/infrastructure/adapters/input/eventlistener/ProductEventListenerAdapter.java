package com.example.tmccasestudy.command.infrastructure.adapters.input.eventlistener;

import com.example.tmccasestudy.command.application.ports.output.ProductOutputNoSqlPort;
import com.example.tmccasestudy.command.domain.model.Product;
import com.example.tmccasestudy.command.infrastructure.adapters.config.KafkaGroups;
import com.example.tmccasestudy.command.infrastructure.adapters.config.KafkaTopics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventListenerAdapter {

    private final KafkaTemplate<String, Product> kafkaTemplate;

    private final ProductOutputNoSqlPort productOutputNoSqlPort;

    @KafkaListener(
            topics = KafkaTopics.PRODUCT,
            groupId = KafkaGroups.TIRTA_MEDICAL_CENTRE
    )
    public void consume(Product product) {
        productOutputNoSqlPort.saveProduct(product);
    }
}
