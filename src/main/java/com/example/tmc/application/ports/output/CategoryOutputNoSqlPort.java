package com.example.tmc.application.ports.output;

import com.example.tmc.domain.model.Category;

public interface CategoryOutputNoSqlPort {

    Category saveCategory(Category category);
}
