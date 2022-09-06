package com.example.tmccasestudy.adapters.input.rest;

import com.example.tmccasestudy.ports.input.CreateCategoryService;
import com.example.tmccasestudy.domain.Category;
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
    public void submitCategory(@RequestBody Category category) {
        service.save(category);
    }
}
