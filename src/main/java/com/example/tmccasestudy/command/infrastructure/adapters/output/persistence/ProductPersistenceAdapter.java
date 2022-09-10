package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence;

import com.example.tmccasestudy.command.application.ports.output.ProductOutputPort;
import com.example.tmccasestudy.command.domain.model.Product;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity.ProductEntity;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toProductEntity(product);
        productEntity = productRepository.save(productEntity);
        return productPersistenceMapper.toProduct(productEntity);
    }
}
