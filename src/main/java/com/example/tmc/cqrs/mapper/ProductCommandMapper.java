package com.example.tmc.cqrs.mapper;

import com.example.tmc.cqrs.dto.ProductCommandDto;
import com.example.tmc.cqrs.entity.Product;
import com.example.tmc.cqrs.entity.ProductDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductCommandMapper {

    @Mapping(source = "categoryId", target = "category.id")
    Product toProduct(ProductCommandDto productCommandDto);

    ProductDocument toProductDocument(Product product);

    Product toProduct(ProductDocument productDocument);

}
