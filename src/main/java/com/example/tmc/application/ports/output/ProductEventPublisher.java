package com.example.tmc.application.ports.output;

import com.example.tmc.domain.model.Product;
public interface ProductEventPublisher {
    void publishProductCreateEvent(Product product);
}
