package com.example.tmccasestudy.command.infrastructure.adapters.input.rest;

import com.example.tmccasestudy.command.application.ports.input.CreateCategoryUseCase;
import com.example.tmccasestudy.command.domain.model.Category;
import com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.request.CategoryCreateRequest;
import com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.response.CategoryCreateResponse;
import com.example.tmccasestudy.command.infrastructure.adapters.input.rest.mapper.CategoryRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories/v2")
@RequiredArgsConstructor
public class CategoryRestAdapter {

    private final CreateCategoryUseCase createCategoryUseCase;

    private final CategoryRestMapper categoryRestMapper;

    @PostMapping
    public ResponseEntity<CategoryCreateResponse> createCategory(@RequestBody CategoryCreateRequest categoryCreateRequest) {

        Category category = categoryRestMapper.toCategory(categoryCreateRequest);

        category = createCategoryUseCase.createCategory(category);

        return new ResponseEntity<>(categoryRestMapper.toCategoryCreateResponse(category), HttpStatus.CREATED);

    }

}
