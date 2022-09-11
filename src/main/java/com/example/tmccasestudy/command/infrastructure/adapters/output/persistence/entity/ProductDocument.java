package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDocument {

    @Id
    private String id;
    private String sku;
    private String name;
    private Integer price;
    private Integer stock;
    private String categoryId;
    private Long createdAt;

}
