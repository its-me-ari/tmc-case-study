package com.example.tmc.infrastructure.adapters.output.persistence;

import com.example.tmc.application.ports.output.CategoryOutputPort;
import com.example.tmc.domain.model.Category;
import com.example.tmc.infrastructure.adapters.output.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryPersistenceAdapter implements CategoryOutputPort {

    private final CategoryRepository categoryRepository;


    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

}
