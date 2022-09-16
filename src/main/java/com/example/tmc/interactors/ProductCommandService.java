package com.example.tmc.interactors;

import com.example.tmc.entities.Product;

public interface ProductCommandService {

    Product createProduct(Product product);

    Product createDocument(Product product);
}
