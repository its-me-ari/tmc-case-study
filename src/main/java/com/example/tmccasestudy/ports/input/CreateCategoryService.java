package com.example.tmccasestudy.ports.input;

import com.example.tmccasestudy.domain.Category;

public interface CreateCategoryService {
    Category save(Category category);
}
