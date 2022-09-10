package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence;

import com.example.tmccasestudy.command.application.ports.output.CategoryOutputPort;
import com.example.tmccasestudy.command.domain.model.Category;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.mapper.CategoryPersistenceMapper;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryOutputPort {

    private final CategoryRepository categoryRepository;

    private final CategoryPersistenceMapper categoryPersistenceMapper;

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity categoryEntity = categoryPersistenceMapper.toCategoryEntity(category);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryPersistenceMapper.toCategory(categoryEntity);
    }

}
