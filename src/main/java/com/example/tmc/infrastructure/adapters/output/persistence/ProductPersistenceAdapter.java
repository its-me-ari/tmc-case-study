package com.example.tmc.infrastructure.adapters.output.persistence;

import com.example.tmc.application.ports.output.ProductOutputPort;
import com.example.tmc.domain.model.Product;
import com.example.tmc.infrastructure.adapters.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
