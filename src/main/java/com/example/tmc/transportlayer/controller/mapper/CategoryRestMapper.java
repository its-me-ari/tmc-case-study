package com.example.tmc.transportlayer.controller.mapper;

import com.example.tmc.entities.Category;
import com.example.tmc.transportlayer.controller.dto.command.CategoryCommandDto;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRestMapper {

    Category toCategory(CategoryCommandDto categoryCommandDto);

}
