package com.example.tmc.cqrs.repository;

import com.example.tmc.cqrs.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, String> {
}