package com.example.tmccasestudy.adapters.input.rest;

import com.example.tmccasestudy.adapters.input.rest.data.CategoryResponse;
import com.example.tmccasestudy.ports.input.CreateCategoryService;
import com.example.tmccasestudy.domain.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public ResponseEntity<?> submitCategory(@RequestBody @Valid Category category) {
        Category newCategory = service.save(category);
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setData(newCategory);
        return ResponseEntity.ok(categoryResponse);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
