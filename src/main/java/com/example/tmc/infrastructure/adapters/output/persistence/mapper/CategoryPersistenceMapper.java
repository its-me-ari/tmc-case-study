package com.example.tmc.infrastructure.adapters.output.persistence.mapper;

import com.example.tmc.domain.model.Category;
import com.example.tmc.infrastructure.adapters.output.persistence.entity.CategoryDocument;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryPersistenceMapper {
    CategoryDocument toCategoryDocument(Category category);

}
