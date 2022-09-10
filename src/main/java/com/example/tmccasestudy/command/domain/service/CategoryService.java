package com.example.tmccasestudy.command.domain.service;

import com.example.tmccasestudy.command.application.ports.output.CategoryEventPublisher;
import com.example.tmccasestudy.command.application.ports.output.CategoryOutputPort;
import com.example.tmccasestudy.command.application.ports.input.CreateCategoryUseCase;
import com.example.tmccasestudy.command.domain.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService implements CreateCategoryUseCase {

    private final CategoryOutputPort categoryOutputPort;

    private final CategoryEventPublisher categoryEventPublisher;

    @Override
    public Category createCategory(Category category) {
        category.setId(UUID.randomUUID().toString());
        category.setCreatedAt(System.currentTimeMillis());
        category = categoryOutputPort.saveCategory(category);
        categoryEventPublisher.publishCategoryCreateEvent(category);
        return category;
    }
}
