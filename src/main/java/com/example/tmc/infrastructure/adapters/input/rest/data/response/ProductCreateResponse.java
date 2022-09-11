package com.example.tmc.infrastructure.adapters.input.rest.data.response;

import com.example.tmc.domain.model.Category;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateResponse {
    private String id;
    private String sku;

    private String name;

    private Integer price;

    private Integer stock;

    private Category category;
    private Long createdAt;

}