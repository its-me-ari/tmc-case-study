package com.example.tmc.cqrs.service;

import com.example.tmc.cqrs.dto.QueryParameter;
import com.example.tmc.cqrs.entity.ProductDocument;

import java.util.List;

public interface SearchQueryService {

    List<ProductDocument> search(QueryParameter searchQueryDto);
}
