package com.example.tmccasestudy.command.infrastructure.adapters.input.rest.mapper;

import com.example.tmccasestudy.command.domain.model.Product;
import com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.request.ProductCreatedRequest;
import com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.response.ProductCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductRestMapper {

    @Mapping(source = "categoryId", target = "category.id")
    Product toProduct(ProductCreatedRequest productCreatedRequest);

    ProductCreateResponse toProductCreateResponse(Product product);

}
