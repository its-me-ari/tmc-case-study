package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence;

import com.example.tmccasestudy.command.application.ports.output.CategoryOutputPort;
import com.example.tmccasestudy.command.domain.model.Category;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity.CategoryDocument;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.mapper.CategoryPersistenceMapper;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.repository.CategoryNoSqlRepository;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryPersistenceAdapter implements CategoryOutputPort {

    private final CategoryRepository categoryRepository;

    private final CategoryNoSqlRepository categoryNoSqlRepository;

    private final CategoryPersistenceMapper categoryPersistenceMapper;

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity categoryEntity = categoryPersistenceMapper.toCategoryEntity(category);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryPersistenceMapper.toCategory(categoryEntity);
    }

    @Override
    public void saveAsDocument(Category category) {
        CategoryDocument categoryDocument = categoryPersistenceMapper.toCategoryDocument(category);
        categoryDocument = categoryNoSqlRepository.save(categoryDocument);
        log.info("Category Saved {}", categoryDocument);
    }

}
