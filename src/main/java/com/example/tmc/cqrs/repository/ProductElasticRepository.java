package com.example.tmc.cqrs.repository;

import com.example.tmc.cqrs.entity.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductElasticRepository extends ElasticsearchRepository<ProductDocument, String> {

    List<ProductDocument> findBySkuIn(List<String> sku);

    List<ProductDocument> findByNameIn(List<String> name);

    List<ProductDocument> findByPriceBetween(Integer startPrice, Integer endPrice);

    List<ProductDocument> findByStockBetween(Integer startPrice, Integer endPrice);
}
