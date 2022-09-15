package com.example.tmc.cqrs.service;

import com.example.tmc.cqrs.dto.query.QueryParameter;
import com.example.tmc.cqrs.entity.ProductDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchQueryService {

    Page<ProductDocument> search(QueryParameter searchQueryDto, Pageable pageable);
}
