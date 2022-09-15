package com.example.tmc.cqrs.controller.query;

import com.example.tmc.cqrs.dto.query.QueryParameter;
import com.example.tmc.cqrs.entity.ProductDocument;
import com.example.tmc.cqrs.service.SearchQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/search")
@RequiredArgsConstructor
public class SearchQueryController {

    private final SearchQueryService searchQueryService;

    @GetMapping
    public ResponseEntity<Map<String, ?>> search(
            QueryParameter queryParameter,
            Pageable pageable) {

        final Page<ProductDocument> products = searchQueryService.search(queryParameter, pageable);

        Map<String, Object> payload = new HashMap<>();
        payload.put("data", products);

        return new ResponseEntity<>(payload, HttpStatus.OK);
    }
}
