package com.example.tmccasestudy.command.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    private String id;
    private String sku;
    private String name;
    private Integer price;
    private Integer stock;
    private String categoryId;
    private Long createdAt;

}
