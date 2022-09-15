package com.example.tmc.cqrs.repository;

import com.example.tmc.cqrs.entity.CategoryDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryElasticRepository extends ElasticsearchRepository<CategoryDocument, String> {
}
