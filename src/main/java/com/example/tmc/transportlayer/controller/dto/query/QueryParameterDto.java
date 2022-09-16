package com.example.tmc.transportlayer.controller.dto.query;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueryParameterDto {

    private List<String> sku;
    private List<String> name;
    private PriceParameterDto price;
    private StockParameterDto stock;
    private CategoryParameterDto category;
}
