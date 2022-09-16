package com.example.tmc.transportlayer.event.producer;

import com.example.tmc.entities.Category;

public interface CategoryEventProducer {

    void pushCategoryCreateEvent(Category category);
}
