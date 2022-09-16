package com.example.tmc.transportlayer.controller.mapper;

import com.example.tmc.transportlayer.controller.dto.command.CategoryCommandDto;
import com.example.tmc.entities.Category;
import com.example.tmc.entities.CategoryDocument;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryCommandMapper {

    Category toCategory(CategoryCommandDto categoryCommandDto);

    CategoryDocument toCategoryDocument(Category category);

    Category toCategory(CategoryDocument categoryDocument);
}
