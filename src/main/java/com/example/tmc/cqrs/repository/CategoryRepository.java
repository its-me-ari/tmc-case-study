package com.example.tmc.cqrs.repository;


import com.example.tmc.cqrs.entity.Category;

import java.util.Optional;

public interface CategoryRepository {

    Category save(Category category);

    Category saveDocument(Category category);

    Optional<Category> getById(String id);
}
