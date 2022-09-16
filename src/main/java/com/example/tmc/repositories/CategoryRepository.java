package com.example.tmc.repositories;


import com.example.tmc.entities.Category;

import java.util.Optional;

public interface CategoryRepository {

    Category save(Category category);

    Category saveDocument(Category category);

    Optional<Category> getById(String id);
}
