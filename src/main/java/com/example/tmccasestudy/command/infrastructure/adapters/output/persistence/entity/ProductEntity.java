package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    private String id;
    private String sku;
    private String name;
    private Integer price;
    private Integer stock;
    private String categoryId;
    private Long createdAt;

}
