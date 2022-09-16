package com.example.tmc.transportlayer.controller.dto.query;

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
    private PriceParameter price;
    private StockParameter stock;
    private CategoryParameter category;
}
