package com.example.tmc.transportlayer.controller.command;

import com.example.tmc.entities.Product;
import com.example.tmc.interactors.ProductCommandService;
import com.example.tmc.transportlayer.controller.dto.command.ProductCommandDto;
import com.example.tmc.transportlayer.controller.mapper.ProductRestMapper;
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
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductCommandController {

    private final ProductCommandService productCommandService;

    private final ProductRestMapper productRestMapper;

    @PostMapping
    public ResponseEntity<Map<String, Product>> createProduct(@Valid @RequestBody ProductCommandDto productCommandDto) {

        Product product = productRestMapper.toProduct(productCommandDto);
        productCommandService.createProduct(product);

        Map<String, Product> payload = new HashMap<>();
        payload.put("data", product);

        return new ResponseEntity<>(payload, HttpStatus.CREATED);
    }
}
