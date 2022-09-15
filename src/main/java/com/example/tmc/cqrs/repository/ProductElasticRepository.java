package com.example.tmc.cqrs.repository;

import com.example.tmc.cqrs.entity.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductElasticRepository extends ElasticsearchRepository<ProductDocument, String> {
}
