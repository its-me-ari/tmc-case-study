package com.example.tmc.transportlayer.event.producer;

import com.example.tmc.entities.Product;

public interface ProductEventProducer {

    void pushProductCreateEvent(Product product);
}
