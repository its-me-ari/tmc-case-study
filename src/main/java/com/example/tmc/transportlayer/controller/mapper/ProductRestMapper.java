package com.example.tmc.transportlayer.controller.mapper;

import com.example.tmc.entities.Product;
import com.example.tmc.transportlayer.controller.dto.command.ProductCommandDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductRestMapper {

    @Mapping(source = "categoryId", target = "category.id")
    Product toProduct(ProductCommandDto productCommandDto);

}
