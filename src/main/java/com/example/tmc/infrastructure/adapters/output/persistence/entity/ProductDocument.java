package com.example.tmc.infrastructure.adapters.output.persistence.entity;

import com.example.tmc.domain.model.Category;
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
    private Category category;
    private Long createdAt;

}
