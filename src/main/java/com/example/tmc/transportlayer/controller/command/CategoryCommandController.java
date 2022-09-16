package com.example.tmc.transportlayer.controller.command;

import com.example.tmc.transportlayer.controller.dto.command.CategoryCommandDto;
import com.example.tmc.entities.Category;
import com.example.tmc.interactors.CategoryCommandService;
import com.example.tmc.transportlayer.controller.mapper.CategoryRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryCommandController {

    private final CategoryCommandService categoryCommandService;

    private final CategoryRestMapper categoryRestMapper;

    @PostMapping
    public ResponseEntity<Map<String, Category>> createCategory(@Valid @RequestBody CategoryCommandDto categoryCommandDto) {

        Category category = categoryRestMapper.toCategory(categoryCommandDto);
        categoryCommandService.createCategory(category);

        Map<String, Category> payload = new HashMap<>();
        payload.put("data", category);

        return new ResponseEntity<>(payload, HttpStatus.CREATED);
    }
}
