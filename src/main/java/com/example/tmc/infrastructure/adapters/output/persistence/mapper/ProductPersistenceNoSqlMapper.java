package com.example.tmc.infrastructure.adapters.output.persistence.mapper;

import com.example.tmc.domain.model.Product;
import com.example.tmc.infrastructure.adapters.output.persistence.entity.ProductDocument;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceNoSqlMapper {

    ProductDocument toProductDocument(Product product);

    Product toProduct(ProductDocument productDocument);
}
