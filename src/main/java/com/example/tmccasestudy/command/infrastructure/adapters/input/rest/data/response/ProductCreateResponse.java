package com.example.tmccasestudy.command.infrastructure.adapters.input.rest.data.response;

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

    private String categoryId;
    private Long createdAt;

}
