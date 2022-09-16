package com.example.tmc.datasources;

import com.example.tmc.entities.Category;
import com.example.tmc.entities.CategoryDocument;
import com.example.tmc.transportlayer.controller.mapper.CategoryCommandMapper;
import com.example.tmc.repositories.CategoryElasticRepository;
import com.example.tmc.repositories.CategoryJpaRepository;
import com.example.tmc.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;

    private final CategoryElasticRepository categoryElasticRepository;

    private final CategoryCommandMapper categoryCommandMapper;

    @Override
    public Optional<Category> getById(String id) {
        Optional<CategoryDocument> categoryDocument = categoryElasticRepository.findById(id);
        if (categoryDocument.isPresent())
            return Optional.ofNullable(categoryCommandMapper.toCategory(categoryDocument.get()));
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return categoryJpaRepository.save(category);
    }

    @Override
    public Category saveDocument(Category category) {
        CategoryDocument categoryDocument = categoryCommandMapper.toCategoryDocument(category);
        categoryDocument = categoryElasticRepository.save(categoryDocument);
        return categoryCommandMapper.toCategory(categoryDocument);
    }
}
