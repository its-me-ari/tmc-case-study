package com.example.tmc.repositories;

import com.example.tmc.repositories.datasources.dao.CategoryDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryDao, String> {
}
