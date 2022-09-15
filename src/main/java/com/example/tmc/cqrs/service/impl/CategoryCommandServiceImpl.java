package com.example.tmc.cqrs.service.impl;

import com.example.tmc.cqrs.entity.Category;
import com.example.tmc.cqrs.repository.CategoryRepository;
import com.example.tmc.cqrs.service.CategoryCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryCommandServiceImpl implements CategoryCommandService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        category.setId(UUID.randomUUID().toString());
        category.setCreatedAt(System.currentTimeMillis());
        return categoryRepository.save(category);
    }
}
