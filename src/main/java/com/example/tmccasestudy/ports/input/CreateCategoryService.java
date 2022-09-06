package com.example.tmccasestudy.ports.input;

import com.example.tmccasestudy.adapters.input.rest.data.CategoryRequest;
import com.example.tmccasestudy.domain.Category;

public interface CreateCategoryService {
    Category save(CategoryRequest category);
}
