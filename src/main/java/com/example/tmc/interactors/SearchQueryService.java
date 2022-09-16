package com.example.tmc.interactors;

import com.example.tmc.transportlayer.controller.dto.query.QueryParameterDto;
import com.example.tmc.entities.ProductDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchQueryService {

    Page<ProductDocument> search(QueryParameterDto searchQueryDto, Pageable pageable);
}
