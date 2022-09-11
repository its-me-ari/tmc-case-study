package com.example.tmc.infrastructure.adapters.output.persistence.repository;

import com.example.tmc.infrastructure.adapters.output.persistence.entity.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductNoSqlRepository extends ElasticsearchRepository<ProductDocument, String> {
}
