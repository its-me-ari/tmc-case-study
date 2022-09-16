package com.example.tmc.interactors.impl;

import com.example.tmc.entities.Category;
import com.example.tmc.transportlayer.event.producer.CategoryEventProducer;
import com.example.tmc.repositories.CategoryRepository;
import com.example.tmc.interactors.CategoryCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryCommandServiceImpl implements CategoryCommandService {

    private final CategoryRepository categoryRepository;

    private final CategoryEventProducer categoryEventProducer;

    @Override
    public Category createCategory(Category category) {
        category.setId(UUID.randomUUID().toString());
        category.setCreatedAt(System.currentTimeMillis());
        Category newCategory = categoryRepository.save(category);
        categoryEventProducer.pushCategoryCreateEvent(newCategory);
        return newCategory;
    }

    @Override
    public Category createDocument(Category category) {
        return categoryRepository.saveDocument(category);
    }
}
