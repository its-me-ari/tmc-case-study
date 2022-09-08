package com.example.tmccasestudy.domain;

import com.example.tmccasestudy.adapters.input.rest.data.CategoryRequest;
import com.example.tmccasestudy.ports.input.CreateCategoryService;
import com.example.tmccasestudy.ports.output.CategoryEventProducer;
import com.example.tmccasestudy.ports.output.SaveCategoryPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryServiceImpl implements CreateCategoryService {

    private SaveCategoryPort saveCategoryPort;

    private CategoryEventProducer categoryEventProducer;

    public CategoryServiceImpl(SaveCategoryPort saveCategoryPort, CategoryEventProducer categoryEventProducer) {
        this.saveCategoryPort = saveCategoryPort;
        this.categoryEventProducer = categoryEventProducer;
    }

    @Override
    public Category save(CategoryRequest category) {
        Category newCategory = new Category();
        newCategory.setId(UUID.randomUUID().toString());
        newCategory.setName(category.getName());
        newCategory.setCreatedAt(System.currentTimeMillis());
        saveCategoryPort.save(newCategory);
        categoryEventProducer.send(newCategory);
        return newCategory;
    }
}
