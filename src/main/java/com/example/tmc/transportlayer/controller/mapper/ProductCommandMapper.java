package com.example.tmc.transportlayer.controller.mapper;

import com.example.tmc.transportlayer.controller.dto.command.ProductCommandDto;
import com.example.tmc.entities.Product;
import com.example.tmc.entities.ProductDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductCommandMapper {

    @Mapping(source = "categoryId", target = "category.id")
    Product toProduct(ProductCommandDto productCommandDto);

    ProductDocument toProductDocument(Product product);

    Product toProduct(ProductDocument productDocument);

}
