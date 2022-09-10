package com.example.tmccasestudy.command.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String id;
    private String sku;
    private String name;
    private Integer price;
    private Integer stock;
    private String categoryId;
    private Long createdAt;

}
