package com.example.tmc.cqrs.controller.command;

import com.example.tmc.cqrs.dto.command.CategoryCommandDto;
import com.example.tmc.cqrs.entity.Category;
import com.example.tmc.cqrs.mapper.CategoryCommandMapper;
import com.example.tmc.cqrs.service.CategoryCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryCommandController {

    private final CategoryCommandService categoryCommandService;

    private final CategoryCommandMapper categoryCommandMapper;

    @PostMapping
    public ResponseEntity<Map<String, Category>> createCategory(@RequestBody CategoryCommandDto categoryCommandDto) {

        Category category = categoryCommandMapper.toCategory(categoryCommandDto);
        categoryCommandService.createCategory(category);

        Map<String, Category> payload = new HashMap<>();
        payload.put("data", category);

        return new ResponseEntity<>(payload, HttpStatus.CREATED);
    }
}
