package com.example.tmc.repositories.datasources.mapper;

import com.example.tmc.entities.Category;
import com.example.tmc.entities.CategoryDocument;
import com.example.tmc.repositories.datasources.dao.CategoryDao;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryRepositoryMapper {

    CategoryDao toCategoryDao(Category category);

    Category toCategory(CategoryDao categoryDao);

    CategoryDocument toCategoryDocument(Category category);

    Category toCategory(CategoryDocument categoryDocument);
}
