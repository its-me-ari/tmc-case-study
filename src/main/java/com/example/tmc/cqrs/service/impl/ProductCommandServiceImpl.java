package com.example.tmc.cqrs.service.impl;

import com.example.tmc.cqrs.entity.Category;
import com.example.tmc.cqrs.entity.Product;
import com.example.tmc.cqrs.repository.CategoryRepository;
import com.example.tmc.cqrs.repository.ProductRepository;
import com.example.tmc.cqrs.service.ProductCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public Product createProduct(Product product) {

        Optional<Category> category = categoryRepository.getById(product.getCategory().getId());
        product.setCategory(category.get());
        product.setId(UUID.randomUUID().toString());
        product.setCreatedAt(System.currentTimeMillis());
        return productRepository.saveProduct(product);
    }
}
