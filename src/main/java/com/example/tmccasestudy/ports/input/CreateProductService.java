package com.example.tmccasestudy.ports.input;

import com.example.tmccasestudy.adapters.input.rest.data.ProductRequest;
import com.example.tmccasestudy.domain.Product;

public interface CreateProductService {
    Product save(ProductRequest product);
}
