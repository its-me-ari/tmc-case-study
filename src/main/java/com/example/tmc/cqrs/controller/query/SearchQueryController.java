package com.example.tmc.cqrs.controller.query;

import com.example.tmc.cqrs.dto.QueryParameter;
import com.example.tmc.cqrs.entity.ProductDocument;
import com.example.tmc.cqrs.service.SearchQueryService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Map<String, ?>> search(QueryParameter queryParameter) {

        final List<ProductDocument> products = searchQueryService.search(queryParameter);

        Map<String, Object> payload = new HashMap<>();
        payload.put("data", products);

        return new ResponseEntity<>(payload, HttpStatus.OK);
    }
}
