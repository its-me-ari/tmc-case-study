package com.example.tmc.cqrs.repository.adapter;

import com.example.tmc.cqrs.entity.Product;
import com.example.tmc.cqrs.repository.ProductJpaRepository;
import com.example.tmc.cqrs.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product saveProduct(Product product) {
        return productJpaRepository.save(product);
    }

}
