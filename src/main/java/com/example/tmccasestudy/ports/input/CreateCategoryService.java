package com.example.tmccasestudy.ports.input;

import com.example.tmccasestudy.domain.Category;

public interface CreateCategoryService {
    void save(Category category);
}
