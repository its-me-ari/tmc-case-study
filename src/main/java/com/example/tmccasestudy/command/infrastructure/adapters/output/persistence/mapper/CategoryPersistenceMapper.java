package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.mapper;

import com.example.tmccasestudy.command.domain.model.Category;
import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity.CategoryDocument;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryPersistenceMapper {
    CategoryDocument toCategoryDocument(Category category);

}
