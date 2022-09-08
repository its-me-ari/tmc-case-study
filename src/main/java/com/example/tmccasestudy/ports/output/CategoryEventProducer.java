package com.example.tmccasestudy.ports.output;

import com.example.tmccasestudy.domain.Category;

public interface CategoryEventProducer {
    void send(Category category);
}
