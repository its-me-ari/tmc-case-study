package com.example.tmccasestudy.adapters.input.rest;

import com.example.tmccasestudy.adapters.input.rest.data.CategoryResponse;
import com.example.tmccasestudy.ports.input.CreateCategoryService;
import com.example.tmccasestudy.domain.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private CreateCategoryService service;

    public CategoryController(CreateCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> submitCategory(@RequestBody Category category) {
        Category newCategory = service.save(category);
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setData(newCategory);
        return ResponseEntity.ok(categoryResponse);
    }
}
