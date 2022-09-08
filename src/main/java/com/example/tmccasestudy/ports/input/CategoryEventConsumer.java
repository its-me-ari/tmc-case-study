package com.example.tmccasestudy.ports.input;

import com.example.tmccasestudy.domain.Category;

public interface CategoryEventConsumer {
    void consume(Category category);
}
