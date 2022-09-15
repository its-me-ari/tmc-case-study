package com.example.tmc.cqrs.service.impl;

import com.example.tmc.cqrs.dto.QueryParameter;
import com.example.tmc.cqrs.entity.ProductDocument;
import com.example.tmc.cqrs.repository.ProductElasticRepository;
import com.example.tmc.cqrs.service.SearchQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchQueryServiceImpl implements SearchQueryService {

    private final ProductElasticRepository productElasticRepository;

    @Override
    public List<ProductDocument> search(QueryParameter queryParameter) {

        final boolean hasSku = !CollectionUtils.isEmpty(queryParameter.getSku());
        if (hasSku)
            return productElasticRepository.findBySkuIn(queryParameter.getSku());

        final boolean hasName = !CollectionUtils.isEmpty(queryParameter.getName());
        if (hasName)
            return productElasticRepository.findByNameIn(queryParameter.getName());

        return null;
    }
}
