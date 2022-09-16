package com.example.tmc.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "category_index")
public class CategoryDocument {

    @Id
    private String id;

    private String name;

    private Long createdAt;
}
