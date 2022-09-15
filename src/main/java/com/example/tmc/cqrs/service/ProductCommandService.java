package com.example.tmc.cqrs.service;

import com.example.tmc.cqrs.entity.Product;

public interface ProductCommandService {

    Product createProduct(Product product);

    Product createDocument(Product product);
}
