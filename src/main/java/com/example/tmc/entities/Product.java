package com.example.tmc.entities;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String id;

    @NotEmpty(message = "sku is empty")
    private String sku;

    @NotEmpty(message = "name is empty")
    @Size(max = 255, message = "name length must not more than 255 characters")
    private String name;

    @Min(value = 0, message = "price must not negative")
    private Integer price;
    private Integer stock;

    private Category category;
    private Long createdAt;
}
