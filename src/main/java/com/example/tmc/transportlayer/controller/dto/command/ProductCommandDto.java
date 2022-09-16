package com.example.tmc.transportlayer.controller.dto.command;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCommandDto {

    private String sku;
    private String name;
    private Integer price;
    private Integer stock;
    private String categoryId;
}
