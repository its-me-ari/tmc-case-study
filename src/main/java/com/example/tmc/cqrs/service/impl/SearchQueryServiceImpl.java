package com.example.tmc.cqrs.service.impl;

import com.example.tmc.cqrs.dto.query.QueryParameter;
import com.example.tmc.cqrs.entity.ProductDocument;
import com.example.tmc.cqrs.repository.ProductElasticRepository;
import com.example.tmc.cqrs.service.SearchQueryService;
import com.example.tmc.cqrs.util.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchQueryServiceImpl implements SearchQueryService {

    private final ProductElasticRepository productElasticRepository;

    @Override
    public Page<ProductDocument> search(QueryParameter queryParameter, Pageable pageable) {

        final boolean hasSku = ObjectUtils.isNotEmpty(queryParameter.getSku());
        if (hasSku)
            return productElasticRepository.findBySkuIn(queryParameter.getSku(), pageable);

        final boolean hasName = ObjectUtils.isNotEmpty(queryParameter.getName());
        if (hasName)
            return productElasticRepository.findByNameIn(queryParameter.getName(), pageable);

        final boolean hasPrice = ObjectUtils.isNotNull(queryParameter.getPrice());
        if (hasPrice) {
            int startPrice = queryParameter.getPrice().getStart();
            int endPrice = queryParameter.getPrice().getEnd();
            return productElasticRepository.findByPriceBetween(startPrice, endPrice, pageable);
        }

        final boolean hasStock = ObjectUtils.isNotNull(queryParameter.getStock());
        if (hasStock) {
            int startStock = queryParameter.getStock().getStart();
            int endStock = queryParameter.getStock().getEnd();
            return productElasticRepository.findByStockBetween(startStock, endStock, pageable);
        }

        return null;
    }
}
