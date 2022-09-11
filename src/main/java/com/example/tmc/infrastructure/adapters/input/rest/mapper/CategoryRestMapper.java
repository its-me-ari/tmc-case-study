package com.example.tmc.infrastructure.adapters.input.rest.mapper;

import com.example.tmc.domain.model.Category;
import com.example.tmc.infrastructure.adapters.input.rest.data.request.CategoryCreateRequest;
import com.example.tmc.infrastructure.adapters.input.rest.data.response.CategoryCreateResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRestMapper {

    Category toCategory(CategoryCreateRequest categoryCreateRequest);

    CategoryCreateResponse toCategoryCreateResponse(Category category);

}
