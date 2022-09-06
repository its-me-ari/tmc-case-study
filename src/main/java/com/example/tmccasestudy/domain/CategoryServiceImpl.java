package com.example.tmccasestudy.domain;

import com.example.tmccasestudy.adapters.input.rest.data.CategoryRequest;
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
    public Category save(CategoryRequest category) {
        Category newCategory = new Category();
        newCategory.setId(UUID.randomUUID().toString());
        newCategory.setName(category.getName());
        newCategory.setCreatedAt(System.currentTimeMillis());
        saveCategoryPort.save(newCategory);
        return newCategory;
    }
}
