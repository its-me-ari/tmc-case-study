package com.example.tmccasestudy.command.domain.service;

import com.example.tmccasestudy.command.application.ports.input.CreateProductUseCase;
import com.example.tmccasestudy.command.application.ports.output.ProductOutputPort;
import com.example.tmccasestudy.command.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService implements CreateProductUseCase {

    private final ProductOutputPort productOutputPort;

    @Override
    public Product createProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        product.setCreatedAt(System.currentTimeMillis());
        product = productOutputPort.saveProduct(product);
        return product;
    }
}
