package com.example.tmc.repositories.datasources.adapter;

import com.example.tmc.entities.Product;
import com.example.tmc.entities.ProductDocument;
import com.example.tmc.repositories.ProductElasticRepository;
import com.example.tmc.repositories.ProductJpaRepository;
import com.example.tmc.repositories.ProductRepository;
import com.example.tmc.repositories.datasources.dao.ProductDao;
import com.example.tmc.repositories.datasources.mapper.ProductRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    private final ProductElasticRepository productElasticRepository;

    private final ProductRepositoryMapper productRepositoryMapper;

    @Override
    public Product saveProduct(Product product) {
        ProductDao productDao = productRepositoryMapper.toProductDao(product);
        productDao = productJpaRepository.save(productDao);

        return productRepositoryMapper.toProduct(productDao);
    }

    @Override
    public Product saveDocument(Product product) {
        ProductDocument productDocument = productRepositoryMapper.toProductDocument(product);
        productDocument = productElasticRepository.save(productDocument);

        return productRepositoryMapper.toProduct(productDocument);
    }

}
