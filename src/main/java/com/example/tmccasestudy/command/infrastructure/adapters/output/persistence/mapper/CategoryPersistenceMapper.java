package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.mapper;

import com.example.tmccasestudy.command.domain.model.Category;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity.CategoryDocument;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryPersistenceMapper {

    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);

    CategoryDocument toCategoryDocument(Category category);

}
