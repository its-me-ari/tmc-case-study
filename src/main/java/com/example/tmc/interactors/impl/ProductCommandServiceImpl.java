package com.example.tmc.interactors.impl;

import com.example.tmc.entities.Category;
import com.example.tmc.entities.Product;
import com.example.tmc.transportlayer.event.producer.ProductEventProducer;
import com.example.tmc.repositories.CategoryRepository;
import com.example.tmc.repositories.ProductRepository;
import com.example.tmc.interactors.ProductCommandService;
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
