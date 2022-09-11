package com.example.tmc.infrastructure.adapters.output.persistence.repository;

import com.example.tmc.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
