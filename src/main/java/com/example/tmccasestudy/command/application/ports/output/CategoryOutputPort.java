package com.example.tmccasestudy.command.application.ports.output;

import com.example.tmccasestudy.command.domain.model.Category;

public interface CategoryOutputPort {

    Category saveCategory(Category category);
}
