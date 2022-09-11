package com.example.tmc.infrastructure.adapters.output.persistence;

import com.example.tmc.application.ports.output.CategoryOutputNoSqlPort;
import com.example.tmc.domain.model.Category;
import com.example.tmc.infrastructure.adapters.output.persistence.entity.CategoryDocument;
import com.example.tmc.infrastructure.adapters.output.persistence.mapper.CategoryPersistenceNoSqlMapper;
import com.example.tmc.infrastructure.adapters.output.persistence.repository.CategoryNoSqlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryPersistenceNoSqlAdapter implements CategoryOutputNoSqlPort {
    private final CategoryNoSqlRepository categoryNoSqlRepository;
    private final CategoryPersistenceNoSqlMapper categoryPersistenceNoSqlMapper;

    @Override
    public Category saveCategory(Category category) {
        CategoryDocument categoryDocument = categoryPersistenceNoSqlMapper.toCategoryDocument(category);
        categoryDocument = categoryNoSqlRepository.save(categoryDocument);
        log.info("Category Saved {}", categoryDocument);
        return categoryPersistenceNoSqlMapper.toCategory(categoryDocument);
    }

}