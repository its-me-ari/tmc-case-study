package com.example.tmc.repositories;

import com.example.tmc.repositories.datasources.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductDao, String> {
}
