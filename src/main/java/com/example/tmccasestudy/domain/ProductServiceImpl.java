package com.example.tmccasestudy.domain;

import com.example.tmccasestudy.adapters.input.rest.data.ProductRequest;
import com.example.tmccasestudy.ports.input.CreateProductService;
import com.example.tmccasestudy.ports.output.SaveProductPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements CreateProductService {

    private SaveProductPort saveProductPort;

    public ProductServiceImpl(SaveProductPort saveProductPort) {
        this.saveProductPort = saveProductPort;
    }

    @Override
    public Product save(ProductRequest product) {
        Product newProduct = new Product();
        newProduct.setId(UUID.randomUUID().toString());
        newProduct.setSku(product.getSku());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setStock(product.getStock());
        Category category = new Category();
        category.setId(product.getCategoryId());
        newProduct.setCreatedAt(System.currentTimeMillis());
        saveProductPort.save(newProduct);
        return newProduct;
    }
}
