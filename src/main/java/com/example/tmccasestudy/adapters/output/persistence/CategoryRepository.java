package com.example.tmccasestudy.adapters.output.persistence;

import com.example.tmccasestudy.ports.output.SaveCategoryPort;
import com.example.tmccasestudy.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository implements SaveCategoryPort {

    private SpringDataCategoryRepository repository;

    public CategoryRepository(SpringDataCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

}
