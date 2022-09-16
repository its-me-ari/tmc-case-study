package com.example.tmc.repositories;

import com.example.tmc.entities.CategoryDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryElasticRepository extends ElasticsearchRepository<CategoryDocument, String> {
}
