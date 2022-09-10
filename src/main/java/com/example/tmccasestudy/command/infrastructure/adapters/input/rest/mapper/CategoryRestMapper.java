package com.example.tmccasestudy.command.infrastructure.adapters.input.rest.mapper;

import com.example.tmccasestudy.command.domain.model.Category;
import com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.request.CategoryCreateRequest;
import com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.response.CategoryCreateResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRestMapper {

    Category toCategory(CategoryCreateRequest categoryCreateRequest);

    CategoryCreateResponse toCategoryCreateResponse(Category category);

}
