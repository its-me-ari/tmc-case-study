package com.example.tmc.cqrs.event.producer;

import com.example.tmc.cqrs.entity.Category;

public interface CategoryEventProducer {

    void pushCategoryCreateEvent(Category category);
}
