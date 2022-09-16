package com.example.tmc.transportlayer.controller.query;

import com.example.tmc.transportlayer.controller.dto.query.QueryParameterDto;
import com.example.tmc.entities.ProductDocument;
import com.example.tmc.interactors.SearchQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/search")
@RequiredArgsConstructor
public class SearchQueryController {

    private final SearchQueryService searchQueryService;

    @GetMapping
    public ResponseEntity<Map<String, ?>> search(
            QueryParameterDto queryParameter,
            @PageableDefault(size = 10) Pageable pageable) {

        final Page<ProductDocument> products = searchQueryService.search(queryParameter, pageable);

        Map<String, Integer> paging = new HashMap<>();
        paging.put("size", products.getSize());
        paging.put("total", products.getTotalPages());
        paging.put("current", products.getNumber() + 1);

        Map<String, Object> payload = new HashMap<>();
        payload.put("data", products.getContent());
        payload.put("paging", paging);

        return new ResponseEntity<>(payload, HttpStatus.OK);
    }
}
