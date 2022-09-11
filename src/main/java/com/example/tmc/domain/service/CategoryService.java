package com.example.tmc.domain.service;

import com.example.tmc.application.ports.output.CategoryOutputPort;
import com.example.tmc.domain.model.Category;
import com.example.tmc.application.ports.output.CategoryEventPublisher;
import com.example.tmc.application.ports.input.CreateCategoryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService implements CreateCategoryUseCase {

    private final CategoryOutputPort categoryOutputPort;

    private final CategoryEventPublisher categoryEventPublisher;

    @Override
    public Category createCategory(@Valid Category category) {
        category.setId(UUID.randomUUID().toString());
        category.setCreatedAt(System.currentTimeMillis());
        category = categoryOutputPort.saveCategory(category);
        categoryEventPublisher.publishCategoryCreateEvent(category);
        return category;
    }
}
