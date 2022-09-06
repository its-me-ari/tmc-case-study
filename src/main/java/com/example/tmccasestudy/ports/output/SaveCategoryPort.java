package com.example.tmccasestudy.ports.output;

import com.example.tmccasestudy.domain.Category;

public interface SaveCategoryPort {
    void save(Category category);
}
