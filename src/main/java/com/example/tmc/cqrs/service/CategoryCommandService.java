package com.example.tmc.cqrs.service;

import com.example.tmc.cqrs.entity.Category;

public interface CategoryCommandService {

    Category createCategory(Category category);

    Category createDocument(Category category);
}
