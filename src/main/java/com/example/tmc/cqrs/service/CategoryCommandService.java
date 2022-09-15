package com.example.tmc.cqrs.service;

import com.example.tmc.cqrs.entity.Category;

public interface CategoryCommandService {

    void createCategory(Category category);
}
