package com.example.tmccasestudy.adapters.output.persistence;

import com.example.tmccasestudy.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCategoryRepository extends JpaRepository<Category, String> {
}
