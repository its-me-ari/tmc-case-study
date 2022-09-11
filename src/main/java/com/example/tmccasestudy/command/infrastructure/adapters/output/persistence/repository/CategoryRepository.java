package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.repository;

import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
}