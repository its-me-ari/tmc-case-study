package com.example.tmccasestudy.command.infrastructure.adapters.input.rest;

import com.example.tmccasestudy.command.application.ports.input.CreateProductUseCase;
import com.example.tmccasestudy.command.domain.model.Product;
import com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.request.ProductCreatedRequest;
import com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.response.ProductCreateResponse;
import com.example.tmccasestudy.command.infrastructure.adapters.input.rest.mapper.ProductRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductRestAdapter {

    private final CreateProductUseCase createProductUseCase;
    private final ProductRestMapper productRestMapper;

    @PostMapping
    public ResponseEntity<ProductCreateResponse> createCategory(@RequestBody ProductCreatedRequest productCreatedRequest) {

        Product product = productRestMapper.toProduct(productCreatedRequest);

        product = createProductUseCase.createProduct(product);

        return new ResponseEntity<>(productRestMapper.toProductCreateResponse(product), HttpStatus.CREATED);

    }

}
