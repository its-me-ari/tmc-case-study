package com.example.tmccasestudy.domain;

import com.example.tmccasestudy.ports.input.CreateCategoryService;
import com.example.tmccasestudy.ports.output.SaveCategoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryServiceImpl implements CreateCategoryService {

    private SaveCategoryPort saveCategoryPort;

    public CategoryServiceImpl(SaveCategoryPort saveCategoryPort) {
        this.saveCategoryPort = saveCategoryPort;
    }

    @Override
    public Category save(Category category) {
        category.setId(UUID.randomUUID().toString());
        category.setCreatedAt(System.currentTimeMillis());
        saveCategoryPort.save(category);
        return category;
    }
}
