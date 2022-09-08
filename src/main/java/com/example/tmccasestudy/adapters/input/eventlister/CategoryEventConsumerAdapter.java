package com.example.tmccasestudy.adapters.input.eventlister;

import com.example.tmccasestudy.adapters.config.KafkaConstants;
import com.example.tmccasestudy.ports.input.CategoryEventConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CategoryEventConsumerAdapter implements CategoryEventConsumer {

    @KafkaListener(
            topics = KafkaConstants.CATEGORY,
            groupId = KafkaConstants.TMC
    )
    @Override
    public void consume(String message) {
        System.out.println("Message received = " + message);
    }

}