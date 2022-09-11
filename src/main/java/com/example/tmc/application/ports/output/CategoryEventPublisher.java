package com.example.tmc.application.ports.output;

import com.example.tmc.domain.model.Category;

public interface CategoryEventPublisher {

    void publishCategoryCreateEvent(Category category);
}
