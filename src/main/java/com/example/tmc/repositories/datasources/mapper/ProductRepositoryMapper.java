package com.example.tmc.repositories.datasources.mapper;

import com.example.tmc.entities.Product;
import com.example.tmc.entities.ProductDocument;
import com.example.tmc.repositories.datasources.dao.ProductDao;
import org.mapstruct.Mapper;

@Mapper
public interface ProductRepositoryMapper {

    ProductDao toProductDao(Product product);

    Product toProduct(ProductDao productDao);

    ProductDocument toProductDocument(Product product);

    Product toProduct(ProductDocument productDocument);
}
