package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.mapper;

import com.example.tmccasestudy.command.domain.model.Product;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);

}
