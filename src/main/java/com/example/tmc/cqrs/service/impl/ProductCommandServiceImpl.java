package com.example.tmc.cqrs.service.impl;

import com.example.tmc.cqrs.entity.Category;
import com.example.tmc.cqrs.entity.Product;
import com.example.tmc.cqrs.event.producer.ProductEventProducer;
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

    private final ProductEventProducer productEventProducer;

    @Override
    public Product createProduct(Product product) {

        Optional<Category> category = categoryRepository.getById(product.getCategory().getId());
        product.setCategory(category.get());
        product.setId(UUID.randomUUID().toString());
        product.setCreatedAt(System.currentTimeMillis());
        Product newProduct = productRepository.saveProduct(product);
        productEventProducer.pushProductCreateEvent(newProduct);
        return newProduct;

    }

    @Override
    public Product createDocument(Product product) {
        return productRepository.saveDocument(product);
    }
}
