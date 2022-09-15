package com.example.tmc.cqrs.controller.query;

import com.example.tmc.cqrs.dto.SearchQueryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/search")
public class SearchQueryController {

    @GetMapping
    public String search(SearchQueryDto searchQueryDto) {

        return "Hello";
    }
}
