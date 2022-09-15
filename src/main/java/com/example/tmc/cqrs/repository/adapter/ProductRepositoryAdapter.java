package com.example.tmc.cqrs.repository.adapter;

import com.example.tmc.cqrs.entity.Product;
import com.example.tmc.cqrs.entity.ProductDocument;
import com.example.tmc.cqrs.mapper.ProductCommandMapper;
import com.example.tmc.cqrs.repository.ProductElasticRepository;
import com.example.tmc.cqrs.repository.ProductJpaRepository;
import com.example.tmc.cqrs.repository.ProductRepository;
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
