package com.example.tmc.infrastructure.adapters.output.persistence.repository;

import com.example.tmc.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
