package com.example.tmc.cqrs.controller.command;

import com.example.tmc.cqrs.dto.command.ProductCommandDto;
import com.example.tmc.cqrs.entity.Product;
import com.example.tmc.cqrs.mapper.ProductCommandMapper;
import com.example.tmc.cqrs.service.ProductCommandService;
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
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final ProductCommandService productCommandService;

    private final ProductCommandMapper productCommandMapper;

    @PostMapping
    public ResponseEntity<Map<String, Product>> createProduct(@RequestBody ProductCommandDto productCommandDto) {

        Product product = productCommandMapper.toProduct(productCommandDto);
        productCommandService.createProduct(product);

        Map<String, Product> payload = new HashMap<>();
        payload.put("data", product);

        return new ResponseEntity<>(payload, HttpStatus.CREATED);
    }
}
