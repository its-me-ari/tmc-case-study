package com.example.tmc.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "product_index")
public class ProductDocument {

    @Id
    private String id;
    private String sku;
    private String name;
    private Integer price;
    private Integer stock;
    private Category category;
    private Long createdAt;
}
