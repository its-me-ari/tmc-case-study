package com.example.tmc.application.ports.input;

import com.example.tmc.domain.model.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);

}
