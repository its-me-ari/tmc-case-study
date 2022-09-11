package com.example.tmc.application.ports.output;

import com.example.tmc.domain.model.Category;

public interface CategoryOutputPort {

    Category saveCategory(Category category);
}
