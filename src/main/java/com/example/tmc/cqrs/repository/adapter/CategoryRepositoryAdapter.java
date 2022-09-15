package com.example.tmc.cqrs.repository.adapter;

import com.example.tmc.cqrs.entity.Category;
import com.example.tmc.cqrs.entity.CategoryDocument;
import com.example.tmc.cqrs.mapper.CategoryCommandMapper;
import com.example.tmc.cqrs.repository.CategoryElasticRepository;
import com.example.tmc.cqrs.repository.CategoryJpaRepository;
import com.example.tmc.cqrs.repository.CategoryRepository;
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
