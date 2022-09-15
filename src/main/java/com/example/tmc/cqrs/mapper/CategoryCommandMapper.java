package com.example.tmc.cqrs.mapper;

import com.example.tmc.cqrs.dto.command.CategoryCommandDto;
import com.example.tmc.cqrs.entity.Category;
import com.example.tmc.cqrs.entity.CategoryDocument;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryCommandMapper {

    Category toCategory(CategoryCommandDto categoryCommandDto);

    CategoryDocument toCategoryDocument(Category category);

    Category toCategory(CategoryDocument categoryDocument);
}
