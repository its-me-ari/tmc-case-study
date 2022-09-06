package com.example.tmccasestudy.adapters.input.rest;

import com.example.tmccasestudy.adapters.input.rest.data.ApiResponse;
import com.example.tmccasestudy.adapters.input.rest.data.CategoryRequest;
import com.example.tmccasestudy.ports.input.CreateCategoryService;
import com.example.tmccasestudy.domain.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private CreateCategoryService service;

    public CategoryController(CreateCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> submitCategory(@RequestBody @Valid CategoryRequest category) {
        Category newCategory = service.save(category);
        ApiResponse categoryResponse = new ApiResponse();
        categoryResponse.setData(newCategory);
        return ResponseEntity.ok(categoryResponse);
    }

}
