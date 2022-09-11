package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.repository;

import com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity.CategoryDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryNoSqlRepository extends ElasticsearchRepository<CategoryDocument, String> {
}
