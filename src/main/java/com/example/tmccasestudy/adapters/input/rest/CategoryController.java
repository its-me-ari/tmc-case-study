package com.example.tmccasestudy.adapters.input.rest;

import com.example.tmccasestudy.adapters.input.rest.data.CategoryRequest;
import com.example.tmccasestudy.ports.input.CreateCategoryService;
import com.example.tmccasestudy.domain.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, Category> responseMap = new HashMap<>();
        responseMap.put("data", newCategory);
        return ResponseEntity.ok(responseMap);
    }

}
