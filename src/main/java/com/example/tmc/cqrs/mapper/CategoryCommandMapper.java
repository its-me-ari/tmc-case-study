package com.example.tmc.cqrs.mapper;

import com.example.tmc.cqrs.dto.CategoryCommandDto;
import com.example.tmc.cqrs.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryCommandMapper {

    Category toCategory(CategoryCommandDto categoryCommandDto);
}
