package com.example.tmc.datasources;

import com.example.tmc.entities.Product;
import com.example.tmc.entities.ProductDocument;
import com.example.tmc.transportlayer.controller.mapper.ProductCommandMapper;
import com.example.tmc.repositories.ProductElasticRepository;
import com.example.tmc.repositories.ProductJpaRepository;
import com.example.tmc.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    private final ProductElasticRepository productElasticRepository;

    private final ProductCommandMapper productCommandMapper;

    @Override
    public Product saveProduct(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public Product saveDocument(Product product) {
        ProductDocument productDocument = productCommandMapper.toProductDocument(product);
        productDocument = productElasticRepository.save(productDocument);
        return productCommandMapper.toProduct(productDocument);
    }

}
