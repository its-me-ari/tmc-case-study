package com.example.tmccasestudy.domain;

import com.example.tmccasestudy.ports.input.CreateCategoryService;
import com.example.tmccasestudy.ports.output.SaveCategoryPort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CreateCategoryService {

    private SaveCategoryPort saveCategoryPort;

    public CategoryServiceImpl(SaveCategoryPort saveCategoryPort) {
        this.saveCategoryPort = saveCategoryPort;
    }

    @Override
    public void save(Category category) {
        category.setUuid(UUID.randomUUID().toString());
        category.setCreatedAt(new Date());
        saveCategoryPort.save(category);
    }
}
