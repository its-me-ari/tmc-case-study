package com.example.tmc.cqrs.service.impl;

import com.example.tmc.cqrs.dto.SearchQueryDto;
import com.example.tmc.cqrs.entity.ProductDocument;
import com.example.tmc.cqrs.repository.ProductElasticRepository;
import com.example.tmc.cqrs.service.SearchQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchQueryServiceImpl implements SearchQueryService {

    private final ProductElasticRepository productElasticRepository;

    @Override
    public List<ProductDocument> search(SearchQueryDto searchQueryDto) {
        final boolean hasSku = !searchQueryDto.getSku().isEmpty();
        if (hasSku) {
            return productElasticRepository.findBySkuIn(searchQueryDto.getSku());
        }
        return null;
    }
}
