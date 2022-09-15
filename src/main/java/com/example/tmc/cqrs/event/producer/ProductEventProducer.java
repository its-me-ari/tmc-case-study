package com.example.tmc.cqrs.event.producer;

import com.example.tmc.cqrs.entity.Product;

public interface ProductEventProducer {

    void pushProductCreateEvent(Product product);
}
