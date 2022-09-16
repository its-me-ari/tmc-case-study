package com.example.tmc.repositories;

import com.example.tmc.entities.ProductDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductElasticRepository extends ElasticsearchRepository<ProductDocument, String> {

    Page<ProductDocument> findBySkuIn(List<String> sku, Pageable pageable);

    Page<ProductDocument> findByNameIn(List<String> name, Pageable pageable);

    Page<ProductDocument> findByPriceBetween(Integer startPrice, Integer endPrice, Pageable pageable);

    Page<ProductDocument> findByStockBetween(Integer startPrice, Integer endPrice, Pageable pageable);
}
