package com.example.tmc.repositories.datasources.dao;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductDao {

    @Id
    private String id;

    private String sku;

    private String name;

    private Integer price;
    private Integer stock;
    @OneToOne
    private CategoryDao category;
    private Long createdAt;
}
