package com.example.tmccasestudy.adapters.output.persistence;

import com.example.tmccasestudy.domain.Product;
import com.example.tmccasestudy.ports.output.SaveProductPort;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements SaveProductPort {

    private SpringDataProductRepository repository;

    public ProductRepository(SpringDataProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }
}
