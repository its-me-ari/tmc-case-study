package com.example.tmc.cqrs.repository;

import com.example.tmc.cqrs.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, String> {
}
