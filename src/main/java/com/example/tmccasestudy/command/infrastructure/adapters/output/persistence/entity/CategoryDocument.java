package com.example.tmccasestudy.command.infrastructure.adapters.output.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "category")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDocument {

    @Id
    private String id;
    private String name;
    private Long createdAt;

}
