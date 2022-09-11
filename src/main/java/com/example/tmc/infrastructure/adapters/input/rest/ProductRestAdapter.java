package com.example.tmc.infrastructure.adapters.input.rest;

import com.example.tmc.infrastructure.adapters.input.rest.mapper.ProductRestMapper;
import com.example.tmc.application.ports.input.CreateProductUseCase;
import com.example.tmc.domain.model.Product;
import com.example.tmc.infrastructure.adapters.input.rest.data.request.ProductCreatedRequest;
import com.example.tmc.infrastructure.adapters.input.rest.data.response.ProductCreateResponse;
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
public class ProductRestAdapter {

    private final CreateProductUseCase createProductUseCase;
    private final ProductRestMapper productRestMapper;

    @PostMapping
    public ResponseEntity<Map<String, ProductCreateResponse>> createProduct(@RequestBody ProductCreatedRequest productCreatedRequest) {

        Product product = productRestMapper.toProduct(productCreatedRequest);

        product = createProductUseCase.createProduct(product);

        Map<String, ProductCreateResponse> payload = new HashMap<>();
        payload.put("data", productRestMapper.toProductCreateResponse(product));

        return new ResponseEntity<>(payload, HttpStatus.CREATED);

    }

}
