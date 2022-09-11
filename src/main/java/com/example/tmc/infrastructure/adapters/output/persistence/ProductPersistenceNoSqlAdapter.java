package com.example.tmc.infrastructure.adapters.output.persistence;

import com.example.tmc.application.ports.output.ProductOutputNoSqlPort;
import com.example.tmc.domain.model.Product;
import com.example.tmc.infrastructure.adapters.output.persistence.entity.ProductDocument;
import com.example.tmc.infrastructure.adapters.output.persistence.mapper.ProductPersistenceNoSqlMapper;
import com.example.tmc.infrastructure.adapters.output.persistence.repository.ProductNoSqlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductPersistenceNoSqlAdapter implements ProductOutputNoSqlPort {
    private final ProductNoSqlRepository productNoSqlRepository;
    private final ProductPersistenceNoSqlMapper productPersistenceNoSqlMapper;
    @Override
    public Product saveProduct(Product product) {
        ProductDocument productDocument = productPersistenceNoSqlMapper.toProductDocument(product);
        productDocument = productNoSqlRepository.save(productDocument);
        log.info("Product Saved {}", productDocument);
        return productPersistenceNoSqlMapper.toProduct(productDocument);
    }
}
