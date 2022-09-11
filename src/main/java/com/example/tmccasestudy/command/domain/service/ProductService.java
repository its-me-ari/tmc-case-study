package com.example.tmccasestudy.command.domain.service;

import com.example.tmccasestudy.command.application.ports.input.CreateProductUseCase;
import com.example.tmccasestudy.command.application.ports.output.ProductEventPublisher;
import com.example.tmccasestudy.command.application.ports.output.ProductOutputPort;
import com.example.tmccasestudy.command.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService implements CreateProductUseCase {

    private final ProductOutputPort productOutputPort;

    private final ProductEventPublisher productEventPublisher;

    @Override
    public Product createProduct(@Valid Product product) {
        product.setId(UUID.randomUUID().toString());
        product.setCreatedAt(System.currentTimeMillis());
        product = productOutputPort.saveProduct(product);
        productEventPublisher.publishProductCreateEvent(product);
        return product;
    }
}
