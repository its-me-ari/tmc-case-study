package com.example.tmc.infrastructure.adapters.input.rest.data.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedRequest {

    private String sku;
    private String name;
    private Integer price;
    private Integer stock;
    private String categoryId;

}
