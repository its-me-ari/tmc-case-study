package com.example.tmc.repositories.datasources.adapter;

import com.example.tmc.entities.Category;
import com.example.tmc.entities.CategoryDocument;
import com.example.tmc.repositories.CategoryElasticRepository;
import com.example.tmc.repositories.CategoryJpaRepository;
import com.example.tmc.repositories.CategoryRepository;
import com.example.tmc.repositories.datasources.dao.CategoryDao;
import com.example.tmc.repositories.datasources.mapper.CategoryRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;

    private final CategoryElasticRepository categoryElasticRepository;

    private final CategoryRepositoryMapper categoryRepositoryMapper;

    @Override
    public Optional<Category> getById(String id) {
        Optional<CategoryDocument> categoryDocument = categoryElasticRepository.findById(id);
        if (categoryDocument.isPresent())
            return Optional.ofNullable(categoryRepositoryMapper.toCategory(categoryDocument.get()));
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        CategoryDao categoryDao = categoryRepositoryMapper.toCategoryDao(category);
        categoryDao = categoryJpaRepository.save(categoryDao);

        return categoryRepositoryMapper.toCategory(categoryDao);
    }

    @Override
    public Category saveDocument(Category category) {
        CategoryDocument categoryDocument = categoryRepositoryMapper.toCategoryDocument(category);
        categoryDocument = categoryElasticRepository.save(categoryDocument);

        return categoryRepositoryMapper.toCategory(categoryDocument);
    }
}
