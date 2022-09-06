package com.example.tmccasestudy.adapters.output.persistence;

import com.example.tmccasestudy.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataProductRepository extends JpaRepository<Product, String> {
}
