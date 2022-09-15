package com.example.tmc.cqrs.dto.query;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueryParameter {

    private List<String> sku;
    private List<String> name;
    private SearchQueryPriceDto price;
    private SearchQueryStockDto stock;
    private SearchQueryCategoryDto category;
}
