package com.example.tmc.infrastructure.adapters.input.rest;

import com.example.tmc.infrastructure.adapters.output.persistence.entity.ProductDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHitSupport;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/search")
@RequiredArgsConstructor
public class SearchRestAdapter {

    private final ElasticsearchOperations elasticsearchOperations;
    @GetMapping
    public ResponseEntity<Map<String, Object>> searchProduct(
            @RequestParam(required = false) List<String> sku,
            @RequestParam(required = false) List<String> name) {

        Criteria criteria = new Criteria();

        if (sku != null) {
            Criteria skuCriteria = new Criteria("sku").in(sku);
            criteria.and(skuCriteria);
        }
        if (name != null) {
            Criteria nameCriteria = new Criteria("name").in(name);
            criteria.and(nameCriteria);
        }

        Query searchQuery = new CriteriaQuery(criteria);

        SearchHits<ProductDocument> products = elasticsearchOperations.search(searchQuery, ProductDocument.class);
        SearchPage<ProductDocument> page = SearchHitSupport.searchPageFor(products, searchQuery.getPageable());

        Map<String, Object> paging = new HashMap<>();
        paging.put("size", page.getTotalElements());
        paging.put("total", page.getTotalPages());
        paging.put("current", page.getNumber());

        Map<String, Object> response = new HashMap<>();
        response.put("data", products.stream().map(product -> product.getContent()).collect(Collectors.toList()));
        response.put("paging", paging);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
