package com.example.tmccasestudy.command.application.ports.input;

import com.example.tmccasestudy.command.domain.model.Category;

public interface CategoryEventSubscriber {

    void consume(Category category);
}
